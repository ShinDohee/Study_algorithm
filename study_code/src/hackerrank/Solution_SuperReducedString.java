package hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SuperReducedString {
    static String Answer = "";
    static void superReducedString(String printString) {
        boolean rootBoolean = true;
         String vsString = "";
         
     
         while (rootBoolean) {             
             for(int i=0; i< printString.length()-1; i++){
                 if(printString.charAt(i) == printString.charAt(i+1)){
                     vsString = printString.substring(i, i+2);
                     printString = printString.replace(vsString, "");     
                      break;
                     
                 }else if(i == printString.length()-2 && printString.charAt(i) != printString.charAt(i+1)){
                     rootBoolean = false;
                 }
                 
             }
             
             if("".equals(printString)){
                 printString = "Empty String";
                  rootBoolean = false;
                 
             }
             
        }
        
         if(!rootBoolean){
             Answer = printString;
         }
         
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();
        superReducedString(s);
        System.out.println(Answer);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
