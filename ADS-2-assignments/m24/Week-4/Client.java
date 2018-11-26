import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
public class Client {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file name:");
		String file = sc.nextLine();
		System.out.println("Choose Symbol Table:");
		System.out.println(" BST , LinearProbingHashST , RedBlackBST , SeparateChainingHashST , SequentialSearchST , BinarySearchST");
		String st = sc.nextLine();
		File dir = new File("C:\\Users\\Lenovo\\Desktop\\Week-4\\");
		for(File f : dir.listFiles()) {
			String fname = file+".csv";
			In in = new In(fname);
			Stopwatch stop = new Stopwatch();
			if(f.getName().equals(fname)) {
				switch(st) {
					case "BinarySearchST":
					BinarySearchST bin = new BinarySearchST();
					// double startTime = System.currentTimeMillis();
					while((!(in.isEmpty()))) {
						String st1 = in.readString();
						String[] tokens = st1.split((","));
						bin.put(tokens[0], tokens[1]);
					}
					// System.out.println("put "+stop.elapsedTime());
					// Stopwatch stop1 = new Stopwatch();
					// System.out.println(bin.get("1363306260"));
					// System.out.println("Get "+stop1.elapsedTime());

					break;
					case "SeparateChainingHashST":
					SeparateChainingHashST sch = new SeparateChainingHashST();
					double startTime = System.currentTimeMillis();
					while((!(in.isEmpty()))) {
						String st2 = in.readString();
						String[] tokens = st2.split(",");
						sch.put(tokens[0], tokens[1]);
					}
					// System.out.println(stop.elapsedTime());
					// System.out.println("put "+stop.elapsedTime());
					// Stopwatch stop1 = new Stopwatch();
					// // System.out.println(sch.get("1973"));
					// // System.out.println(sch.get("accident"));
					// // System.out.println(sch.get("ART"));
					// // System.out.println(sch.get("8999"));
					// // System.out.println(sch.get("78369"));
					// System.out.println(sch.get("1363306260"));
					// System.out.println("Get "+stop1.elapsedTime());				
					break;
					case "RedBlackBST":
					RedBlackBST rbt = new RedBlackBST();
					while((!(in.isEmpty()))) {
						String st3 = in.readString();
						String[] tokens = st3.split(",");
						rbt.put(tokens[0], tokens[1]);
					}
					// System.out.println(rbt.get("1974"));
					System.out.println(stop.elapsedTime());
					Stopwatch stop2 = new Stopwatch();
					// int t=10000;
					// String stqq ="";
					// while(t>0){
					// 	// stqq+="tt";
					// 	t--;
					// }
					// System.out.println("put "+stop.elapsedTime());
					// Stopwatch stop1 = new Stopwatch();
					// if(file.equals("10")) System.out.println(rbt.get("1973"));
					// if(file.equals("100")) System.out.println(rbt.get("accident"));
					// if(file.equals("1000")) System.out.println(rbt.get("ART"));
					// if(file.equals("10000")) System.out.println(rbt.get("8999"));
					// if(file.equals("100000")) System.out.println(rbt.get("78369"));
					// if(file.equals("1000000")) System.out.println(rbt.get("1363306260"));
					// System.out.println("Get "+stop1.elapsedTime());	
					break;
					case "SequentialSearchST":
					SequentialSearchST sst = new SequentialSearchST();
					while((!(in.isEmpty()))) {
						String st4 = in.readString();
						String[] tokens = st4.split(",");
						sst.put(tokens[0], tokens[1]);
					}
					// System.out.println(sst.get("1974"));
					// System.out.println(stop.elapsedTime());
					// System.out.println("put "+stop.elapsedTime());
					// Stopwatch stop1 = new Stopwatch();
					// if(file.equals("10")) System.out.println(sst.get("1973"));
					// if(file.equals("100")) System.out.println(sst.get("accident"));
					// if(file.equals("1000")) System.out.println(sst.get("ART"));
					// if(file.equals("10000")) System.out.println(sst.get("8999"));
					// if(file.equals("100000")) System.out.println(sst.get("78369"));
					// if(file.equals("1000000")) System.out.println(sst.get("1363306260"));
					// System.out.println("Get "+stop1.elapsedTime());
					break;
					case "LinearProbingHashST":
					LinearProbingHashST lph = new LinearProbingHashST();
					while((!(in.isEmpty()))) {
						String st5 = in.readString();
						String[] tokens = st5.split(",");
						lph.put(tokens[0], tokens[1]);
					}
					// System.out.println("put "+stop.elapsedTime());
					// Stopwatch stop1 = new Stopwatch();
					// if(file.equals("10")) System.out.println(lph.get("1973"));
					// if(file.equals("100")) System.out.println(lph.get("accident"));
					// if(file.equals("1000")) System.out.println(lph.get("ART"));
					// if(file.equals("10000")) System.out.println(lph.get("8999"));
					// if(file.equals("100000")) System.out.println(lph.get("78369"));
					// if(file.equals("1000000")) System.out.println(lph.get("1363306260"));
					// System.out.println("Get "+stop1.elapsedTime());
					break;
					case "BST":
					BST bst = new BST();
					while((!(in.isEmpty()))) {
						String st6 = in.readString();
						String[] tokens = st6.split(",");
						bst.put(tokens[0], tokens[1]);
					}
					System.out.println("put "+stop.elapsedTime());
					Stopwatch stop1 = new Stopwatch();
					if(file.equals("10")) System.out.println(bst.get("1973"));
					if(file.equals("100")) System.out.println(bst.get("accident"));
					if(file.equals("1000")) System.out.println(bst.get("ART"));
					if(file.equals("10000")) System.out.println(bst.get("8999"));
					if(file.equals("100000")) System.out.println(bst.get("78369"));
					if(file.equals("1000000")) System.out.println(bst.get("1363306260"));
					System.out.println("Get "+stop1.elapsedTime());
					break;
					default:
					System.out.println("Wrong Input");
					break;
				}
				break;
			}
		}	
	}
}