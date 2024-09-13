package programers.codeTest.java8;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dynamic_programingSkill1 {
    public int solution(int N, int number) {
        // dp 리스트: N을 1번부터 8번까지 사용한 경우의 수를 저장할 리스트
        List<Set<Integer>> dp = new ArrayList<>();

        // dp 인덱스 0부터 8까지 초기화 (인덱스는 사용 횟수 의미)
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }

        // N을 1번만 사용한 경우는 N 자신
        dp.get(1).add(N);

        // 2번부터 8번까지 N을 사용하는 경우 계산
        for (int i = 2; i < 9; i++) {
            // N을 i번 반복해서 만든 숫자를 추가 (예: N=5일 때 2번 사용하면 55)
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));

            // j는 i보다 작은 값을 순회하며, j번과 i-j번의 결과 조합
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);

                // set1과 set2를 사칙연산으로 조합
                for (int num1 : set1) {
                    for (int num2 : set2) {
                        dp.get(i).add(num1 + num2);  // 더하기
                        dp.get(i).add(num1 - num2);  // 빼기
                        dp.get(i).add(num1 * num2);  // 곱하기
                        if (num2 != 0) dp.get(i).add(num1 / num2);  // 나누기
                    }
                }
            }

            // 만약 dp[i]에 목표 숫자가 있다면 그때의 i(사용 횟수)를 반환
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        // 8번까지 사용해도 목표 숫자를 만들 수 없으면 -1 반환
        return -1;
    }
}
