import java.util.Scanner;
interface Graph {
    public int vertices();
    public int edges();
    public void addEdge(int v, int w);
    public boolean hasEdge(int v, int w);
}
class GraphList implements Graph {
	private String[] cities;
	private int vertex;
	private int edge;
	private Bag<Integer>[] adj;
	GraphList(int vertex, int edge, String[] cities) {
		this.cities = cities;
		this.vertex = vertex;
		this.edge = 0;
		adj = (Bag<Integer>[]) new Bag[vertex];
		for(int i = 0; i < vertex; i++) {
			adj[i] = new Bag<Integer>();
		}
	}
	public void addEdge(int vertex1, int vertex2) {
		if(vertex1 == vertex2 || hasEdge(vertex1, vertex2)) {
			return;
		}
		adj[vertex1].add(vertex2);
		adj[vertex2].add(vertex1);
		edge++; 
	}
	public Iterable<Integer> adj(int ver) {
		return adj[ver];
	}
	public int vertices() {
		return this.vertex;
	}
	public int edges() {
		return this.edge;
	}
	public boolean hasEdge(int vertex1, int vertex2) {
		for (int e : adj[vertex1]) {
			if(e == vertex2) {
				return true;
			}
		}
		return false;
	}
	public void print() {
		if(edge == 0) {
			System.out.println("No edges");
		}
		else {
			for(int i = 0; i < vertex - 1; i++) {
				String str = "";
				str += cities[i] + ": ";
				for(int each : adj[i]) {
					str += cities[each] + " ";
				}
				System.out.println(str);
			}
			String str = "";
			str += cities[vertex - 1] + ": ";
			for(int each : adj[vertex - 1]) {
				str += cities[each] + " ";
			}
			System.out.println(str.substring(0, str.length() - 1));
		}
	}
}
class Graphmatrix implements Graph {
	private String[] cities;
	private int[][] matrix;
	private int vertex;
	private int edge;
	Graphmatrix(int vertex, int edge, String[] cities) {
		this.cities = cities;
		matrix = new int[vertex][vertex];
		this.vertex = vertex;
		this.edge = 0;
		for(int i = 0; i < vertex; i++) {
			for(int j = 0; j < vertex; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	public void addEdge(int vertex1, int vertex2) {
		if(vertex1 == vertex2 || hasEdge(vertex1, vertex2)) {
			return;
		}
		matrix[vertex1][vertex2] = 1;
		matrix[vertex2][vertex1] = 1;
		edge++;
	}
	public int[] adj(int ver) {
		return matrix[ver];
	}
	public int vertices() {
		return this.vertex;
	}
	public int edges() {
		return this.edge;
	}
	public boolean hasEdge(int vertex1, int vertex2) {
		return matrix[vertex1][vertex2] == 1;
	}
	public void print() {
		if(edge == 0) {
			System.out.println("No edges");
		} else {
			for(int i = 0; i < vertex - 1; i++) {
				String s = "";
				for(int each : matrix[i]) {
					s += each + " ";
				}
				System.out.println(s);
			}
			String s = "";
			for(int each : matrix[vertex - 1]) {
				s += each + " ";
			}
			System.out.println(s.substring(0, s.length() - 1));
		}
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String type = s.nextLine();
		int vertex = Integer.parseInt(s.nextLine());
		int edge = Integer.parseInt(s.nextLine());
		String[] cities = s.nextLine().split(",");
		if(type.equals("List")) {
			GraphList l = new GraphList(vertex, edge, cities);
			for(int k = 0; k < edge; k++) {
				String[] tokens = s.nextLine().split(" ");
				l.addEdge(Integer.parseInt(tokens[0]),
                    Integer.parseInt(tokens[1]));
			}
			System.out.println(l.vertices()
                + " vertices, " + l.edges() + " edges");
            l.print();
		} else {
            Graphmatrix m = new Graphmatrix(vertex, edge, cities);
            for (int k = 0; k < edge; k++) {
                String[] tokens = s.nextLine().split(" ");
                m.addEdge(Integer.parseInt(tokens[0]),
                     Integer.parseInt(tokens[1]));
            }
            System.out.println(m.vertices()
                + " vertices, " + m.edges() + " edges");
            m.print();
        }
	}
}

