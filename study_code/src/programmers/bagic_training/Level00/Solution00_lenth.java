package programmers.bagic_training.Level00;

import java.util.Arrays;

public class Solution00_lenth {
    /**
     * 정수가 담긴 리스트 num_list가 주어질 때, 리스트의 길이가 11 이상이면 리스트에 있는 모든 원소의 합을 10 이하이면 모든 원소의 곱을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 2 ≤ num_list의 길이 ≤ 20
     * 1 ≤ num_list의 원소 ≤ 9
     * 입출력 예
     * num_list	result
     * [3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1]	51
     * [2, 3, 4, 5]	120
     */
    public static int solution(int[] num_list) {
        int answer = 0;

        if(num_list.length > 11){
            //모든 원소 합
            for (int i :num_list ) {
                answer += i;
            }
        }else {
            //모든 원소 곱
            for (int i :num_list ) {
                answer *= i;
            }
        }


        return answer;
    }
    public static int another_solution(int[] num_list) {
        int answer=0;

        if(num_list.length > 10){
            answer= Arrays.stream(num_list).reduce(0, Integer::sum);
        }else {
            answer= Arrays.stream(num_list).reduce(1, (a,b) -> a*b);
        }

        return answer;
    }


    public static void test() {
        int [] num_list = {3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1};
        int [] num_list2 = {2, 3, 4, 5};
        System.out.println( solution(num_list));
        System.out.println( solution(num_list2));

    }
}
