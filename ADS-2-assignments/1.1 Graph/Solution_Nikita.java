import java.util.Scanner;
import java.util.Arrays;
interface Graph {
    int vertices();
    int edges();
    void addEdge(int v, int w);
    boolean hasEdge(int v, int w);
}
class Graphlist implements Graph {
    private String[] cities;
    private int vertex;
    private int edge;
    private Bag<Integer>[] adj;
    Graphlist(final int v, final int e, final String[] c) {
        cities = c;
        this.vertex = v;
        this.edge = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    public void addEdge(final int v, final int w) {
        if (v == w || hasEdge(v, w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
        edge++;
    }
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    public int vertices() {
        return this.vertex;
    }
    public int edges() {
        return this.edge;
    }
    public boolean hasEdge(final int v, final int w) {
        for (int each : adj[v]) {
            if (each == w) {
                return true;
            }
        }
        return false;
    }
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
class Graphmatrix implements Graph {
    private String[] cities;
    private int[][] matrix;
    private int vertex;
    private int edge;
    Graphmatrix(final int v, final int e, final String[] c) {
        cities = c;
        matrix = new int[v][v];
        this.vertex = v;
        this.edge = 0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    public void addEdge(final int v, final int w) {
        if (v == w || hasEdge(v, w)) {
            return;
        }
        matrix[v][w] = 1;
        matrix[w][v] = 1;
        edge++;
    }
    public int[] adj(final int v) {
        return matrix[v];
    }
    public int vertices() {
        return this.vertex;
    }
    public int edges() {
        return this.edge;
    }
    public boolean hasEdge(final int v, final int w) {
        return matrix[v][w] == 1;
    }
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
final class Solution {
    private Solution() {
        //unused constructor.
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        System.out.println(type);
        int v = Integer.parseInt(sc.nextLine());
        System.out.println(v);
        int e = Integer.parseInt(sc.nextLine());
        System.out.println(e);
        String[] cities = sc.nextLine().split(",");
        System.out.println(Arrays.toString(cities));
        if (type.equals("List")) {
            Graphlist l = new Graphlist(v, e, cities);
            for (int k = 0; k < e; k++) {
                String[] tokens = sc.nextLine().split(" ");
                l.addEdge(Integer.parseInt(tokens[0]),
                    Integer.parseInt(tokens[1]));
            }
            System.out.println(l.vertices()
                + " vertices, " + l.edges() + " edges");
            l.print();
        } else {
            Graphmatrix m = new Graphmatrix(v, e, cities);
            for (int k = 0; k < e; k++) {
                String[] tokens = sc.nextLine().split(" ");
                m.addEdge(Integer.parseInt(tokens[0]),
                     Integer.parseInt(tokens[1]));
            }
            System.out.println(m.vertices()
                + " vertices, " + m.edges() + " edges");
            m.print();
        }
    }
}
