package hackerrank_30p;

import java.util.Scanner;

public class Solution_Day26_NestedLogic {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
		Scanner scan = new Scanner(System.in);
		
        String[] returnDate = scan.nextLine().split(" "); //반납날짜
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        String[] dueDate = scan.nextLine().split(" "); // 마감기한 
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if(Integer.parseInt(returnDate[2])> Integer.parseInt(dueDate[2]) ) {
        	System.out.println(10000);
        }else if(Integer.parseInt(returnDate[2]) == Integer.parseInt(dueDate[2])) {
        	if(Integer.parseInt(returnDate[1])> Integer.parseInt(dueDate[1]) ) {
        		int month= Integer.parseInt(returnDate[1])- Integer.parseInt(dueDate[1]);
        		System.out.println(500*month);        		
        	}else {
        		if(Integer.parseInt(returnDate[0])> Integer.parseInt(dueDate[0])) {
        			int day=Integer.parseInt(returnDate[0])- Integer.parseInt(dueDate[0]);
        			System.out.println(15*day);
        		}else {
        			System.out.println(0);        			
        		}        		
        	}        	
        }else {
    		System.out.println(0);
        }
        
        
		scan.close();
    }
}
