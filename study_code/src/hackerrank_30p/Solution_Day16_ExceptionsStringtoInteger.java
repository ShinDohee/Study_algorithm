package hackerrank_30p;

import java.util.Scanner;

public class Solution_Day16_ExceptionsStringtoInteger {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		
		try {
			int num = Integer.parseInt(S);
			System.out.println(num);
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Bad String");
		}
		
	}
}
