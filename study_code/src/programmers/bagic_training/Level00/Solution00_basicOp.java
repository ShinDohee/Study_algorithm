package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * TODO: 미완
 */
public class Solution00_basicOp {
    public static  int solution_basicOp(String binomial) {
        String [] binomialArr = binomial.split(" ");
        String[] numbers = Pattern.compile("\\D+")  // 숫자가 아닌 문자 (Non-digit)를 구분자로 사용
                .split(binomial);
        int answer = Arrays.stream(numbers)
                .mapToInt(Integer::new)
                .reduce((a,b)->{
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
                .getAsInt();
        return answer;
    }

    public static void main(String[] args) {
        solution_basicOp("0 - 7777"	);
    }
}
