package programmers.bagic_training.Level00;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution00_sequenceNum {
    /**
     * 등차수열의 특정한 항만 더하기
     * 문제 설명
     * 두 정수 a, d와 길이가 n인 boolean 배열 included가 주어집니다.
     * 첫째항이 a, 공차가 d인 등차수열에서 included[i]가 i + 1항을 의미할 때,
     * 이 등차수열의 1항부터 n항까지 included가 true인 항들만 더한 값을 return 하는 solution 함수를 작성해 주세요.
     * @param a
     * @param d
     * @param included
     * @return
     */
    public static int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for(int i =0; i < included.length; i++){
            if(included[i] == true){
                answer += a + (d * i);
            }
        }


        return answer;
    }

    /**
     * 콜라츠 수열 만들기
     * 문제 설명
     * 모든 자연수 x에 대해서 현재 값이 x이면 x가 짝수일 때는 2로 나누고, x가 홀수일 때는 3 * x + 1로 바꾸는 계산을 계속해서 반복하면 언젠가는 반드시 x가 1이 되는지 묻는 문제를 콜라츠 문제라고 부릅니다.
     *
     * 그리고 위 과정에서 거쳐간 모든 수를 기록한 수열을 콜라츠 수열이라고 부릅니다.
     *
     * 계산 결과 1,000 보다 작거나 같은 수에 대해서는 전부 언젠가 1에 도달한다는 것이 알려져 있습니다.
     *
     * 임의의 1,000 보다 작거나 같은 양의 정수 n이 주어질 때 초기값이 n인 콜라츠 수열을 return 하는 solution 함수를 완성해 주세요.
     * @param n
     * @return
     *
     *
     *         int[] answer =  IntStream.range(l,r)
     *                 .filter(x -> String.valueOf(x).chars().allMatch(c -> c == '5' || c == '0'))
     *                 .toArray();
     *         return answer.length == 0 ? new int[]{-1} : answer;
     */
    public int[] solution_Collatzseq(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (n != 1){
            arr.add(n);
            if(n%2==0) {
                n = n / 2;
            }else {
                n = (3*n)+1;
            }


        }


        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {

    }
}
