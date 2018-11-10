import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int cities = sc.nextInt();
		int roadLines = sc.nextInt();
		sc.nextLine();
		EdgeWeightedGraph g = new EdgeWeightedGraph(cities);
		for(int i = 0; i < roadLines; i++) {
			String[] tokens = sc.nextLine().split(" ");
			g.addEdge(new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
		}
		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			System.out.println(g);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] tokens1 = sc.nextLine().split(" ");
			DijkstraUndirectedSP sp = new DijkstraUndirectedSP(g, Integer.parseInt(tokens1[0]));
			if(sp.hasPathTo(Integer.parseInt(tokens1[1]))) {
				System.out.println(sp.distTo(Integer.parseInt(tokens1[1])));
			}
			else {
				System.out.println("No Path Found.");
			}
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}