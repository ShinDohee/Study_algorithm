package hackerrank_structures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class solution_03 {
	 // Complete the reverseArray function below.
    static ArrayList<Integer> reverseArray(int[] a) {

    	
    	ArrayList<Integer> emp = new ArrayList<Integer>();
   	
    	for (int i : a) {
			emp.add(i);
		}
    	
    	Collections.reverse(emp);
    	
    	return emp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            
            
        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        ArrayList res = reverseArray(arr);
     
       
        
        for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i)+" ");
		}
       
        
        
        scanner.close();
    }
}
