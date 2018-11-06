package before;

import java.util.Scanner;

public class Solution01 {
    static int Answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Scanner sc = new Scanner(new FileInputStream("input.txt"));
        int T = Integer.parseInt(sc.nextLine());
        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            String stringbracket = sc.nextLine();

            for (int i = 0; i < stringbracket.length() - 1; i++) {

                if (stringbracket.substring(i, i + 2).equals("()")
                        || stringbracket.substring(i, i + 2).equals("{}")
                        || stringbracket.substring(i, i + 2).equals("[]")) {
                    Answer++;
                }
            }

            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }

}
