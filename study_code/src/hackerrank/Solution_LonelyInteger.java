package hackerrank;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution_LonelyInteger {
    // Complete the lonelyinteger function below.
    static int lonelyinteger(int[] a) {
        List resultList = new ArrayList<Integer>();
        // 
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        resultList = list.parallelStream().distinct().collect(Collectors.toList()); //중복 제거 
        List resultList2 = new ArrayList<Integer>();
        for (int j = 0; j < resultList.size(); j++) {
            int count =0;
            int kkk = (int)resultList.get(j);
            for(int i  =0 ; i< list.size() ;i++ ){
                if(kkk == list.get(i)){
                    count ++;
                }
            }
            
            if(count == 1){
                resultList2.add(kkk);
            }
        }
        
        return (int)resultList2.get(resultList2.size()-1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        System.out.print(lonelyinteger(a));

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
