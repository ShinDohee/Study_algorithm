package hackerrank_30p;

import java.util.Scanner;

public class Solution_Day2_Operator {

    // Complete the solve function below.
    static void solve(double meal_cost, int tip_percent, int tax_percent) {
    	double tax_amount =meal_cost*((double)tax_percent/100);
    	double tip_amount  =meal_cost*((double)tip_percent/100); 	
    	long result =Math.round(meal_cost+tax_amount+tip_amount);
    	
    	System.out.println(result); // 밥값 

    	

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        double meal_cost = scanner.nextDouble();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int tip_percent = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int tax_percent = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        solve(meal_cost, tip_percent, tax_percent);
    	
    	 double meal_cost =12.00;
    	 int tip_percent=20;
    	 int tax_percent= 8;
    	 
    	 solve(meal_cost, tip_percent, tax_percent);

//        scanner.close();
    }
}
