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
		EdgeWeightedGraph gr = new EdgeWeightedGraph(cities);
		EdgeWeightedDigraph g = new EdgeWeightedDigraph(cities);
		for(int i = 0; i < roadLines; i++) {
			String[] tokens = sc.nextLine().split(" ");
			gr.addEdge(new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
			g.addEdge(new DirectedEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
			g.addEdge(new DirectedEdge(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[0]), Integer.parseInt(tokens[2])));

		}
		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			System.out.println(gr);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] tokens1 = sc.nextLine().split(" ");
			DijkstraSP sp = new DijkstraSP(g, Integer.parseInt(tokens1[0]));
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
			String[] tokens2 = sc.nextLine().split(" ");
			DijkstraSP sp1 = new DijkstraSP(g, Integer.parseInt(tokens2[0]));
			DijkstraSP sp2 = new DijkstraSP(g, Integer.parseInt(tokens2[1]));
			if(sp1.hasPathTo(Integer.parseInt(tokens2[1])) && sp2.hasPathTo(Integer.parseInt(tokens2[2]))) {
				System.out.println(sp1.distTo(Integer.parseInt(tokens2[1])) + sp2.distTo(Integer.parseInt(tokens2[2])));
				Iterable<DirectedEdge> it1 = sp1.pathTo(Integer.parseInt(tokens2[1]));
				for(DirectedEdge e : it1) {
					System.out.print(e.from() + " ");
				}
				Iterable<DirectedEdge> it2 = sp2.pathTo(Integer.parseInt(tokens2[2]));
				int last = 0;
				for(DirectedEdge e : it2) {
					System.out.print(e.from() + " ");
					last = e.to();
				}
				System.out.print(last);
			}
			else {
				System.out.println("No Path Found.");
			}
			// Iterable<Edge> it1 = sp1.pathTo(Integer.parseInt(tokens2[1]));
			// for(Edge e : it1) {
			// 	System.out.print(e);
			// }
			// Iterable<Edge> it2 = sp2.pathTo(Integer.parseInt(tokens2[2]));
			// for(Edge e : it2) {
			// 	System.out.print(e);
			// }
			break;

		default:
			break;
		}

	}
}