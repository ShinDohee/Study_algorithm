package programmers.bagic_training.Level01;

import java.util.Arrays;

/**
 * 배열의 평균값
 * 제출 내역
 * 문제 설명
 * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 0 ≤ numbers의 원소 ≤ 1,000
 * 1 ≤ numbers의 길이 ≤ 100
 * 정답의 소수 부분이 .0 또는 .5인 경우만 입력으로 주어집니다.
 */
public class Solution_calcArray {
    public double solution(int[] numbers) {
        return (double)Arrays.stream(numbers).average().orElse(-1);
    }
}
