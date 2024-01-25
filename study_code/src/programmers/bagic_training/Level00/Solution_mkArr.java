package programmers.bagic_training.Level00;

import java.util.stream.IntStream;

public class Solution_mkArr {
    /**
     * 정수를 나선형으로 배치하기
     * 문제 설명
     * 양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
     *
     * @param n
     * @return
     *
     * TODO : 블로그
     */
    public static  int[][] solution_mkArr(int n) {
        int[][] answer = new int [n][n];

        int currentNum = 1;
        int minRow = 0, minCol = 0;
        int maxRow = n - 1, maxCol = n - 1;

        while (currentNum <= n * n) {
            for (int i = minCol; i <= maxCol; i++) {
                answer[minRow][i] = currentNum++;
            }
            minRow++;

            for (int i = minRow; i <= maxRow; i++) {
                answer[i][maxCol] = currentNum++;
            }
            maxCol--;

            if (minRow <= maxRow) {
                for (int i = maxCol; i >= minCol; i--) {
                    answer[maxRow][i] = currentNum++;
                }
                maxRow--;
            }

            if (minCol <= maxCol) {
                for (int i = maxRow; i >= minRow; i--) {
                    answer[i][minCol] = currentNum++;
                }
                minCol++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution_mkArr(4);
    }
}
