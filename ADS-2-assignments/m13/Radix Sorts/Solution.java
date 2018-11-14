import java.util.Scanner;
import java.util.Arrays;
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
     * The main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int characters;
        String[] tokens = new String[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextLine();
        }
        LSD lsd = new LSD();
        lsd.sort(tokens, tokens[0].length());
        System.out.println(Arrays.toString(tokens));
    }
}
