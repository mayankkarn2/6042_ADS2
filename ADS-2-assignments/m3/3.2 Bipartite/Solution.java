import java.util.Scanner;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = Integer.parseInt(s.nextLine());
		int e = Integer.parseInt(s.nextLine());
		Graph g = new Graph(v);
		for (int i = 0; i < e; i++) {
			String[] tokens = s.nextLine().split(" ");
			g.addEdge(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));
		}
		DirectedCycle dc = new DirectedCycle(g);
		if (dc.isBipartite()) {
			System.out.println("Graph is bipartite");
		} else {
			System.out.println("Graph is not bipatite");
		}
	}
}