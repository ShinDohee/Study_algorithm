package test;

import java.util.Scanner;

public class Solution03Number {
    static int Answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            // 몇번째를 구할건지
            int N = sc.nextInt();
            int x = 0;
            if (N % 2 == 1) {
                x = 4;
            } else {
                x = 7;
            }
            for (int i = (N - 1) / 2; i > -1; i--) {
                Answer += x * Math.pow(10, i);
            }
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }

}
