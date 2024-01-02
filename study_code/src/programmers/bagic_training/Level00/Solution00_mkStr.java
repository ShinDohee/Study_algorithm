package programmers.bagic_training.Level00;

public class Solution00_mkStr {

    /**
     *  문자열에 따라 다음과 같이 두 수의 크기를 비교하려고 합니다.
     *
     *     두 수가 n과 m이라면
     *     ">", "=" : n >= m
     *     "<", "=" : n <= m
     *     ">", "!" : n > m
     *     "<", "!" : n < m
     *
     *     두 문자열 ineq와 eq가 주어집니다.
     *     ineq는 "<"와 ">"중 하나고,
     *     eq는 "="와 "!"중 하나입니다.
     *     그리고 두 정수 n과 m이 주어질 때,
     *     n과 m이 ineq와 eq의 조건에 맞으면 1을 아니면 0을 return하도록 solution 함수를 완성해주세요.
     *
     *     첫 시도 : 66점ㅌ
     * @param ineq
     * @param eq
     * @param n
     * @param m
     * @return
     */
    public static int solution(String ineq, String eq, int n, int m) {
        if (ineq.equals(">") && eq.equals("=")) {
            return n  >= m ? 1 : 0;
        } else if (ineq.equals(">") && eq.equals("!")) {
            return n > m ? 1 : 0;
        } else if (ineq.equals("<") && eq.equals("=")) {
            return n <= m ? 1 : 0;
        } else if (ineq.equals("<") && eq.equals("!")) {
            return n < m ? 1 : 0;
        }else {
            // 예외 처리: ineq와 eq가 주어진 조건을 만족하지 않는 경우
            return -1;
        }
    }

    public static void main(String[] args) {

    }

}
