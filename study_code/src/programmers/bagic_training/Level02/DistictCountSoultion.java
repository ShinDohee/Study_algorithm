package programmers.bagic_training.Level02;

import java.util.Arrays;

/**
 * 정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때, array에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성해보세요.
 */
public class DistictCountSoultion {
    public static int solution(int[] array, int n) {
        int answer = (int) Arrays.stream(array)
                .filter(x-> x== n)
                .count();
        return answer;
    }

    public static void main(String[] args) {
        int [] array = {1, 1, 2, 3, 4, 5};

        System.out.println( solution(array,1));

        System.out.println( "sdfsdfsdsf");
    }

}
