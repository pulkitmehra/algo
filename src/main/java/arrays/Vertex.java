package arrays;

public class Vertex {
	
	String name;
	Vertex parent;
	int dist;
	
	color color;
	enum color{
		White,Gray,Black
	}
	public Vertex(String name,int dist,Vertex parent) {
		this.name=name;
		this.parent = parent;
		this.dist=-999999999;
		this.color=color.White;
	}
	public Vertex(String str) {
		// TODO Auto-generated constructor stub
		this.name=str;
		this.parent = null;
		this.dist=-999999999;
		this.color=color.White;
	}
	
	@Override
	public boolean equals(Object v) {
		Vertex vertex = (Vertex) v;
		return this.name.equals(vertex.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
}	
