package org.comp.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;



public class DiGraphTest {

    GraphDS.DiGraph g = GraphDS.GraphFactory.getDiTiny();

    @Test
    public void test() {
        g.print();
    }

    @Test
    public void pathBwtwonodes() {
        int s = 7;
        int d = 4;

        boolean[] visited = new boolean[13];
        LinkedList<Integer> path = new LinkedList<>();

        System.out.println(dfs(g, s, d, visited, path));
        System.out.println(path);
    }

    @Test
    public void shortestpathBwtwonodes() {
        int s = 0;
        int d = 11;

        boolean[] visited = new boolean[13];
        LinkedList<Integer> path = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while (!q.isEmpty()) {

            Integer e = q.poll();
            path.add(e);
            if (d == e) {
                System.out.println(true);
                break;
            }
            for (Integer c : g.adj(e)) {
                if (!visited[c]) {
                    visited[c] = true;
                    q.offer(c);
                }
            }
        }
        System.out.println(path);
    }

    public boolean dfs(GraphDS.DiGraph g, int s, int d, boolean[] visited, LinkedList<Integer> path) {
        visited[s] = true;
        path.add(s);
        if (s == d) {
            return true;
        }
        for (Integer c : g.adj(s)) {
            if (!visited[c]) {
                boolean flag = dfs(g, c, d, visited, path);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    enum state {
        p,
        c
    }

    @Test
    public void buildOrder() {
        GraphDS.DiGraph g = new GraphDS.DiGraph(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(3, 5);
        g.addEdge(2, 5);
        g.addEdge(5, 6);
        g.addEdge(8, 7);
        g.addEdge(7, 6);
        g.print();
        List<Integer> seq = new ArrayList<>();

        state[] visited = new state[8];

        for (int s : g.V()) {
            if (visited[s - 1] == null) {
                if (!buildOrder(g, s, seq, visited)) {
                    System.out.println("cannot build " + seq);
                    break;
                }
            }
        }
        System.out.println(seq);

    }

    public boolean buildOrder(GraphDS.DiGraph g, int s, List<Integer> seq, state[] visited) {
        visited[s - 1] = state.p;

        for (int c : g.adj(s)) {
            if (visited[c - 1] == null) {
                if (!buildOrder(g, c, seq, visited)) { // short circuit
                    return false;
                }
            } else if (visited[c - 1] == state.p) { // cycles
                return false;
            } 
        }
        visited[s -1] = state.c;
        seq.add(s);
        return true;
    }
}
