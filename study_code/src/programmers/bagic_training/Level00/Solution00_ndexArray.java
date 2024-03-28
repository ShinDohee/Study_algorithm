package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution00_ndexArray {
    public int[] solution(int[] num_list, int n) {

        return Arrays.copyOfRange(num_list, n, num_list.length);
    }

    public static int [] solution_nPer (int[] num_list, int n) {
        int newSize = ((num_list.length%n) ==0) ? num_list.length / n:  num_list.length / n+1;
        //  처음엔 해당 변수에 num_list.length / n 를 넣었더니, 배열 idex오류 나서 위 조건으로 해결함
        int[] answer = new int[newSize];

        for (int i = 0, j = 0; i < num_list.length; i++) {
            if (i % n == 0) {
                answer[j++] = num_list[i];
            }
        }
        return answer;
    }

    public static int[] solution_mk2powLength(int[] arr) {
        int taretLength = 1;
        while(taretLength < arr.length){
            taretLength *= 2;
        }
        int[] answer = Arrays.copyOf(arr, taretLength);

        return answer;
    }

    /**
     * 이차원 배열 대각선 순회하기
     * 제출 내역
     * 문제 설명
     * 2차원 정수 배열 board와 정수 k가 주어집니다.
     *
     * i + j <= k를 만족하는 모든 (i, j)에 대한 board[i][j]의 합을 return 하는 solution 함수를 완성해 주세요.
     * @param board
     * @param k
     * @return
     */
    public int solution(int[][] board, int k) {
        int answer = 0;
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j <board[i].length; j++) {
                if(i+j <= k)  answer += board[i][j];
            }

        }
        return answer;
    }

    /**
     * 커피 심부름
     * 제출 내역
     * 문제 설명
     * 팀의 막내인 철수는 아메리카노와 카페 라테만 판매하는 카페에서 팀원들의 커피를 사려고 합니다. 아메리카노와 카페 라테의 가격은 차가운 것과 뜨거운 것 상관없이 각각 4500, 5000원입니다. 각 팀원에게 마실 메뉴를 적어달라고 하였고, 그 중에서 메뉴만 적은 팀원의 것은 차가운 것으로 통일하고 "아무거나"를 적은 팀원의 것은 차가운 아메리카노로 통일하기로 하였습니다.
     *
     * 각 직원이 적은 메뉴가 문자열 배열 order로 주어질 때, 카페에서 결제하게 될 금액을 return 하는 solution 함수를 작성해주세요. order의 원소는 아래의 것들만 들어오고, 각각의 의미는 다음과 같습니다.
     * 아메리카노 4500 . 라떼 5000
     * order의 원소	의미
     * "iceamericano", "americanoice"	차가운 아메리카노
     * "hotamericano", "americanohot"	따뜻한 아메리카노
     * "icecafelatte", "cafelatteice"	차가운 카페 라테
     * "hotcafelatte", "cafelattehot"	따뜻한 카페 라테
     * "americano"	아메리카노
     * "cafelatte"	카페 라테
     * "anything"	아무거나
     * @param order
     * @return
     */
    public int solution_coffeeOrder(String[] order) {
        AtomicInteger answer = new AtomicInteger();
        Arrays.stream(order)
                .forEach(x ->{
                    if(x.contains("cafelatte")) answer.addAndGet(5000);
                    else answer.addAndGet(4500);
                });
        return answer.get();
    }


    /**
     * 뒤에서 5등까지
     * 문제 설명
     * 정수로 이루어진 리스트 num_list가 주어집니다. num_list에서 가장 작은 5개의 수를 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     * @param num_list
     * @return
     */
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.stream(num_list).sorted().limit(5).toArray();
        return answer;
    }
    public static void main(String[] args) {
        int [] arr = {4, 2, 6, 1, 7, 6};
        System.out.println(solution_nPer(arr, 4));
    }
}
