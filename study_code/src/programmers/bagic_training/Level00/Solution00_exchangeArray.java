package programmers.bagic_training.Level00;

import java.util.Arrays;

public class Solution00_exchangeArray {

    /**
     * 정수 배열 arr가 주어집니다. arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고, 50보다 작은 홀수라면 2를 곱합니다. 그 결과인 정수 배열을 return 하는 solution 함수를 완성해 주세요.
     *
     * 제한사항
     * 1 ≤ arr의 길이 ≤ 1,000,000
     * 1 ≤ arr의 원소의 값 ≤ 100
     * 입출력 예
     * arr	result
     * [1, 2, 3, 100, 99, 98]	[2, 2, 6, 50, 99, 49]
     * @param arr
     * @return
     */
    public static int[] solution(int[] arr) {
        return   Arrays.stream(arr)
                .map( num ->{
                    if(num >49 && num%2 ==0){
                        return num/2;
                    }else if(num <50  && num%2 ==1){
                        return num*2;
                    }else{
                        return num;
                    }
                        }

                ).toArray();

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 100, 99, 98};

        // solution 메서드 호출
        int[] result = solution(arr);

        // 결과 출력
        Arrays.stream(result).forEach(System.out::println);
    }
}
