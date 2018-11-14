import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int characters;
		String[] tokens = new String[n];
		for(int i = 0; i < n; i++) {
			tokens[i] = sc.nextLine();
		}
		LSD lsd = new LSD();
		lsd.sort(tokens, tokens[0].length());
		System.out.println(Arrays.toString(tokens));
	}
}