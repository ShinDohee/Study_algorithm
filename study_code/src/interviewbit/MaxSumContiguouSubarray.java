package interviewbit;

import java.util.List;

public class MaxSumContiguouSubarray {
    public static int maxSubArray(final List<Integer> A) {
         int maxSum = A.get(0); // 현재 최대 합 
        int maxSumResult = A.get(0); //최종 최대합

        for (int i = 1; i < A.size(); i++) {
            maxSum = Math.max(A.get(i), maxSum + A.get(i));
            if (maxSum > maxSumResult) {
                maxSumResult = maxSum;
            }
        }

        return maxSumResult;
    }

    public static void main(String[] args) {
        List<Integer> A = List.of(1, 1, 3, 4, 1, 2, 1, 5, 4);
        System.out.println("합: " + maxSubArray(A)); // 출력: 6 (부분 배열: [4, -1, 2, 1])
    }
}


