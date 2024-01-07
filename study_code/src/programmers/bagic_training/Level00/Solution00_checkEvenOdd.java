package programmers.bagic_training.Level00;

import java.util.Arrays;
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

    /**
     * 홀수 vs 짝수
     * 문제 설명
     * 정수 리스트 num_list가 주어집니다. 가장 첫 번째 원소를 1번 원소라고 할 때, 홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을 return 하도록 solution 함수를 완성해주세요. 두 값이 같을 경우 그 값을 return합니다.
     * @param num_list
     * @return
     */
    public static int solution_oddEvenSumVs(int[] num_list) {
        int odd_sum =IntStream.range(0, num_list.length).filter(i -> i%2==0).map(index -> num_list[index]).sum();
        int even_sum = IntStream.range(0, num_list.length).filter(i -> i%2==1).map(index -> num_list[index]).sum();

        return  Math.max(odd_sum, even_sum);
    }
    public static void main(String[] args) {
//        solution()
        int[] num_list = {4, 2, 6, 1, 7, 6};

        solution_oddEvenSumVs(num_list);
    }

}
