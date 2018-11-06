package test;

import java.util.Scanner;

public class Solution02Voels {
    public static void main(String args[]) throws Exception {
        /*
           The method below means that the program will read from input.txt, instead of standard(keyboard) input.
           To test your program, you may save input data in input.txt file,
           and call below method to read from the file when using nextInt() method.
           You may remove the comment symbols(//) in the below statement and use it.
           But before submission, you must remove the freopen function or rewrite comment symbols(//).
         */     
        
        /*
           Make new scanner from standard input System.in, and read data.
         */
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        
        int T = Integer.parseInt(sc.nextLine());
            for(int test_case = 0; test_case < T; test_case++) {
                String rightVowel = "aeiou";
                int minlength = 1001 ,startIdx =0, endIdx =0;
                //전체길이
                int strLength = Integer.parseInt(sc.nextLine());
                //최소길이 
                String fullStr = sc.nextLine();
                
                for (int i = 0; i < strLength ; i++) {
                    int num=1, fP=i , rP=0;
                    while (fP<strLength && rP<rightVowel.length()) {
                        if(fullStr.charAt(fP) == rightVowel.charAt(rP)){
                            rP++;
                        }
                        fP++; num++;
                    }
                    
                    if(minlength > num && rP==rightVowel.length()){
                      startIdx = i+1; endIdx= fP;
                      minlength= num;
                    }
                }
                    
          
               System.out.println("Case #"+(test_case+1));
               if(minlength == 1001){
                   System.out.println("-1 -1");
               }else{
                   System.out.println(startIdx+" "+endIdx);
                  
               }
                
                /////////////////////////////////////////////////////////////////////////////////////////////
                /*
               Implement your algorithm here.
               The answer to the case will be stored in variable Answer.
                 */
                /////////////////////////////////////////////////////////////////////////////////////////////
                
                
                // Print the answer to standard output(screen).
            }
            
        }
 }

