package hackerrank_30p;

import java.util.ArrayList;
import java.util.Scanner;

class Calculator1 implements AdvancedArithmetic {
	public int divisorSum(int n) {
		int result =0;
		ArrayList<Integer> arrNum =new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			if(n%i ==0) {
				arrNum.add(i);
			}
			
		}
		
		for (Integer integer : arrNum) {
			result += integer;
		}
		
		return result;
	}
}

public class Solution_Day19_Interfaces {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		AdvancedArithmetic myCalculator = new Calculator1();
		int sum = myCalculator.divisorSum(n);
		System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
		System.out.println(sum);
	}
}
