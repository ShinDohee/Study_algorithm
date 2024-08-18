package programmers.bagic_training.backjoon_problem;
import java.io.*;
import java.util.*;
public class Q2493_Solutions {
    public static int[] findReceivers(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 모든 탑을 왼쪽에서 오른쪽으로 순회
        for (int i = 0; i < n; i++) {
            // 현재 탑보다 낮거나 같은 높이의 탑들을 스택에서 제거
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }

            // 스택이 비어있지 않다면, 현재 탑의 신호를 받을 수 있는 탑의 인덱스를 찾음
            if (!stack.isEmpty()) {
                result[i] = stack.peek() + 1; // 1-based index
            } else {
                result[i] = 0; // 수신할 탑이 없을 경우
            }

            // 현재 탑의 인덱스를 스택에 추가
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        int[] heights = new int[n];

        String[] heightStrings = reader.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(heightStrings[i]);
        }

        int[] result = findReceivers(heights);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
