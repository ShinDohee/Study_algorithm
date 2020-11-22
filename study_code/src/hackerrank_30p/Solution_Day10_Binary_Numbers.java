package hackerrank_30p;

import java.util.Scanner;

public class Solution_Day10_Binary_Numbers {
	public static int solution( int n) {		 
		String binaryString = Integer.toBinaryString(n); //2진수
		int i=0;
		int count=0;
		int result =0;
		while(i<binaryString.length()) {
			String a =Character.toString(binaryString.charAt(i)) ;
			
			if("1".equals( a) ) {
				count++;
			}else {
				if(result < count) result = count;
				
				count=0;
			}
			i++;
		}
		
		if(result < count) result = count;
		
		return result;
		
	}
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(solution(n));
        scanner.close();
    }
}
