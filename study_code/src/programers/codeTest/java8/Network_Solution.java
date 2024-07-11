package programers.codeTest.java8;

import java.util.Arrays;

public class Network_Solution {

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(computers, visit, i);
                answer++;
            }
        }

        return answer;

    }


    /**
     *
     * @param computers 컴퓨터 배열
     * @param visit 방문 체크 배열
     * @param comNum  방문하는 컴퓨터
     * @return
     */
    private static void dfs (int[][] computers, boolean [] visit, int comNum ){
        visit[comNum] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[comNum][i] == 1 && !visit[i]) {
                dfs(computers, visit, i);
            }
        }
    }
}
