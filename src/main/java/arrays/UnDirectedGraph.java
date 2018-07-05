package arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import arrays.Vertex;

public class UnDirectedGraph {
	int noOfVertices;
	HashMap<Vertex,LinkedList<Vertex>> adj;
	
	public UnDirectedGraph(Vertex[] vertices) {
		this.noOfVertices = vertices.length;
		this.adj = new HashMap<Vertex,LinkedList<Vertex>>();
		for(Vertex vertex : vertices) {
			adj.put(vertex, new LinkedList<Vertex>());
		}
	}
	
	public boolean addEdge(Vertex source, Vertex destination) {
		if(this.adj.containsKey(source.name)) {
			LinkedList<Vertex> tmp = this.adj.get(source.name);
			if(tmp==null) {
				tmp = new LinkedList<Vertex>();
			}
			tmp.add(destination);
			
			tmp = this.adj.get(destination.name);
			tmp.add(source);
			return true;
		}else {
			return false;
		}
	}
	
	public void printAdjacencyList() {
		for(Map.Entry<Vertex, LinkedList<Vertex>> entry : this.adj.entrySet()) {
			System.out.print(entry.getKey().name);
			LinkedList<Vertex> list = entry.getValue();
			if(list==null) {
				continue;
			}
			Iterator it = list.iterator();
			while(it.hasNext()) {
				Vertex v = (Vertex)it.next();
				System.out.print(" "+ v.name);
			}
			System.out.println();
		}
	}
}
