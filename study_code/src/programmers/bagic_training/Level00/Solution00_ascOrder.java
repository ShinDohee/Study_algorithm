package programmers.bagic_training.Level00;

import java.util.Arrays;

public class Solution00_ascOrder {
    //
    public static int[] solution(int[] num_list) {
        int[] answer = {};

        Arrays.sort(num_list);
        answer = Arrays.copyOfRange(num_list, 5, num_list.length);
        return answer;
    }

    public static void main(String[] args) {
        int [] num_list = {12, 4, 15, 46, 38, 1, 14, 56, 32, 10};
        solution(num_list);
    }
}
