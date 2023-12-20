package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution00_mixNumSum {
    public static int solution(int[] num_list) {
        int answer = 0;
        String evenNum =Arrays.stream(num_list).filter(x -> x%2 ==0).mapToObj(String::valueOf).collect(Collectors.joining());
        String oddNum =Arrays.stream(num_list).filter(x -> x%2 ==1).mapToObj(String::valueOf).collect(Collectors.joining());

        return  Integer.parseInt(evenNum) + Integer.parseInt(oddNum);
    }


    /**
     *      * 두 수의 연산값 비교하기
     *      * 연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
     *      *
     *      * 12 ⊕ 3 = 123
     *      * 3 ⊕ 12 = 312
     *      * 양의 정수 a와 b가 주어졌을 때, a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.
     *      *
     *      * 단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.
     * @param a
     * @param b
     * @return
     */
    public int solution_vsDifferNumber(int a, int b) {
        int answer = Integer.parseInt( String.valueOf(a) + String.valueOf(b));
        int result_Num = 2*a*b ;
        return answer >= result_Num ? answer : result_Num;
    }



    public static void main(String[] args) {
        int [] num = {3, 4, 5, 2, 1}    ;
       System.out.println( solution(num));
    }
}
