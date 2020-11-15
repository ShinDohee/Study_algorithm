package hackerrank_30p;

import java.util.Scanner;

public class Solution_Day3_Intro {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String print_str="";
		if (N%2 ==0) {
			if(2<N&&N<5) {
				print_str="Not Weird";
			}else if(6<N&&N<=20) {
				print_str="Weird";				
			}else if(20<N) {
				print_str="Not Weird";
			}
		}else {
			print_str="Weird";				
			
		}
		System.out.println(print_str);
		scanner.close();
	}
}
