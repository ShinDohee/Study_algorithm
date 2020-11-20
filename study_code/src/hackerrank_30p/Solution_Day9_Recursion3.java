package hackerrank_30p;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution_Day9_Recursion3 {
	// Complete the factorial function below.
	static int factorial(int n) {
		int total=1;
		
		if(n==1) {
			return 1;
		}else {
			for (int i = 1; i <= n; i++) {
				total *= i;
			}
		}
		
		
		return total;		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int result = factorial(n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
