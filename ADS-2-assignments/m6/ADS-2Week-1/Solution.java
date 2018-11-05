import java.util.Scanner;
import java.util.Arrays;
class PageRank {
	Digraph d;
	double value;
	Digraph reverse;
	boolean[] marked;
	PageRank(Digraph d) {
		this.d = d;
		value = (d.V());
		reverse = d.reverse();
		marked = new boolean[d.V()];
		// for(int i = 0; i < d.V(); i++) {
		// 	if(d.outdegree(i) > 0) {
		// 		marked[i] = true;
		// 	}
		// }
		// for(int i = 0; i < d.V(); i++) {
		// 	if(d.outdegree(i) == 0) {
		// 		for(int j = 0; j < d.V();j++) {
		// 			if(i!=j && marked[j] == true) {
		// 				d.addEdge(i,j);
		// 			}
		// 		}
		// 	}
		// }
		// System.out.println(d);
	}
	public double getPR(int x) {
		double pr = 1.0/value;
		return helperPr(pr,x);
	}
	public double helperPr(double pr, int x) {
		double[] prs = new double[d.V()];
		for(int i = 0; i < prs.length; i++) {
			prs[i] = pr;
		}
		double[] new_prs = new double[d.V()];
		for(int i = 0; i < prs.length; i++) {
			new_prs[i] = prs[i];
		}
		for(int iteration = 0; iteration < 1000; iteration++) {
			for(int i = 0; i < prs.length; i++) {
				prs[i] = new_prs[i];
			}
			for(int j = 0; j < d.V(); j++) {
				Iterable<Integer> it = reverse.adj(j);
				double cal = 0.0;
				for(Integer i : it) {
					// System.out.println(i);
					cal += prs[i]/d.outdegree(i);
				}
				new_prs[j] = cal;
			}
		}
		return new_prs[x];
	}
}

class WebSearch {

}


public class Solution {
		// read the first line of the input to get the number of vertices
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph	
		// Create page rank object and pass the graph object to the constructor
		// print the page rank object
		// This part is only for the final test case
		// File path to the web content
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int vertices = s.nextInt();
		s.nextLine();
		Digraph d = new Digraph(vertices);
		for (int i = 0; i < vertices; i++) {
			String[] tokens = s.nextLine().split(" ");
			// if(tokens.length == 1) {
			// 	for(int j = 0; j < vertices; j++) {
			// 		d.addEdge(i,j);
			// 	}
			// }
			// else {
			// 	for(int j = 1; j < tokens.length; j++) {
			// 		d.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[j]));
			// 	}
			// }
			for(int j = 1; j < tokens.length; j++) {
					d.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[j]));
			}
		}
		System.out.println(d);
		for(int i = 0; i < d.V(); i++) {
			if(d.outdegree(i) == 0) {
				for(int j = 0; j < d.V(); j++) {
					if(i!=j) {
						d.addEdge(i,j);
					}
				}
			}
		}
		PageRank p = new PageRank(d);
		for(int i = 0; i < vertices; i++) {
			System.out.println(i + " - " + p.getPR(i));
		}
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
