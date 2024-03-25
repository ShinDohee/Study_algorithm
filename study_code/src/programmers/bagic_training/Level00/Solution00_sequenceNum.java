package programmers.bagic_training.Level00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

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

    /**
     *
     전국 대회 선발 고사
     제출 내역
     문제 설명
     0번부터 n - 1번까지 n명의 학생 중 3명을 선발하는 전국 대회 선발 고사를 보았습니다. 등수가 높은 3명을 선발해야 하지만, 개인 사정으로 전국 대회에 참여하지 못하는 학생들이 있어 참여가 가능한 학생 중 등수가 높은 3명을 선발하기로 했습니다.

     각 학생들의 선발 고사 등수를 담은 정수 배열 rank와 전국 대회 참여 가능 여부가 담긴 boolean 배열 attendance가 매개변수로 주어집니다.
     전국 대회에 선발된 학생 번호들을 등수가 높은 순서대로 각각 a, b, c번이라고 할 때
     10000 × a + 100 × b + c를 return 하는 solution 함수를 작성해 주세요.
     [3, 7, 2, 5, 4, 6, 1]	[false, true, true, true, true, false, false]	20403
     * @param rank
     * @param attendance
     * @return
     */
    public static int solution_rank(int[] rank, boolean[] attendance) {
        PriorityQueue<Integer> pq = IntStream.range(0, rank.length)
                .filter(i -> attendance[i])
                .mapToObj(i -> rank[i])
                .collect(PriorityQueue::new, PriorityQueue::offer, PriorityQueue::addAll);

        int[] selected = IntStream.range(0, 3)
                .mapToObj(i -> pq.poll())
                .mapToInt(Integer::intValue)
                .toArray();

        int a = findIndex(rank, selected[0]);
        int b = findIndex(rank, selected[1]);
        int c = findIndex(rank, selected[2]);

        return a * 10000 + b * 100 + c;
    }

    private static int findIndex(int[] array, int targetValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == targetValue) {
                return i;
            }
        }
        return -1; // 찾고자 하는 값이 배열에 없는 경우
    }

    public static void main(String[] args) {
      int [] num = {3, 7, 2, 5, 4, 6, 1};
      boolean [] attention = {false, true, true, true, true, false, false};

        solution_rank(num, attention);

    }
}
