package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    public static int[] solution_mk2powLength(int[] arr) {
        int taretLength = 1;
        while(taretLength < arr.length){
            taretLength *= 2;
        }
        int[] answer = Arrays.copyOf(arr, taretLength);

        return answer;
    }

    /**
     * 뒤에서 5등까지
     * 문제 설명
     * 정수로 이루어진 리스트 num_list가 주어집니다. num_list에서 가장 작은 5개의 수를 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     * @param num_list
     * @return
     */
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.stream(num_list).sorted().limit(5).toArray();
        return answer;
    }
    public static void main(String[] args) {
        int [] arr = {4, 2, 6, 1, 7, 6};
        System.out.println(solution_nPer(arr, 4));
    }
}
