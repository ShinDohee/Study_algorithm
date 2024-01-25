package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution00_findNum {
    public int solution(int[] num_list, int n) {
        AtomicInteger answer = new AtomicInteger();
        Arrays.stream(num_list).filter(value -> n == value ).forEach(value -> {
            answer.set(1);
        });
        return answer.get();
    }

    /**
     *
     가까운 1 찾기
     문제 설명
     정수 배열 arr가 주어집니다.
     이때 arr의 원소는 1 또는 0입니다.
     정수 idx가 주어졌을 때,
     idx보다 크면서 배열의 값이 1인 가장 작은 인덱스를 찾아서 반환하는 solution 함수를 완성해 주세요.

     단, 만약 그러한 인덱스가 없다면 -1을 반환합니다.

     return IntStream.range(idx, arr.length).filter(i -> arr[i] == 1).findFirst().orElse(-1);

     * @param arr
     * @param idx
     * @return
     */
    public static int solutionFind1(int[] arr, int idx) {
        int answer = 0;
        for(int i = idx ; i< arr.length  ; i++){
            if(arr[i] == 1) {
                return i;
            }

        }
        return answer ==0 ? -1 : answer;
    }
}
