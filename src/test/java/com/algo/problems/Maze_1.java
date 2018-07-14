package com.algo.problems;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import org.junit.Test;

import com.ds.ClassUtil.TwDPt;

/**
 * find the way out of the maze
 *
 * @author pulkitmehra
 */
public class Maze_1 {

    //@formatter:off
    int[][] maze = new int[][]{
            new int[]{0, 0, 1, 0, 0},
            new int[]{1, 0, 0, 0, 0},
            new int[]{0, 1, 0, 1, 0},
            new int[]{0, 0, 0, 1, 0},
            new int[]{0, 0, 0, 0, 0},
    };

    //@formatter:on
    @Test
    public void maze_search_by_dfs() {
        LinkedList<TwDPt> trace = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze.length + 1];
        int[] s = new int[]{0, 4};
        int[] d = new int[]{4, 0};
        searchDfs(maze, trace, visited, s[0], s[1], d);
        System.out.println(trace);
    }

    boolean searchDfs(int[][] maze, LinkedList<TwDPt> trace, boolean[][] visited, int y, int x, int[] d) {

        if (y < 0 || y > maze.length - 1 || x < 0 || x > maze[y].length - 1 || visited[y][x]) {
            return false;
        }

        visited[y][x] = true;
        if (maze[y][x] == 1) {
            return false;
        }
        trace.addLast(TwDPt.get(y, x));
        if (y == d[0] && x == d[1]) {
            return true;
        }
        if (searchDfs(maze, trace, visited, y - 1, x, d) || searchDfs(maze, trace, visited, y + 1, x, d)
                || searchDfs(maze, trace, visited, y, x - 1, d) || searchDfs(maze, trace, visited, y, x + 1, d)) {
            return true;
        }
        trace.removeLast();
        return false;
    }

    @Test
    public void searchByBFS() {
        Map<TwDPt, TwDPt> trace = new HashMap<>();
        boolean[][] visited = new boolean[maze.length][maze.length + 1];
        int[] s = new int[]{0, 4};
        int[] d = new int[]{4, 0};
        System.out.println(searchMazebfs(maze, trace, visited, s[0], s[1], d));
        backtrackTrace(trace, d);
        //System.out.println(searchMazebfs2(maze, trace, visited, s[0], s[1], d));

    }

    private void backtrackTrace(Map<TwDPt, TwDPt> trace, int[] d) {

        TwDPt dest = TwDPt.get(d[0], d[1]);
        TwDPt parent = trace.get(dest);
        while (parent != null) {
            System.out.print(dest + "->");
            dest = parent;
            parent = trace.get(dest);
        }
        System.out.print(dest + "->");
    }

    private boolean searchMazebfs(int[][] maze2, Map<TwDPt, TwDPt> trace, boolean[][] visited, int y, int x, int[] d) {

        Queue<TwDPt> q = new LinkedList<>();
        q.offer(TwDPt.get(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            TwDPt f = q.poll();
            y = f.y;
            x = f.x;

            if (f.y == d[0] && f.x == d[1]) {
                return true;
            }

            List<TwDPt> adj = Arrays.asList(TwDPt.get(y + 1, x), TwDPt.get(y - 1, x), TwDPt.get(y, x - 1),
                    TwDPt.get(y, x + 1));
            for (TwDPt pt : adj) {
                if (pt.y < 0 || pt.y > maze.length - 1 || pt.x < 0 || pt.x > maze.length - 1 || visited[pt.y][pt.x]) {
                    continue;
                }
                visited[pt.y][pt.x] = true;
                if (maze[pt.y][pt.x] == 0) {
                    trace.put(pt, f);
                    q.offer(pt);
                }

            }
        }
        return false;

    }

    private boolean searchMazebfs2(int[][] maze2, Map<TwDPt, TwDPt> trace, boolean[][] visited, int y, int x, int[] d) {

        List<List<TwDPt>> mazeboard = new ArrayList<>();
        int i = 0;
        for (int[] arr : maze2) {
            List<TwDPt> list = new ArrayList<>();
            int j = 0;
            for (int pt : arr) {
                list.add(TwDPt.get(i, j, maze2[i][j]));
                j++;
            }
            mazeboard.add(list);
            i++;
        }

        Set<TwDPt> visit = new HashSet<>();
        ArrayDeque<TwDPt> q = new ArrayDeque<>();
        q.offer(TwDPt.get(y, x));

        while (!q.isEmpty()) {
            TwDPt u = q.poll();

            if (u.y == d[0] && u.x == d[1]) {
                return true;
            }
            for (TwDPt pt : Arrays.asList(
                    TwDPt.get(u.y + 1, u.x), TwDPt.get(u.y - 1, u.x),
                    TwDPt.get(u.y, u.x + 1), TwDPt.get(u.y, u.x - 1))) {
                int uy = pt.y;
                int ux = pt.x;
                if (uy >= 0 && uy <= mazeboard.size() - 1 && ux >= 0 &&
                        ux <= mazeboard.get(uy).size() - 1 && !visit.contains(pt) &&
                        mazeboard.get(uy).get(ux).v != 1) {
                    visit.add(pt);
                    trace.put(pt, u);
                    q.offer(pt);
                }
            }
        }
        return false;
    }

}
