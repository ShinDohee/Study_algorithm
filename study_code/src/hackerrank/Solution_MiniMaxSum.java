package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution_MiniMaxSum {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int except_idx = 0;
        List sumList = new ArrayList();
        long sum =0;
        while (except_idx < arr.length) {
            sum =0;
            for (int i = 0; i < arr.length; i++) {
                if(except_idx != i){
                   sum += arr[i]; 
                }
            }
            
            sumList.add(sum);
            except_idx++;
        }
        
        Collections.sort(sumList);
        
        System.out.println(sumList.get(0)+" "+sumList.get(sumList.size()-1));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
