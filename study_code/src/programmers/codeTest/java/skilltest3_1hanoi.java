package programmers.codeTest.java;

import java.util.Arrays;

public class skilltest3_1hanoi {
	public static int[][] answer = {};
	public static int x =0;
	
    /*
     * n개를 other기둥을 사용해 from -> to로 옮기기
     * @param n 옮기는 원판
     * @param from 출발지
     * @param other 도움지
     * @param to 도착지
     */
    public static void hanoi(int n, int from, int other, int to){
        if(n == 0)
            return;
        hanoi(n-1, from, to, other);  // n-1개의 원판을 목적지가 아닌 곳(other)로 옮겨놓음.
        answer[x][0] = from;          // 마지막 원판을 목적지로 옮김.
        answer[x++][1] = to;          // 마지막 원판을 목적지로 옮김.
        hanoi(n-1, other, from, to);  // 목적지가 아닌 곳(other)에 옮겨놓았던 원판들을 목적지로 옮김
    }
      
    public int[][] solution(int n) {
        int num = (int)Math.pow(2, n) - 1;    // 하노이의 이동 횟수: 2^n - 1
        answer = new int[num][2]; // 횟수는 num만큼, 열은 3개(세 개의 기둥)
        hanoi(n, 1, 2, 3);
        return answer;
    }
    
    

}
	