package hackerrank_30p;

import java.util.Scanner;

public class Solution_Day11_2DArrays {
	public static int solution(int [][] arr) {
			int max=0;
			int tmp =0;
		for (int i = 0; i < arr.length-2; i++) {
			for (int j = 0; j < arr[i].length-2; j++) {
				tmp= arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
				if(i ==0 && j == 0) max=tmp; // 음수일 경우를 대비해서, 첫 tmp 값 초기화 
				
				if(max<tmp) max=tmp;
			}
			
		}
		
		return max;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        System.out.println(solution(arr));

        scanner.close();
    }
}
