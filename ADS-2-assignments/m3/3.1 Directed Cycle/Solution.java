import java.util.Scanner;
class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = Integer.parseInt(sc.nextLine());
		int e = Integer.parseInt(sc.nextLine());
		Digraph d = new Digraph(v);
		while(e > 0) {
			String[] tokens = sc.nextLine().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			d.addEdge(a, b);
			e--;
		}
		DirectedCycle dc = new DirectedCycle(d);
		if(dc.hasCycle()) {
			System.out.println("Cycle exists.");
		} else {
			System.out.println("Cycle doesn't exists.");
		}
	}
}