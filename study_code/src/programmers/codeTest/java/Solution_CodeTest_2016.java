package programmers.codeTest.java;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_CodeTest_2016 {
	
	
									//1/2/3/4/5
	private static final int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};
	private static final String[] str_days = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
	private static final Scanner scanner = new Scanner(System.in);
	
	public static String solution(int a, int b) {
		String answer = "";
		int totalday =0;
		if(a > 1) {
			for(int i=0; i<a-1;i++) {
				totalday += days[i];
			}
			totalday = (totalday+b)%7;
			
			
		}else if(a == 1) {
			totalday = b%7;
		}
		
		answer = str_days[totalday];
	
		return answer;
		
		}
		
	

	public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int month = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int day = scanner.nextInt();


		String result = solution(month, day);
		System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

		scanner.close();
	}
}
