package test;

import java.util.Scanner;

public class Solution05StarBucks {
    static int Answer;

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
        /*
         * 스타벅스는 하나의 문화다.
그렇기 때문에 이 세상에 있는 문제들은 스타벅스와 연관이 있기도 하다.
그런 여러 문제 중 하나로, 어떤 커피를 구매할 것이냐가 있다.

A사의 신입사원 김커피씨는 점심 시간이 끝나가면서 상사에게 커피를 사오라는 명령을 받았다.
김커피씨는 법인 카드를 최대 K원 이용할 수 있다.
김커피씨가 근무중인 부서에는 N명의 사람들이 있는데, 각각 원하는 커피의 종류가 정해져 있다.
스타벅스에는 M개의 커피 종류가 있는데, 커피마다 1 ~ M까지의 번호가 주어져 있다.

스타벅스 커피들의 가격과, 부서 사람들의 커피 기호와, 법인 카드 지출의 한계치인 K가 주어졌을 때,
김커피씨가 N명 모두가 행복하게 주어진 돈으로 커피를 구매할 수 있을지 구하는 프로그램을 작성하라.
         *
         * 
         * 첫 줄에 테스트케이스 T가 주어진다 (T <= 20).
첫 줄에 N, M, K가 차례대로 주어진다 (1 <= N <= 30, 1 <= M <= 20, 0 <= K <= 100 000).
그 다음 N개의 줄 중 i번째 줄에는 ci 가 주어진다 (1 <= ci <= M). ci 는 i번째 사람이 좋아하는 커피의 종류를 나타낸다.
그 다음 M개의 줄에는 pi 가 주어진다 (3 000 <= pi <= 8 000).
         * */
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
            /*
               Implement your algorithm here.
               The answer to the case will be stored in variable Answer.
             */
            /////////////////////////////////////////////////////////////////////////////////////////////


            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
