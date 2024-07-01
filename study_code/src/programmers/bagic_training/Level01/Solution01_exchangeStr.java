package programmers.bagic_training.Level01;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution01_exchangeStr {

    /**
     *
     문자열 뒤집기
     제출 내역
     문제 설명
     문자열 my_string이 매개변수로 주어집니다. my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.
     * @param my_string
     * @return
     */
    public String solution_reversStr(String my_string) {

        return new StringBuilder(my_string).reverse().toString();
    }

    public String solution_repeatPrint(String my_string, int n) {
        return my_string.chars()                          // 문자열을 문자(int) 스트림으로 변환
                .mapToObj(c -> String.valueOf((char) c)  // 각 문자를 문자열로 변환
                        .repeat(n))                      // 문자열을 n번 반복
                .collect(Collectors.joining());
    }

    public static String solution_remot(String my_string, String letter) {

        return my_string.replace(letter,"");

    }

    public static void solution_printStar(int n) {
        IntStream.range(1, n + 1)
                .forEach(i -> {
                    IntStream.range(0, i)
                            .forEach(j -> System.out.print("*"));
                    System.out.println();
                });

    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        solution_printStar(n);
    }
}
