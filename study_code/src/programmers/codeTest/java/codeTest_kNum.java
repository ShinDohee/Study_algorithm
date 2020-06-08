package programmers.codeTest.java;

import java.util.Arrays;

public class codeTest_kNum {
	/**
	 * 	
	array						commands							return
	[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

	 */

		
		public static void main(String[] args) {
			int[] array = {1, 5, 2, 6, 3, 7, 4};
			int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};	
			
			solution(array , commands).toString();
		}

		public static int[] solution(int[] array, int[][] commands) {
			int[] answer = new int[commands.length] ;
			int [] temp =  new int[commands.length] ;
			System.out.print("[");
			for (int i = 0; i < commands.length; i++) {
				if(i !=0) System.out.print(",");
				temp= Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
				Arrays.sort(temp);//오름차순			
				answer[i]= temp[commands[i][2]-1];
				System.out.print(answer[i]);
			}
			System.out.print("]");
			
			return answer;
		}
	
}
