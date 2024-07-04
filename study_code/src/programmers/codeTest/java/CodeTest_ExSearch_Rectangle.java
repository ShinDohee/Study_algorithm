package programmers.codeTest.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CodeTest_ExSearch_Rectangle {
    public static int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        // 각 명함을 가로로 눕혔을 때의 최대 가로 길이와 최대 세로 길이 구하기
        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);

            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxWidth * maxHeight;
    }



    public static void main(String[] args) {
        int [][] size ={
                {60, 50},{30, 70},{60, 30},{80, 40}
        };

        solution(size);
    }
}
