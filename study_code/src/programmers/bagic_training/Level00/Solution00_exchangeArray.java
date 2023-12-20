package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    /**
     * n 번째 원소까지
     * 정수 리스트 num_list와 정수 n이 주어질 때, num_list의 첫 번째 원소부터 n 번째 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     * https://school.programmers.co.kr/learn/courses/30/lessons/181889
     * @param num_list
     * @param n
     * @return
     */
    public int[] solution_copyofArray(int[] num_list, int n) {
        int[] answer = Arrays.copyOfRange(num_list, 0, n);
        return answer;
    }

    /**
     * 원소들의 곱과 합
     * 문제 설명
     * 정수가 담긴 리스트 num_list가 주어질 때,
     * 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.
     * @param num_list
     * @return
     */
    public int solution_diffSumOrMulti(int[] num_list) {
;
        int answer = Arrays.stream(num_list).sum()* Arrays.stream(num_list).sum() >Arrays.stream(num_list).reduce(1, (a, b) -> a * b)? 1:0;
        return answer;
    }

    /**
     *카운트 업
     문제 설명
     정수 start_num와 end_num가 주어질 때,
     start_num부터 end_num까지의 숫자를 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     *
     */
    public int[] solution_makeArray(int start_num, int end_num) {
        int[] answer = IntStream.rangeClosed(start_num, end_num +1).toArray();

        return answer;
    }


    /**
     * 조건에 맞게 수열 변환하기 3
     *  정수 배열 arr와 자연수 k가 주어집니다.
     *
     * 만약 k가 홀수라면 arr의 모든 원소에 k를 곱하고, k가 짝수라면 arr의 모든 원소에 k를 더합니다.
     *
     * 이러한 변환을 마친 후의 arr를 return 하는 solution 함수를 완성해 주세요.
     * @param arr
     * @param k
     * @return
     */
    public int[] solution_optionArray(int[] arr, int k) {
        int[] answer = {};
        if(k%2 ==0 ){
            //모든원소에 k 더하고
            answer=  Arrays.stream(arr).map(x->x+k).toArray();
        }else {
            // 모든 원소에 k 곱하고
            answer=  Arrays.stream(arr).map(x->x*k).toArray();
        }

        return answer;
    }

    /**
     * 배열 만들기 1
     * 정수 n과 k가 주어졌을 때, 1 이상 n이하의 정수 중에서 k의 배수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
     * @param n
     * @param k
     * @return
     */
    public int[] solution(int n, int k) {
        int[] answer = IntStream.range(0, n)
                .filter(x -> x%k ==0).toArray();
        return answer;
    }


    /**
     * 배열의 길이에 따라 다른 연산하기
     * 정수 배열 arr과 정수 n이 매개변수로 주어집니다.
     * arr의 길이가 홀수라면 arr의 모든 짝수 인덱스 위치에 n을 더한 배열을,
     * arr의 길이가 짝수라면 arr의 모든 홀수 인덱스 위치에 n을 더한 배열을 return 하는 solution 함수
     * @param arr
     * @param n
     * @return
     */
    public int[] solution(int[] arr, int n) {
        if(arr.length %2 ==1) {
            IntStream.range(0, arr.length)
                    .filter(i -> i%2==0)
                    .forEach( index -> arr[index]=arr[index]+n);
        }else {
            IntStream.range(0, arr.length)
                    .filter(i -> i%2==1)
                    .forEach( index -> arr[index]=arr[index]+n);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 100, 99, 98};

        // solution 메서드 호출
        int[] result = solution(arr);

        // 결과 출력
        Arrays.stream(result).forEach(System.out::println);
    }
}
