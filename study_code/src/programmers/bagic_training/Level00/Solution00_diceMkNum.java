package programmers.bagic_training.Level00;

public class Solution00_diceMkNum {
    /**
     * 1부터 6까지 숫자가 적힌 주사위가 세 개 있습니다. 세 주사위를 굴렸을 때 나온 숫자를 각각 a, b, c라고 했을 때 얻는 점수는 다음과 같습니다.
     *
     * 세 숫자가 모두 다르다면 a + b + c 점을 얻습니다.
     * 세 숫자 중 어느 두 숫자는 같고 나머지 다른 숫자는 다르다면 (a + b + c) × (a2 + b2 + c2 )점을 얻습니다.
     * 세 숫자가 모두 같다면 (a + b + c) × (a2 + b2 + c2 ) × (a3 + b3 + c3 )점을 얻습니다.
     *
     * a	b	c	result
     * 2	6	1	9
     * 5	3	3	473
     * 4	4	4	110592
     *
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static  int solution(int a, int b, int c) {
        int answer = 0;
        if( a != b  && b != c && c != a){
            //숫자 세개가 모두다를 경우
            answer = a + b + c;
        }else if (a == b && b == c ){
            //숫자 세개가 모두 같을 경우
            answer = (int) ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) * (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)));
        }else {
            answer = (int) ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2) ));
        }
        return answer;
    }

    public static void main(String[] args) {
            System.out.println(solution(5,3,3));
    }
}
