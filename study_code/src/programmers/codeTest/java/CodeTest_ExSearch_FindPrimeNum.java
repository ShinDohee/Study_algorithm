package programmers.codeTest.java;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 소수 찾기
 * 2024.07.04 다시 풀기
 *
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 입출력 예
 * numbers	return
 * "17"	3
 * "011"	2
 *
 */
public class CodeTest_ExSearch_FindPrimeNum {
    public int solution(String numbers) {
        Set<Integer> numbersSet = generateNumbers(numbers);
        return countPrimes(numbersSet);
    }

    public Set<Integer> generateNumbers(String input) { // 순열을 ㅅ ㅐㅇ성하여 모든 가능한 숫자를 추가
        Set<Integer> resultSet = new HashSet<>(); //중복 제거를 위한 자료형
        char[] digits = input.toCharArray(); // 각 자리 숫자를 int 배열로 저장
        boolean[] visited = new boolean[digits.length];
        Arrays.sort(digits); // 순열을 오름차순으로 생성하기 위해 정렬

        for (int r = 1; r <= digits.length; r++) {
            permutation(digits, visited, new StringBuilder(), resultSet, r);
        }

        return resultSet;
    }

    private void permutation(char[] digits, boolean[] visited, StringBuilder sb, Set<Integer> resultSet, int r) { //재귀적으로 순열을 생성하며, 중복된 숫자는 건너뛰게끔 구현
        if (sb.length() == r) {
            int num = Integer.parseInt(sb.toString());
            if (!isPrime(num)) {
                return;
            }
            resultSet.add(num);
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (visited[i] || (i > 0 && digits[i] == digits[i - 1] && !visited[i - 1])) {
                continue; // 중복된 숫자는 건너뜀
            }
            visited[i] = true;
            sb.append(digits[i]);
            permutation(digits, visited, sb, resultSet, r);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= num) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

    private int countPrimes(Set<Integer> numbersSet) {
        return (int) numbersSet.stream()
                .filter(this::isPrime)
                .count();
    }

    public void main(String[] args) {
        String numbers = "017";
        System.out.println(solution(numbers));
    }
}
