package hackerrank_30p;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution_SalesbyMatch {
	  // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	int count =0;
    	Map map = new HashMap<Integer, Integer>();

    	for (int i = 0; i < ar.length; i++) {
    		int value_count = (int) map.getOrDefault(ar[i], 0)+1;
			map.put(ar[i],  value_count);
		}
    	
    	for (Object i : map.values()) {
			
			count += (int) i/2;
			
		}
    	
    	
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
