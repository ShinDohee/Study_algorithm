package programmers.bagic_training.Level00;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution00_removeArray {
    /**
     * 배열의 원소 삭제하기
     * 문제 설명
     * 정수 배열 arr과 delete_list가 있습니다.
     * arr의 원소 중 delete_list의 원소를 모두 삭제하고 남은 원소들은 기존의 arr에 있던 순서를 유지한 배열을 return 하는 solution 함수를 작성해 주세요.
     * @param arr
     * @param delete_list
     * @return
     */
    public static int[] solution_removeIndex(int[] arr, int[] delete_list) {
        int[] answer = Arrays.stream(arr).filter( x -> !Arrays.stream(delete_list)
                .anyMatch(value -> value == x)).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[] arr =     {293, 1000, 395, 678, 94};
        int[] delete_list=  {94, 777, 104, 1000, 1, 12};
        solution_removeIndex(arr, delete_list);
    }

}
