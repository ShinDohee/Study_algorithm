package hackerrank_30p;

import java.util.*;


public class Solution_Day28_RegEx {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> list = new ArrayList<>();
        
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];
            
            if (emailID.contains("@gmail.com"))  list.add(firstName);
        }

        Collections.sort(list);
        
        for (String string : list) {
			System.out.println(string);
		}
        
        scanner.close();
    }
}
