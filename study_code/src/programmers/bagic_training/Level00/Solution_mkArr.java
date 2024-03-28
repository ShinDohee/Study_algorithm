package programmers.bagic_training.Level00;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.*;

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

    /**
     * Todo: repaet안되는거 확인
     * @param picture
     * @param k
     * @return
     */
    public String[] solution(String[] picture, int k) {
        String[] enlarged = new String[picture.length * k];
        for (int i = 0; i < picture.length; i++) {
            StringBuilder row = new StringBuilder();
            for (char pixel : picture[i].toCharArray()) {
//                row.append(valueOf(pixel).repeat(k));
            }
            for (int j = 0; j < k; j++) {
                enlarged[i * k + j] = row.toString();
            }
        }
        return enlarged;
    }


    /**
     * 정사각형으로 만들기
     * 제출 내역
     * 문제 설명
     * 이차원 정수 배열 arr이 매개변수로 주어집니다. arr의 행의 수가 더 많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고, 열의 수가 더 많다면 행의 수가 열의 수와 같아지도록 각 열의 끝에 0을 추가한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
     *
     * 제한사항
     * 1 ≤ arr의 길이 ≤ 100
     * 1 ≤ arr의 원소의 길이 ≤ 100
     * arr의 모든 원소의 길이는 같습니다.
     * 1 ≤ arr의 원소의 원소 ≤ 1,000
     * @param arr
     * @return
     */
    public static  int[][] solution_mksquare(int[][] arr) {
        int max = Math.max(arr.length, arr[0].length);
        // 행의 개수와 열의 개수를 맞추어 새로운 배열 생성
        int[][] answer = new int[max][max];
        for(int i=0; i<arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }

    /**
     * 특별한 이차원 배열 1
     * 제출 내역
     * 문제 설명
     * 정수 n이 매개변수로 주어질 때, 다음과 같은 n × n 크기의 이차원 배열 arr를 return 하는 solution 함수를 작성해 주세요.
     *
     * arr[i][j] (0 ≤ i, j < n)의 값은 i = j라면 1, 아니라면 0입니다.
     * @param n
     * @return
     */
    public static int[][] solution_specialArr1(int n) {
        int[][] answer = new int [n][n];
        for(int i=0; i<answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                if( i == j) answer[i][j] =1;
            }
        }

        return answer;
    }

    /**
     * 특별한 이차원 배열 2
     * 제출 내역
     * 문제 설명
     * n × n 크기의 이차원 배열 arr이 매개변수로 주어질 때, arr이 다음을 만족하면 1을 아니라면 0을 return 하는 solution 함수를 작성해 주세요.
     *
     * 0 ≤ i, j < n인 정수 i, j에 대하여 arr[i][j] = arr[j][i]
     * @param arr
     * @return
     */
    public int solution_specailArr2(int[][] arr) {
        int answer = 0;
        for(int i=0; i<arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if( arr[i][j] != arr[j][i])  return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
//        solution_mkArr(4);
        int[][] arr= {{57, 192, 534, 2},{9, 345, 192, 999}};
        int[][] arr1= {{57, 192 },{9, 345,},{123,123},{23232,2312}};
        solution_mksquare(arr1);

    }
}
