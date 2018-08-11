package org.comp.algo.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GraphDS {

    public static class Graph {
        int numOfVertices;

        Map<Integer, LinkedList<Integer>> adjList = new HashMap<>();

        public Graph(List<Integer> vertices) {
            for (Integer v : vertices) {
                adjList.put(v, new LinkedList<>());
            }
            numOfVertices = vertices.size();
        }

        public Iterable<Integer> V() {
            return adjList.keySet();
        }

        public void addEdge(int from, int to) {
            if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
                throw new IllegalArgumentException("vertex from or to is not in graph " + from + " , " + to);
            }
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        public Iterable<Integer> adj(int v) {
            if (!adjList.containsKey(v)) {
                throw new IllegalArgumentException("vertex  not in graph " + v);
            }
            return adjList.get(v);
        }

        public void print() {
            Set<Entry<Integer, LinkedList<Integer>>> entrySet = adjList.entrySet();
            for (Entry<Integer, LinkedList<Integer>> entry : entrySet) {
                System.out.println("(" + entry.getKey() + ")--[" + llstr(entry.getValue()) + "]");
            }
        }

        public String llstr(LinkedList<Integer> val) {
            StringBuilder sb = new StringBuilder();
            int curr = 0;
            for (Integer v : val) {
                sb.append(v);
                if (curr < val.size() - 1) {
                    sb.append(",");
                }
                curr++;
            }
            return sb.toString();
        }
    }

    public static class DiGraph {
        enum Di {
            in,
            out
        };

        private int numOfVerties;

        private Map<Integer, Map<Di, LinkedList<Integer>>> adjList;

        public DiGraph(List<Integer> vertices) {
            adjList = new HashMap<>();
            for (Integer v : vertices) {
                HashMap<Di, LinkedList<Integer>> m = new HashMap<>();
                m.put(Di.in, new LinkedList<>());
                m.put(Di.out, new LinkedList<>());
                adjList.put(v, m);
            }
            numOfVerties = adjList.size();
        }

        public Iterable<Integer> adj(int i) {
            Map<Di, LinkedList<Integer>> map = adjList.get(i);
            if (map == null) {
                throw new IllegalArgumentException(i + " not in graph");
            }
            return map.get(Di.out);
        }

        public Iterable<Integer> V() {
            return adjList.keySet();
        }

        public void addEdge(int from, int to) {
            if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
                throw new IllegalArgumentException("vertex from or to is not in graph " + from + " , " + to);
            }
            adjList.get(from).get(Di.out).add(to);
            adjList.get(to).get(Di.in).add(from);
        }

        public void print() {
            Set<Entry<Integer, Map<Di, LinkedList<Integer>>>> entrySet = adjList.entrySet();
            for (Entry<Integer, Map<Di, LinkedList<Integer>>> entry : entrySet) {
                System.out.println("(" + entry.getKey() + ")--out[" + llstr(entry.getValue().get(Di.out)) + "]--in["
                        + llstr(entry.getValue().get(Di.in)) + "]");
            }
        }

        public String llstr(LinkedList<Integer> val) {
            StringBuilder sb = new StringBuilder();
            int curr = 0;
            for (Integer v : val) {
                sb.append(v);
                if (curr < val.size() - 1) {
                    sb.append(",");
                }
                curr++;
            }
            return sb.toString();
        }
    }

    public static class GraphFactory {

        public static Graph getTiny() {
           //@formatter:off
         /* 13 V
          * 13 E
          * 0 5
            4 3
            0 1
            9 12
            6 4
            5 4
            0 2
            11 12
            9 10
            0 6
            7 8
            9 11 
            5 3 */
          //@formatter:on
            Graph g = new Graph(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
            g.addEdge(0, 5);
            g.addEdge(4, 3);
            g.addEdge(0, 1);
            g.addEdge(9, 12);
            g.addEdge(6, 4);
            g.addEdge(5, 4);
            g.addEdge(0, 2);
            g.addEdge(11, 12);
            g.addEdge(9, 10);
            g.addEdge(0, 6);
            g.addEdge(7, 8);
            g.addEdge(9, 11);
            g.addEdge(5, 3);
            return g;
        }
        
        public static DiGraph getDiTiny() {
            //@formatter:off
          /* 13 V
           * 13 E
           4  2
         2  3
         3  2
         6  0
         0  1
         2  0
        11 12
        12  9
         9 10
         9 11
         7  9
        10 12
        11  4
         4  3
         3  5
         6  8
         8  6
         5  4
         0  5
         6  4
         6  9
         7  6 */
           //@formatter:on
             DiGraph g = new DiGraph(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
             g.addEdge(4, 2);
             g.addEdge(3, 2);
             g.addEdge(6, 0);
             g.addEdge(0, 1);
             g.addEdge(2, 0);
             g.addEdge(11, 12);
             g.addEdge(12, 9);
             g.addEdge(9, 10);
             g.addEdge(9, 11);
             g.addEdge(7, 9);
             g.addEdge(10, 12);
             g.addEdge(11, 4);
             g.addEdge(4, 3);
             g.addEdge(3, 5);
             g.addEdge(6, 8);
             g.addEdge(8, 6);
             g.addEdge(5, 4);
             g.addEdge(0, 5);
             g.addEdge(6, 4);
             g.addEdge(6, 9);
             g.addEdge(7, 6);
             return g;
         }
    }

}

