package hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution_BigSorting {

    // 시간 줄이기 
    // Complete the bigSorting function below.
    static ArrayList<BigInteger> bigSorting(String[] unsorted) {
        String [] sorted = new String [unsorted.length];
        ArrayList<BigInteger> convertUnSort = new ArrayList<>();
       
        for (int i = 0; i < unsorted.length; i++) {
            convertUnSort.add(new BigInteger(unsorted[i]));
        }        
       Collections.sort(convertUnSort);        
    
        return convertUnSort;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        ArrayList<BigInteger> result = bigSorting(unsorted);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i).toString());

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
