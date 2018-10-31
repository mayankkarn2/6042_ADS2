import java.util.Scanner;
class Percolation {
	private Graph graph;
	private int size;
	private int upper;
	private int lower;
	private int gridSize;
	private boolean[][] connected;
	private int opened;
	Percolation(int s) {
		size = s;
		opened = 0;
		gridSize = size * size;
		upper = gridSize;
		lower = gridSize + 1;
		connected = new boolean[size][size];
		graph = new Graph(gridSize + 2);
	}
	public void open(int row, int column) {
		if(!isOpen(row, column)) {
			connected[row - 1][column - 1] = true;
			opened++;
		}
		if (row == 1) {
			graph.addEdge(getIndex(row, column), upper);
		}
		if (row == size) {
			graph.addEdge(getIndex(row, column), lower);
		}
		if (column > 1 && isOpen(row, column - 1)) {
			graph.addEdge(getIndex(row, column), getIndex(row, column - 1));
		}
		if (column < size && isOpen(row, column + 1)) {
			graph.addEdge(getIndex(row, column), getIndex(row, column + 1));
		}
		if (row > 1 && isOpen(row - 1, column)) {
			graph.addEdge(getIndex(row, column), getIndex(row - 1, column));
		}
		if (row < size && isOpen(row + 1, column)) {
			graph.addEdge(getIndex(row, column), getIndex(row + 1, column));
		}
	}
	public boolean isOpen(int row, int column) {
		return connected[row - 1][column - 1];
	}
	public boolean isFull(int row, int column) {
		if(0 < row && row <= size && 0 < column && column <= size) {
			return graph.hasEdge(upper, getIndex(row, column));
		}
		return false;
	}
	public int numberOfOpenSites() {
		return opened;
	}
	public boolean percolates() {
		CC c = new CC(graph);
		return c.connected(upper, lower);
	}
	private int getIndex(int row, int column) {
		return size * (row - 1) + (column - 1);
	}
}
public final class Solution {
	private Solution() {
		//Nothing happens here.
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = Integer.parseInt(s.nextLine());
		Percolation p = new Percolation(size);
		while(s.hasNext()) {
			String[] tokens = s.nextLine().split(" ");
			p.open(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));
		}
		System.out.println(p.percolates());
	}
}