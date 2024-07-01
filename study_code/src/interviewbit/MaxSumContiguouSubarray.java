package interviewbit;

import java.util.List;

public class MaxSumContiguouSubarray {
    public static int maxSubArray(final List<Integer> A) {
         int maxSum = A.get(0); 
        int result = A.get(0); //최종 최대합

        for (int i = 1; i < A.size(); i++) {
            maxSum = Math.max(A.get(i), maxSum + A.get(i));
            if (maxSum > result) {
                result = maxSum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = List.of(1, 1, 3, 4, 1, 2, 1, 5, 4);
        System.out.println("합: " + maxSubArray(A));
    }
}


