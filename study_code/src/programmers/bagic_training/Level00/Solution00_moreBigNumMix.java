package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution00_moreBigNumMix {
    public static int solution(int a, int b) {
        int result1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int result2 = Integer.parseInt(String.valueOf(b) + String.valueOf(a));

        // 두 연산 결과 중 큰 값을 반환
        return Math.max(result1, result2);

        //매게변수가 2개라는 제한이 있기 때문에, 나올수 있는 경우의 수는 2가지 중 한가지이므로
        // 위와 같은 간단한 로직으로 구현 하였다. 하지만... 주어진 수가 3개 이상일 경우에도 충분히 커버 칠 수 있는 로직을 구현해야 한다.
        // 해보쟈

    }

    public static int solution_overSize (int a, int b , int c) {
        int result = Arrays.asList(a, b, c)
                .stream()
                .map(Object::toString)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining())
                .chars()
                .map(Character::getNumericValue)
                .reduce(0, (x, y) -> x * 10 + y);

        return result;
    }


    public static void main(String[] args) {

    }
}
