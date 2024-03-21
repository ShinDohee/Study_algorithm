package programmers.bagic_training.Level00;

import java.util.Arrays;

/**
 * TODO: 미완
 */
public class Solution00_basicOp {
    public static  int solution_basicOp(String binomial) {
        String [] binomialArr = binomial.split(" ");
        int answer = Arrays.stream(binomialArr)
                .mapToInt(token -> {
                    // 문자열을 정수로 변환
                    try {
                        return Integer.parseInt(token);
                    } catch (NumberFormatException e) {
                        // 연산자인 경우에는 0을 반환
                        return 0;
                    }
                })

                .reduce((a, b) -> {
                    // 연산자에 따라 계산 수행
                    if (binomialArr[1].equals("+")) {
                        return a + b;
                    } else if (binomialArr[1].equals("-")) {
                        return a - b;
                    } else if (binomialArr[1].equals("*")) {
                        return a * b;
                    } else {
                        // 잘못된 연산자인 경우 예외 발생
                        throw new IllegalArgumentException("Invalid operator");
                    }
                })
                .getAsInt(); // 결과값 반환

        return answer;
    }

    public static void main(String[] args) {

    }
}
