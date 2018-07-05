package com.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {

	public GNode[] vertices;
	int[] start;
	int[] end;
	int[] color;
	public Set<Integer> uniqueVertices = new HashSet<>();
	public int[] out, in;
	public boolean directed;
	int edges;
	int v;
	int size;

	public Graph(int size, boolean directed) {
		vertices = new GNode[size + 1];
		out = new int[size + 1];
		in = new int[size + 1];
		start = new int[size + 1];
		end = new int[size + 1];
		color = new int[size + 1];
		this.directed = directed;
		this.size = size;
	}

	public static class GNode {
		public int v;
		public GNode next;

		public GNode(int v) {
			this.v = v;
		}

		public static GNode get(int v) {
			GNode n = new GNode(v);
			return n;
		}

		public void next(GNode n) {
			this.next = n;
		}

		@Override
		public String toString() {
			return "[" + v + "]";
		}

	}

	public void addEdge(int u, int v) {
		if (directed) {
			addEdgeDirected(u, v);
		} else {
			addEdgeUnDirected(u, v);
		}
	}

	public boolean addEdgeUnDirected(int u, int v) {
		return addEdgeDirected(u, v) && addEdgeDirected(v, u);
	}

	public boolean addEdgeDirected(int u, int v) {
		if (u >= vertices.length || v >= vertices.length) {
			return false;
		}

		GNode s = vertices[u];
		if (s == null) {
			vertices[u] = GNode.get(v);
		} else {
			while (s != null && s.next != null) {
				s = s.next;
			}
			s.next(GNode.get(v));
		}
		out[u] = out[u] + 1;
		in[v] = in[v] + 1;
		edges++;
		uniqueVertices.add(u);
		uniqueVertices.add(v);
		return true;
	}

	public int[] adj(int u) {
		if (u >= vertices.length) {
			return null;
		}
		if (vertices[u] == null || out[u] == 0) {
			return new int[] {};
		}
		int[] adj = new int[out[u]];
		GNode n = vertices[u];
		int i = 0;
		while (n != null) {
			adj[i++] = n.v;
			n = n.next;
		}
		return adj;
	}

	public Graph transpose() {
		Graph g = new Graph(size, directed);
		for (int i = 1; i < vertices.length; i++) {
			GNode gNode = vertices[i];
			while (gNode != null) {
				g.addEdge(gNode.v, i);
				gNode = gNode.next;
			}
		}
		return g;
	}

	public List<Integer> V() {
		return new ArrayList<Integer>(uniqueVertices);
	}

	public int E() {
		return edges;
	}

	public void setStart(int u, int t) {
		start[u] = t;
	}

	public void setEnd(int u, int t) {
		end[u] = t;
	}

	public int getStart(int u) {
		return start[u];
	}

	public int getEnd(int u) {
		return end[u];
	}

	public void toBlack(int u) {
		color[u] = 2;
	}

	public boolean isBlack(int u) {
		return color[u] == 2;
	}

	public void toGrey(int u) {
		color[u] = 1;
	}

	public boolean isGrey(int u) {
		return color[u] == 1;
	}

	public boolean isWhite(int u) {
		return color[u] == 0;
	}

	public static Graph small(boolean directed) {
		Graph g = new Graph(6, directed);
		if (directed) {
			g.addEdgeDirected(1, 2);
			g.addEdgeDirected(1, 4);
			g.addEdgeDirected(2, 5);
			g.addEdgeDirected(4, 2);
			g.addEdgeDirected(5, 4);
			g.addEdgeDirected(3, 6);
			g.addEdgeDirected(3, 5);
		} else {
			g.addEdgeUnDirected(1, 2);
			g.addEdgeUnDirected(1, 4);
			g.addEdgeUnDirected(2, 4);
			g.addEdgeUnDirected(2, 5);
			g.addEdgeUnDirected(4, 5);
			g.addEdgeUnDirected(3, 5);
			g.addEdgeUnDirected(3, 6);
		}
		return g;
	}

	public static Graph medium(boolean directed) {
		Graph g = new Graph(8, directed);
		if (directed) {
			g.addEdgeDirected(1, 5);
			g.addEdgeDirected(2, 1);
			g.addEdgeDirected(2, 6);
			g.addEdgeDirected(3, 2);
			g.addEdgeDirected(3, 6);
			g.addEdgeDirected(4, 7);
			g.addEdgeDirected(4, 8);
			g.addEdgeDirected(5, 2);
			g.addEdgeDirected(6, 5);
			g.addEdgeDirected(7, 6);
			g.addEdgeDirected(7, 3);
			g.addEdgeDirected(8, 7);
		} else {
			g.addEdgeUnDirected(1, 2);
			g.addEdgeUnDirected(1, 5);
			g.addEdgeUnDirected(2, 5);
			g.addEdgeUnDirected(2, 6);
			g.addEdgeUnDirected(2, 3);
			g.addEdgeUnDirected(3, 6);
			g.addEdgeUnDirected(3, 7);
			g.addEdgeUnDirected(4, 7);
			g.addEdgeUnDirected(4, 8);
			g.addEdgeUnDirected(7, 8);
			g.addEdgeUnDirected(6, 5);
			g.addEdgeUnDirected(6, 7);
		}
		return g;
	}

	public static Graph medium2() {
		Graph g = new Graph(8, false);
		g.addEdgeUnDirected(1, 2);
		g.addEdgeUnDirected(1, 5);
		g.addEdgeUnDirected(2, 5);
		g.addEdgeUnDirected(2, 6);
		g.addEdgeUnDirected(2, 3);
		g.addEdgeUnDirected(3, 6);
		g.addEdgeUnDirected(3, 7);
		g.addEdgeUnDirected(4, 7);
		g.addEdgeUnDirected(4, 8);
		g.addEdgeUnDirected(7, 8);
		g.addEdgeUnDirected(6, 5);
		g.addEdgeUnDirected(6, 7);
		return g;
	}

	public static Graph dac() {
		Graph g = new Graph(10, false);
		g.addEdgeDirected(1, 2);
		g.addEdgeDirected(2, 3);
		g.addEdgeDirected(2, 4);
		g.addEdgeDirected(3, 4);
		g.addEdgeDirected(3, 7);
		g.addEdgeDirected(5, 4);
		g.addEdgeDirected(6, 3);
		g.addEdgeDirected(6, 7);
		g.addEdgeDirected(7, 8);
		g.addEdgeDirected(9, 10);
		return g;
	}

	public static Graph largeDac() {
		Graph g = new Graph(14, false);
		g.addEdgeDirected(1, 5);
		g.addEdgeDirected(1, 6);
		g.addEdgeDirected(1, 12);
		g.addEdgeDirected(2, 5);
		g.addEdgeDirected(2, 9);
		g.addEdgeDirected(2, 3);
		g.addEdgeDirected(3, 6);
		g.addEdgeDirected(3, 10);
		g.addEdgeDirected(3, 7);
		g.addEdgeDirected(4, 3);
		g.addEdgeDirected(4, 7);
		g.addEdgeDirected(4, 14);
		g.addEdgeDirected(5, 8);
		g.addEdgeDirected(6, 9);
		g.addEdgeDirected(6, 13);
		g.addEdgeDirected(7, 6);
		g.addEdgeDirected(9, 8);
		g.addEdgeDirected(10, 11);
		g.addEdgeDirected(10, 12);
		g.addEdgeDirected(11, 14);
		g.addEdgeDirected(13, 10);
		return g;
	}

	public void print() {
		for (int i = 1; i < vertices.length; i++) {
			if (vertices[i] != null)
				System.out.println("(" + i + ")-" + getAdjList(i));
		}
	}

	public String getAdjList(int u) {
		return Arrays.stream(adj(u)).boxed().map(e -> "[" + e.toString() + "]").collect(Collectors.joining("-"));
	}

}
