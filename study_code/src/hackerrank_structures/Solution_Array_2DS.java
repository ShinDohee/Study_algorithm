package hackerrank_structures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 6*6
 * 
 * */

public class Solution_Array_2DS {
	static int hourglassSum(int[][] arr) {
		int xlen = arr.length;
		int ylen = arr[0].length;
		ArrayList<Integer> rsult = new ArrayList<Integer>();
		
		for(int i=0; i<xlen-2; i++) {
			for(int j=0; j < ylen-2; j++) {
                int tmp = 
                arr[0+j][0+i] + arr[0+j][1+i] + arr[0+j][2+i]
                              + arr[1+j][1+i]
              + arr[2+j][0+i] + arr[2+j][1+i] + arr[2+j][2+i];

               rsult.add(tmp) ;


			}
		}
		
		return Collections.max(rsult);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);


        System.out.println(result);
        
        
        scanner.close();
        
    }
}
