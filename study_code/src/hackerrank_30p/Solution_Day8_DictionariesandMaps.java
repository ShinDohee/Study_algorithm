package hackerrank_30p;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_Day8_DictionariesandMaps {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        Map<String, Integer> hpMap = new HashMap<>();
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            hpMap.put(name, phone);
        }
        System.out.println();
        while(in.hasNext()){
            String s = in.next();
           if(hpMap.get(s) == null) {
        	   System.out.println("Not found");
           }else {
        	   System.out.println(s+"="+hpMap.get(s));
           }
            // Write code here
        }
        in.close();
    }
}
