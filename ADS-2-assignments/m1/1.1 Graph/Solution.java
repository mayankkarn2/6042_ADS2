import java.util.Scanner;
/**
 * Interface for graph.
 */
interface Graph {
    /**
     * Count of vertices.
     *
     * @return     Count of vertices.
     */
    int vertices();
    /**
     * Count of Edges.
     *
     * @return     Count of Edges.
     */
    int edges();
    /**
     * Adds an edge.
     *
     * @param      v     Vertex-1.
     * @param      w     Vertex-2.
     */
    void addEdge(int v, int w);
    /**
     * Determines if it has edge.
     *
     * @param      v     Vertex-1.
     * @param      w     Vertex-2.
     *
     * @return     True if has edge, False otherwise.
     */
    boolean hasEdge(int v, int w);
}
/**
 * List of graphs.
 */
class GraphList implements Graph {
    /**
     * Cities of String.
     */
    private String[] cities;
    /**
     * Vertex of Graph.
     */
    private int vertex;
    /**
     * Edges of Graph.
     */
    private int edge;
    /**
     * Bag of Adjacent nodes.
     */
    private Bag<Integer>[] adj;
    /**
     * Constructs the object.
     *
     * @param      v  The vertex
     * @param      e    The edge
     * @param      c  The cities
     */
    GraphList(final int v, final int e, final String[] c) {
        this.cities = c;
        this.vertex = v;
        this.edge = 0;
        adj = (Bag<Integer>[]) new Bag[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * Adds an edge.
     *
     * @param      vertex1  The vertex 1
     * @param      vertex2  The vertex 2
     */
    public void addEdge(final int vertex1,
        final int vertex2) {
        if (vertex1 == vertex2 || hasEdge(vertex1, vertex2)) {
            return;
        }
        adj[vertex1].add(vertex2);
        adj[vertex2].add(vertex1);
        edge++;
    }
    /**
     * Iterable.
     *
     * @param      ver   The vertex.
     *
     * @return     Adjacent list of Vertex.
     */
    public Iterable<Integer> adj(final int ver) {
        return adj[ver];
    }
    /**
     * returns the vertex.
     *
     * @return     vertex.
     */
    public int vertices() {
        return this.vertex;
    }
    /**
     * Returns Edges.
     *
     * @return     edge.
     */
    public int edges() {
        return this.edge;
    }
    /**
     * Determines if it has edge.
     *
     * @param      vertex1  The vertex 1
     * @param      vertex2  The vertex 2
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int vertex1,
        final int vertex2) {
        for (int e : adj[vertex1]) {
            if (e == vertex2) {
                return true;
            }
        }
        return false;
    }
    /**
     * Prints the Graph.
     */
    public void print() {
        if (edge == 0) {
            System.out.println("No edges");
        } else {
            for (int i = 0; i < vertex - 1; i++) {
                String str = "";
                str += cities[i] + ": ";
                for (int each : adj[i]) {
                    str += cities[each] + " ";
                }
                System.out.println(str);
            }
            String str = "";
            str += cities[vertex - 1] + ": ";
            for (int each : adj[vertex - 1]) {
                str += cities[each] + " ";
            }
            System.out.println(str.substring(0, str.length() - 1));
        }
    }
}
/**
 * Class for graphmatrix.
 */
class Graphmatrix implements Graph {
    /**
     * String of cities.
     */
    private String[] cities;
    /**
     * Matrix array.
     */
    private int[][] matrix;
    /**
     * Vertex.
     */
    private int vertex;
    /**
     * Edge.
     */
    private int edge;
    /**
     * Constructs the object.
     *
     * @param      v  The vertex.
     * @param      e    The edge.
     * @param      c  The cities.
     */
    Graphmatrix(final int v, final int e, final String[] c) {
        this.cities = c;
        matrix = new int[v][v];
        this.vertex = v;
        this.edge = 0;
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    /**
     * Adds an edge.
     *
     * @param      vertex1  The vertex 1
     * @param      vertex2  The vertex 2
     */
    public void addEdge(final int vertex1,
        final int vertex2) {
        if (vertex1 == vertex2 || hasEdge(vertex1, vertex2)) {
            return;
        }
        matrix[vertex1][vertex2] = 1;
        matrix[vertex2][vertex1] = 1;
        edge++;
    }
    /**
     * Adjacency list of a vertex.
     *
     * @param      ver   The vertex.
     *
     * @return     Adjacency list of a vertex.
     */
    public int[] adj(final int ver) {
        return matrix[ver];
    }
    /**
     * Vertices.
     *
     * @return     Vertex.
     */
    public int vertices() {
        return this.vertex;
    }
    /**
     * Edges.
     *
     * @return     Edges.
     */
    public int edges() {
        return this.edge;
    }
    /**
     * Determines if it has edge.
     *
     * @param      vertex1  The vertex 1.
     * @param      vertex2  The vertex 2.
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int vertex1,
        final int vertex2) {
        return matrix[vertex1][vertex2] == 1;
    }
    /**
     * Prints thhe Graph.
     */
    public void print() {
        if (edge == 0) {
            System.out.println("No edges");
        } else {
            for (int i = 0; i < vertex - 1; i++) {
                String s = "";
                for (int each : matrix[i]) {
                    s += each + " ";
                }
                System.out.println(s);
            }
            String s = "";
            for (int each : matrix[vertex - 1]) {
                s += each + " ";
            }
            System.out.println(s.substring(0, s.length() - 1));
        }
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Nothing happens here.
    }
    /**
     * The main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String type = s.nextLine();
        int vertex = Integer.parseInt(s.nextLine());
        int edge = Integer.parseInt(s.nextLine());
        String[] cities = s.nextLine().split(",");
        if (type.equals("List")) {
            GraphList l = new GraphList(vertex, edge, cities);
            for (int k = 0; k < edge; k++) {
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


