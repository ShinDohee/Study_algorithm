package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution07OfArrayBirds {
    static int Answer;

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {      
        int type = 0, type_count =1, max_Count =0;
        Map numberArr = new HashMap();
        for(int i =0 ; i<arr.size(); i++){
            if(numberArr.get(arr.get(i)) != null ){
                int count = (int) numberArr.get(arr.get(i))+1;
                numberArr.put(arr.get(i), count );
                
            }else {
                numberArr.put(arr.get(i), 1 );
                
            }            

        }
        

        Set set = numberArr.keySet();
        Iterator<Integer> keys = numberArr.keySet().iterator();
        while (keys.hasNext()) {

            Integer key = keys.next();
            System.out.println(key);
            if(type_count < (int) numberArr.get(key) ){
                type = key ;
                type_count= (int) numberArr.get(key);
            }
      

        }
        
        return type;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr.add(arrItem);
        }

        int result = migratoryBirds(arr);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
