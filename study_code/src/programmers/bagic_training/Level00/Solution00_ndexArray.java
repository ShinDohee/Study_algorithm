package programmers.bagic_training.Level00;

import java.util.Arrays;

public class Solution00_ndexArray {
    public int[] solution(int[] num_list, int n) {

        return Arrays.copyOfRange(num_list, n, num_list.length);
    }

    public static int [] solution_nPer (int[] num_list, int n) {
        int newSize = ((num_list.length%n) ==0) ? num_list.length / n:  num_list.length / n+1;
        //  처음엔 해당 변수에 num_list.length / n 를 넣었더니, 배열 idex오류 나서 위 조건으로 해결함
        int[] answer = new int[newSize];

        for (int i = 0, j = 0; i < num_list.length; i++) {
            if (i % n == 0) {
                answer[j++] = num_list[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] arr = {4, 2, 6, 1, 7, 6};
        System.out.println(solution_nPer(arr, 4));
    }
}
