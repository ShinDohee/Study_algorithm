package programmers.bagic_training.Level02;

import java.util.Arrays;

public class ArraysSolutions {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = Arrays.copyOfRange(numbers, num1, num2+1);
        return answer;
    }
}
