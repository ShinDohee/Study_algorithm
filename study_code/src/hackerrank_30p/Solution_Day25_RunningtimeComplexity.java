package hackerrank_30p;

import java.util.Scanner;

public class Solution_Day25_RunningtimeComplexity {
	public static void main(String[] args) {
		/* Enter your code here. */
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int data = sc.nextInt();
			if(!isPrime(data)) {
				System.out.println("Not prime");
			}else {
				System.out.println("Prime");
			}
		}

	}
	
	   public static boolean isPrime(int num) {
	        boolean result = true;
	        
	        if(num==1) return false;
	        
	        for(int i = 2; i <=num/2; i++) {
	            if( num%i == 0) {
	            	return false;	             
	            } 
	        }        
	        return result;        
	    }
	
}
