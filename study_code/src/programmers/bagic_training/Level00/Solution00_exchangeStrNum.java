package programmers.bagic_training.Level00;

public class Solution00_exchangeStrNum {
    public int solution(String n_str) {
        int answer = 0;
        answer= Integer.parseInt(n_str);
        return answer;
    }

    /**
     * 문자열 정수의 합
     * 한 자리 정수로 이루어진 문자열 num_str이 주어질 때, 각 자리수의 합을 return하도록 solution 함수를 완성해주세요.
     * https://school.programmers.co.kr/learn/courses/30/lessons/181849
     * @param num_str
     * @return
     */
    public static  int solution_Sum(String num_str) {

        return  num_str.chars().map(Character::getNumericValue)
                .sum();
        /**
         * chars()는 문자열을 IntStream으로 변환하는 메서드 ,
         * 이 메서드는 주어진 문자열의 각 문자에 해당하는 정수 값을 가지는 스트림을 생성함!
         * chars() 메서드의 반환 타입은 IntStream이므로,
         * String 을 그대로 출력 한다면,  Unicode 코드 포인트 값이 출력됨
         * 만약 각 문자를 문자로서 다루고 싶다면, mapToObj 등의 메서드를 사용하여 변환해주어야 합니다.
         */
    }

    public static void main(String[] args) {

    }
}
