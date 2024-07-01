package interviewbit;

public class StairsSoultion {
    public static int climbStairs(int A) {
        if(A <=2) return A;

        int[] dp = new int[A + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= A; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[A];
    }

    public static void main(String[] args) {
        // 테스트를 위한 예제
        int A = 3; // 예시: 10 계단
        System.out.println(" Result " + climbStairs(A)); // 출력: 89
    }
}
