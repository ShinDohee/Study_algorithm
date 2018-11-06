package test;

import java.util.Scanner;

public class Solution_minMAxSum {
    static void miniMaxSum(int[] arr) {
        //5개 중 4개만 sum 해서 최대값 최소 값 적용 
        long max =0, min=0, sum =0;
        int index =0;
        while(index < arr.length){
            sum =0; // 덧셈 초기화 
            
            for(int i =0; i< arr.length ;i++){
                if(i != index){
                    sum += arr[i];
                }
            }
            
            if(min==0){
                min= sum;
            }
            
            if(max< sum){
                max = sum;
            }
            
            if(min > sum){
                min = sum;
            }
            
            index++;
            
        }
        
        System.out.println(min+" "+max);
        
        
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
