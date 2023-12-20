package programmers.bagic_training.Level00;

import java.util.stream.IntStream;

public class Solution00_checkEvenOdd {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/181935
     * 양의 정수 n이 매개변수로 주어질 때,
     * n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고
     * n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는 solution 함수를 작성해 주세요.
     */

    public static int solution(int n) {
        int answer = n%2 == 0 ?
                IntStream.range(0,n+1).filter(i -> i%2 ==0).map( num -> num*num).sum()
                : IntStream.range(0,n+1).filter(i -> i%2 ==1).sum() ;
        /**
         * IntStream.range(0,n+1) 에서, 마지막 index는 포함이 아니니까, 크기를 +1 해줘야함
         */

        return answer;
    }

    public static void main(String[] args) {
//        solution()
    }

}
