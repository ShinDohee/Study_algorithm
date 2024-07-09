package programers.codeTest.java8;

public class TargetNumber_Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        // 모든 숫자를 다 사용했을 때
        if (index == numbers.length) { // 모든 숫자를 사용한 상황, 현재의 sum 이 타겟과 가ㅌ으면 1을 반환하고, 아니면 9 을 반환하여 실패한 경우를 무시
            // 현재 합계가 타겟과 같으면 1을 반환하여 경우의 수에 더함
            return sum == target ? 1 : 0;
        }
        // 현재 숫자를 더하는 경우와 빼는 경우를 모두 재귀적으로 탐색
        return dfs(numbers, target, index + 1, sum + numbers[index]) // 더하는 경우
                + dfs(numbers, target, index + 1, sum - numbers[index]); //
    }

    public static void main(String[] args) {
        TargetNumber_Solution tn = new TargetNumber_Solution();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = tn.solution(numbers, target);
        System.out.println("Number of ways to get target " + target + ": " + result);
    }
}
