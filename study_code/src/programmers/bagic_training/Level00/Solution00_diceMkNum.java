package programmers.bagic_training.Level00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution00_diceMkNum {
    /**
     * 주사위 게임
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

    /**
     * 주사위 게임 3
     * 문제 설명
     * 1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.
     *
         * 네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
         * 세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
         * 주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
        * 어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
        * 네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
     * 네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
     *
     *
     * 이건 85점.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */


    public static int solution_diceGame3(int a, int b, int c, int d) {
        int [] dice = {a,b,c,d};

        Arrays.sort(dice); // 정렬 하고
        int diff_num =0;
        // 결과 계산
        int result=0;
        if (dice[0] == dice[3]) { // 네수가 같을때
            result = 1111 * dice[0];
        } else if (dice[1] == dice[2] && dice[0] != dice[3]) { //3개가 같을 때
            diff_num =  (dice[0] != dice[1]) ? dice[0] : dice[3];
            result =(int)Math.pow( (10*dice[1]+diff_num),2);

        } else if (dice[0] == dice[1] && dice[2] == dice[3]) { //2개씩 같을 때 ex. 3,3,5,5
            result = (dice[1] + dice[2]) * (Math.abs(dice[1]- dice[2]));
        } else if (Arrays.stream(dice).distinct().count()==3) { //2개가 같고, 나머지 다를 때,
             ;
          int [] ex_num =  Arrays.stream(dice)
                    .filter(number -> number != findDuplicate(dice , 2))
                    .boxed()  // 기본형을 참조형으로 변환
                    .mapToInt(Integer::intValue).toArray();


            result = ex_num[0] * ex_num[1];
        } else if (Arrays.stream(dice).distinct().count()==4 ){
            result = dice[0];
        }

        return result;

//        int dup_num; // 중복 되는 수
//        int []  ex_arr = {}; // 중복되지 않는 수의 배열
//       ArrayList<NumberCountObject>  arr = new ArrayList<>();
//        NumberCountObject myObject = new NumberCountObject(42, 3);
//        return answer;
    }

    /**
     * 번호와 해당 번호의 중복 여부 확인을 위한 객체 생성
     */
    private static class NumberCountObject {
        private int number;
        private int count;

        // 생성자
        public NumberCountObject(int number, int count) {
            this.number = number;
            this.count = count;
        }

        // Getter 메서드
        public int getNumber() {
            return number;
        }

        public int getCount() {
            return count;
        }

        // 다른 메서드 등 필요한 로직 추가 가능
    }
    /**
     * 중복
     * @param array
     * @param n ==> 2번 중복되는 수
     * @return
     */
    public static int findDuplicate(int[] array, int n){
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) == n) {
                return num;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
//            System.out.println(solution(5,3,3));

            solution_diceGame3(	2, 5, 2, 6);
    }
}

