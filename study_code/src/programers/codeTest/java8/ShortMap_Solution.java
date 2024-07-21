package programers.codeTest.java8;
import before.Solution;

import java.util.*;
public class ShortMap_Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 방향 벡터: 동, 서, 남, 북
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // BFS를 위한 큐
        Queue<int[]> queue = new LinkedList<>();
        // 시작 지점 (1, 1) -> (0, 0)으로 변환
        queue.offer(new int[] {0, 0});

        // 방문 체크
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        int distance = 1;  // 시작 지점도 하나의 칸으로 카운트

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // 도착 지점에 도달하면 거리 반환
                if (x == n - 1 && y == m - 1) {
                    return distance;
                }

                // 네 방향으로 이동
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    // 맵 범위를 벗어나지 않고, 벽이 아니며, 방문하지 않은 경우
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            distance++;
        }

        // 상대 팀 진영에 도착할 수 없는 경우
        return -1;
    }
    public static void main(String[] args) {
        ShortMap_Solution sol = new ShortMap_Solution();
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println(sol.solution(maps)); // 예상 출력: 11
    }
}
