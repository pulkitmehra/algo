package com.ds;

import org.junit.Test;

import java.util.*;
import java.util.Collections;

public class QuadTree {

    Rectangle boundary;
    boolean isDivided;
    QuadTree nw;
    QuadTree ne;
    QuadTree sw;

    QuadTree se;
    List<Point> pts = new ArrayList<>();
    int capacity = 4; //if element is more than 4 sub divided;

    static QuadTree get(Rectangle boundary) {
        QuadTree tree = new QuadTree();
        tree.boundary = boundary;
        return tree;
    }

    public QuadTree() {


    }

    @Test
    public void test(){
        int[] arr = {4,1,1,1,1,0};
        System.out.println(waitingTime(arr,2 ));
    }

    static long waitingTime(int[] arr, int p) {
        SpinWrapper pos = null;
        List<SpinWrapper> list = new ArrayList();


        for(int i=0; i<arr.length; i++){
            if(i==p){
                pos = SpinWrapper.get(i, arr[i]);
                list.add(pos);
            }else{
                list.add(SpinWrapper.get(i, arr[i]));
            }
        }
        final SpinWrapper finalPos = pos;
        Collections.sort(list, (a,b) -> {
            if(a==b){
                if(a==finalPos){
                    return -1;
                }else if(b==finalPos){
                    return 1;
                }
            }
            return Integer.compare(a.val,b.val);
        });

        int t =0;
        for(int j=0; j< list.size(); j++){
            SpinWrapper cur = list.get(j);
            int last = (j==0) ? 0 : list.get(j-1).val;
            t += ((cur.val-last) * (list.size()-j));
            if(pos==cur){
                break;
            }
        }
        return 0;
    }

    static class SpinWrapper{
        int idx=-1;
        int val;

        static SpinWrapper get(int idx, int val){
            SpinWrapper wrap = new SpinWrapper();
            wrap.idx = idx;
            wrap.val = val;
            return wrap;
        }
    }

    public boolean insert(Point pt) {

        //if intersect than add
        if (!this.boundary.contains(pt)) {
            return false;
        }

        //i
        if (pts.size() < capacity) {
            pts.add(pt);
            return true;
        } else {
            if (!isDivided) {
                subdivide();
                this.isDivided = true;
            }

            if(nw.insert(pt)) return true;
            if(ne.insert(pt)) return true;
            if(sw.insert(pt)) return true;
            if(se.insert(pt)) return true;
            return false;
        }
    }

    public void subdivide() {
        nw = QuadTree.get(Rectangle.get(boundary.ry + boundary.height / 2, boundary.rx, boundary.width / 2, boundary.height / 2));
        ne = QuadTree.get(Rectangle.get(boundary.ry + boundary.height / 2, boundary.rx + boundary.width / 2, boundary.width / 2, boundary.height / 2));
        sw = QuadTree.get(Rectangle.get(boundary.ry, boundary.rx, boundary.width / 2, boundary.height / 2));
        se = QuadTree.get(Rectangle.get(boundary.ry, boundary.rx + boundary.width / 2, boundary.width / 2, boundary.height / 2));
    }

    public void query(QuadTree tree, Rectangle range, List<Point> res){
        if(!tree.boundary.intersect(range)){
            return;
        }else{
            for (Point pt : tree.pts){
                if(range.contains(pt)){
                    res.add(pt);
                }
            }

            if(tree.isDivided) {
                tree.query(tree.nw, range, res);
                tree.query(tree.ne, range, res);
                tree.query(tree.sw, range, res);
                tree.query(tree.se, range, res);
            }
        }
    }


    public static class Point {
        int x;
        int y;

        static Point get(int y, int x) {
            Point p = new Point();
            p.y = y;
            p.x = x;
            return p;
        }

        @Override
        public String toString() {
            return "{" + y + "," + x + "}";
        }


    }

    public static class Rectangle {
        int width; //width
        int height; // height
        int rx;
        int ry;

        static Rectangle get(int ry, int rx, int width, int height) {
            Rectangle r = new Rectangle();
            r.width = width;
            r.height = height;
            r.rx = rx;
            r.ry = ry;
            return r;
        }

        @Override
        public String toString() {
            return " Boundary{ y=" + ry + ", x=" + rx + ", w=" + width + ", h=" + height + "}";
        }

        public boolean contains(Point pt) {
            return ry <= pt.y
                    && rx <= pt.x
                    && pt.x <= (rx + width)
                    && pt.y <= (ry + height);
        }

        public boolean intersect(Rectangle other){
            return  !(other.rx  > (this.rx + width) ||
                    other.ry  > (this.ry+height) ||
                    (other.rx + width) < this.rx ||
                    (other.ry + height) < this.ry);
        }
    }




    @Test
    public void testCapacity() {
        Random rand = new Random();
        Rectangle r = Rectangle.get(0, 0, 200, 200);
        QuadTree tree = QuadTree.get(r);
        for (int i = 0; i < 50; i++) {
            tree.insert(Point.get(rand.nextInt(200), rand.nextInt(200)));
        }

        print(tree);
        System.out.println("results.....");
        List<Point> res = new ArrayList<>();
        query(tree, Rectangle.get(30, 30, 75, 25),res);
        for (Point pt : res) {
            System.out.println(pt);
        }
        System.out.println(tree);
    }

    private void print(QuadTree tree) {
        if(tree == null) return;

        for (Point pt : tree.pts){
            System.out.println(pt + ""+tree.boundary);
        }
        print(tree.nw);
        print(tree.ne);
        print(tree.sw);
        print(tree.se);
    }
}
