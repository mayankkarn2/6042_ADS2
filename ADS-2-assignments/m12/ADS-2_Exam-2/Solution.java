import java.util.Scanner;
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
     * The main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int roadLines = sc.nextInt();
        sc.nextLine();
        EdgeWeightedGraph gr = new EdgeWeightedGraph(cities);
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(cities);
        for (int i = 0; i < roadLines; i++) {
            String[] tokens = sc.nextLine().split(" ");
            gr.addEdge(new Edge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2])));
            g.addEdge(new DirectedEdge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2])));
            g.addEdge(new DirectedEdge(Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[2])));
        }
        String caseToGo = sc.nextLine();
        switch (caseToGo) {
        case "Graph":
            System.out.println(gr);
            break;
        case "DirectedPaths":
            // Handle the case of DirectedPaths,
            // where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] tokens1 = sc.nextLine().split(" ");
            DijkstraSP sp = new DijkstraSP(g,
                Integer.parseInt(tokens1[0]));
            if (sp.hasPathTo(Integer.parseInt(tokens1[1]))) {
                int temp = Integer.parseInt(tokens1[1]);
                double dis = sp.distTo(temp);
                System.out.println(dis);
            } else {
                System.out.println("No Path Found.");
            }
            break;

        case "ViaPaths":
            String[] tokens2 = sc.nextLine().split(" ");
            DijkstraSP sp1 = new DijkstraSP(g,
                Integer.parseInt(tokens2[0]));
            DijkstraSP sp2 = new DijkstraSP(g,
                Integer.parseInt(tokens2[1]));
            int temp1 = Integer.parseInt(tokens2[1]);
            int temp2 = Integer.parseInt(tokens2[2]);
            if (sp1.hasPathTo(temp1)
                && sp2.hasPathTo(temp2)) {
                System.out.println(sp1.distTo(temp1)
                    + sp2.distTo(temp2));
                Iterable<DirectedEdge> it1 = sp1.pathTo(temp1);
                for (DirectedEdge e : it1) {
                    System.out.print(e.from() + " ");
                }
                Iterable<DirectedEdge> it2 = sp2.pathTo(temp2);
                int last = 0;
                for (DirectedEdge e : it2) {
                    System.out.print(e.from() + " ");
                    last = e.to();
                }
                System.out.print(last);
            } else {
                System.out.println("No Path Found.");
            }
            break;
        default:
            break;
        }

    }
}
