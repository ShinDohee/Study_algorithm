package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_TimeConversion {
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         * 집가서 마저 수정 
         */
        Matcher pmMatcher = Pattern.compile("PM").matcher(s);


        if(pmMatcher.find()){
           
        }else {
            
        }
        
        return "zzz";
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();
        System.out.println(timeConversion(s));
        
//        bw.write(result);
//        bw.newLine();

//        bw.close();
    }
}
