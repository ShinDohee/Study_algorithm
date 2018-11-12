package hackerrank;


import java.io.IOException;
import java.util.Scanner;


public class Solution_TimeConversion {
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
       String result = "";

        String time = s.substring(0, 2);
        String appendtime = s.substring(2, s.length()-2);

        if(s.contains("PM")){
            if(!"12".equals(time)){
                time = Integer.parseInt(time) + 12 +"";
                
            }
        }else {
            if("12".equals(time)){
                time = "00";
                
            }
        }
        
        result = time;      
        result += appendtime;
        return result;
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
