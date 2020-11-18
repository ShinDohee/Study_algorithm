package hackerrank_30p;

import java.util.Scanner;

public class Solution_Day6_LetsReview {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String str = sc.next();
			 System.out.println(solution(str));
			 
		}
		
	}
	
	public static String solution(String str) {
		String result = "";
		String left_result = "";
		String right_result = "";
		
		
		
		for (int i = 0; i < str.length(); i++) {
			if( i ==0 || i%2==0) {
				left_result += str.charAt(i);
				
			}else {
				right_result += str.charAt(i);
			}
		}
		
		result = left_result +" "+right_result;
		
		return result;
		
	}
}
