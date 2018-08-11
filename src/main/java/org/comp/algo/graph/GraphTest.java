package org.comp.algo.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

import org.comp.algo.graph.GraphDS.Graph;

public class GraphTest {
    Graph g = GraphDS.GraphFactory.getTiny();
    

    @Test
    public void test() {

        g.print();

        boolean[] visited = new boolean[12];
        for (Integer i : g.V()) {
            if (visited[i]) {
                dfs(g, i, visited);
            }
        }

    }

    private void dfs(Graph g, Integer i, boolean[] visited) {
        visited[i] = true;
        for (Integer adj : g.adj(i)) {
            if (visited[adj]) {
                continue;
            }
            dfs(g, adj, visited);
        }
    }
    
    @Test
    public void bfs()  {
        g.print();
        LinkedList<Integer> path = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        boolean[] visited = new boolean[12];
        visited[0]=true;
        while(!queue.isEmpty()) {
            Integer i = queue.poll();
            path.add(i);
            for(int c : g.adj(i)) {
                if(!visited[c]) {
                    visited[c] = true;
                    queue.add(c);
                }
            }
        }
        System.out.println(path);
    }

    @Test
    public void pathBetweentwoComponent() {
        int a = 0;
        int b = 8;
        LinkedList<Integer> path=new LinkedList<>();
        boolean[] visited = new boolean[12];
        path.add(0);
        boolean dfsPathBetweentwo = dfsPathBetweentwo(g, a,b, visited, path);
        System.out.println(dfsPathBetweentwo);
        System.out.println(path);
    }
    
    private boolean dfsPathBetweentwo(Graph g, Integer i,Integer s, boolean[] visited,LinkedList<Integer> path) { 
        visited[i] = true;
        if(visited[s]==true) {
            return true;
        }
        for (Integer adj : g.adj(i)) {
            if (visited[adj]) {
                continue;
            }
            path.add(adj);
            boolean st = dfsPathBetweentwo(g, adj, s, visited, path);
            if(st) {
                return true;
            }
        }
        return false;
    }
    
   @Test
   public void a2d_array() {
       String a ="abcd";
       String b="efg";
       char[] ch1 = a.toCharArray();
       char[] ch2 = b.toCharArray();
       List<String> s = new ArrayList<>();
       for(int i =0; i < ch1.length ; i++) {
           for(int j =0; j < ch2.length ; j++) {
               s.add(String.valueOf(ch1[i])+String.valueOf(ch1[j]));
           }
       }
       System.out.println(s);
   }

}

