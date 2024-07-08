package programmers.recruit;

import java.util.*;

/***
 *
 TFT 라는 게임을 플레이 하고 있습니다.
 게임에서 주어진 자금으로 황금 티켓을 가장 많이 모으는 것이 목표 입니다.

 상점에서 일반 티켓 구입하기
 상점 새로고침 하기
 동일한 일반 티켓 3개를 황금티켓 1개로 교환하기

 상점에는 일반 티켓 M개가 진열되어있습니다.
 당신을 티켓 가격을 지불하여 진열되어있는 티켓 중 원하는 티켓을 구매할 수 있습니다.
 또, 일정 금액을 상점에 지불하고 상점을 최대 N-1번 새로고침 할 수 있습니다.
 새로고침이란 상점에 진열중이던 티켓을 모두 폐기하고 새로운 일반 티켓 M 개를 진열하는 행동입니다.

 당신은 상점에 진열되어있는 티켓의 패턴을 분석하여 상점을 새로고침 했을 때, 매번 어떤 티켓이 진열 될 지 예측하는데 성공했습니다. 당신이 예측한 결과를 바탕으로 황금 티켓을 가장 많이 모을 수 있는 방법으로 자금을을 사용하려고 합니다.

 <일반 티켓의 종류 ( 티켓이름 : 가격 )>
 A : 1
 B : 2
 C : 5
 D : 5

 <상점의 티켓 진열 예측 (상점 순서 : 진열티켓)>
 최초 상점 : B,C,B,C
 두번째 상점: A,A,A,B
 세번째 상점 : D,D,C,D


 일반티켓읮 종류와 상점의 티켓 진열 패턴이 위 와 같고 상점 새로고침에 필요한 금액이 10, 당신에게 주어진 자금이 30이라고 가정해보겠습니다. 최초 상점에서 B를 2개 구입하고, 새로고침한 뒤, 두번째 상점에서 A를 3개 , B를 1개를 구매하면 총 2*2+10+1*3+2*1=19 만큼 자금을 사용하여  A를 3개 , B를 3개 구매할 수있습니다. 이는 황금티켓 3개로 교환할 수 있으며, 이보다 더 많은 황금 티켓을 모으는 방법은 없습니다.

 게임에 등장하는 모든 일반 티켓의 정보가 담긴 문자열 TICKETS, 상점을 새로그침에 필요한 금액을 나타내는 정수ㅠ ROLL,  상점의 새로고침 예측이 담긴 2차원 배열 SHOP과 당신에게 주어진 자금을 나타내는 정수 MONEY 가 매개변수로 주어집니다. 이때 모을 수 있는 황금 티켓 개수의 최댁밧을 ㄱETURN 하도록 SOLUTION 을 완성해주세요.



 */
public class Test_Solution1 {
    public static int solution(String[] tickets, int roll, String[][] shop, int money) {
        // 각 티켓의 가격을 저장하는 맵
        Map<String, Integer> ticketPrices = new HashMap<>();

        // 티켓 가격 맵 초기화
        for (String ticket : tickets) {
            String[] parts = ticket.split(" ");
            String type = parts[0];
            int price = Integer.parseInt(parts[1]);
            ticketPrices.put(type, price);
        }

        int n = shop.length; // 상점의 수
        int m = shop[0].length; // 각 상점에 진열된 티켓 수

        int[] maxTickets = {0}; // 최대 황금 티켓 수를 저장할 배열

        // 티켓의 재고를 관리할 배열
        boolean[][] shopStock = new boolean[n][m];

        // DFS 탐색 시작
        dfs(shop, shopStock, 0, money, 0, roll, maxTickets, ticketPrices);

        // 최대 황금 티켓 수를 3으로 나눈 값을 반환 (3개의 일반 티켓을 황금 티켓으로 교환하는 규칙에 따름)
        return maxTickets[0] / 3;
    }

    /**
     * DFS를 사용하여 모든 상점에서 가능한 모든 티켓 구매 조합을 탐색합니다.
     *
     * @param shop           각 상점에서 진열된 티켓 종류를 나타내는 2차원 문자열 배열
     * @param currentShop    현재 탐색 중인 상점의 인덱스
     * @param currentMoney   현재 가지고 있는 자금
     * @param currentTicket    현재까지 구매한 황금 티켓 개수
     * @param roll           상점을 새로고침하는 데 필요한 비용
     * @param maxTickets 최대 황금 티켓 개수를 저장할 배열
     */
    private static void dfs(String[][] shop, boolean[][] shopStock, int currentShop, int currentMoney, int currentTicket, int roll, int[] maxTickets, Map<String, Integer> ticketPrices) {
        // 모든 상점을 탐색한 경우, 최대 황금 티켓 수를 업데이트하고 반환
        if (currentShop == shop.length) {
            maxTickets[0] = Math.max(maxTickets[0], currentTicket);
            return;
        }

        // 현재 상점에서 구매할 수 있는 각 티켓의 재고를 고려하여 탐색
        for (int k = 0; k < shop[currentShop].length; k++) {
            String ticket = shop[currentShop][k];
            int price = ticketPrices.get(ticket);

            // 티켓의 재고가 남아있는 경우에만 구매 시도
            if (!shopStock[currentShop][k] && currentMoney >= price) {
                shopStock[currentShop][k] = true; // 티켓 재고 감소
                dfs(shop, shopStock, currentShop, currentMoney - price, currentTicket + 1, roll, maxTickets, ticketPrices);
                shopStock[currentShop][k] = false; // 티켓 재고 복구 (Backtracking)
            }
        }

        // 상점을 새로고침하는 경우 다음 상점으로 이동
        dfs(shop, shopStock, currentShop + 1, currentMoney - roll, currentTicket, roll, maxTickets, ticketPrices);
    }
    public static void main(String[] args) {
///**
// * TEST01
// */E
//        String [] tickets = {
//                "A 1",
//                "B 2",
//                "C 5",
//                "D 3"
//        } ;
//        int roll = 10;
//        int[][] SHOP = {
//                { 'B', 'C', 'B', 'C' },
//                { 'A', 'A', 'A', 'B' },
//                { 'D', 'D', 'C', 'D' }
//        };
//        int MONEY = 30;

//        result: 2
//
//
///**
// * TEST2
// */
//        String [] tickets = {
//                "A 1",
//                "B 2",
//                "C 5",
//                "D 3"
//        } ;
//        int roll = 10;
//        int[][] SHOP = {
//                { 'B', 'C', 'B', 'C' },
//                { 'A', 'A', 'A', 'B' },
//                { 'D', 'D', 'C', 'D' }
//        };
//        int MONEY = 100;
//
//        result : 4
//
//
//        /**
//         * TEST3
//         */
//
//        String [] tickets = {
//                "A 2",
//                "B 1"
//
//        } ;
//        int roll = 1;
//        int[][] SHOP = {
//        { 'A','A','A' },
//        { 'A','B','B' },
//        { 'A','B','B' },
//        { 'A','B','B' }
//        };
//        int MONEY = 9;
//
//        result : 2
//
//        /**
//         * TEST4
//         */
//
//        String [] tickets = {
//                "A 1",
//                "B 2",
//                "C 5",
//                "D 3"
//        } ;
//        int roll = 5;
//        int[][] SHOP = {
//               { 'A','A','A' },
//               { 'A','B','B' },
//               { 'A','B','B' },
//               { 'A','B','B' }
//        };
//        int MONEY = 19;
//
//        result: 2

//        System.out.println(solution(tickets, roll, SHOP, MONEY));  // Output: 3


        String[] tickets1 = {"A 1", "B 2", "C 5", "D 3"};
        int roll1 = 10;
        String[][] shop1 = {
                {"B", "C", "B", "C"},
                {"A", "A", "A", "B"},
                {"D", "D", "C", "D"}
        };
        int money1 = 30;
        System.out.println("1 : "+solution(tickets1, roll1, shop1, money1));  // Expected output: 2

        // TEST2
        String[] tickets2 = {"A 1", "B 2", "C 5", "D 3"};
        int roll2 = 10;
        String[][] shop2 = {
                {"B", "C", "B", "C"},
                {"A", "A", "A", "B"},
                {"D", "D", "C", "D"}
        };
        int money2 = 100;
        System.out.println(solution(tickets2, roll2, shop2, money2));  // Expected output: 4

        // TEST3
        String[] tickets3 = {"A 2", "B 1"};
        int roll3 = 1;
        String[][] shop3 = {
                {"A", "A", "A"},
                {"A", "B", "B"},
                {"A", "B", "B"},
                {"A", "B", "B"}
        };
        int money3 = 9;
        System.out.println(solution(tickets3, roll3, shop3, money3));  // Expected output: 2

        // TEST4
        String[] tickets4 = {"A 1", "B 2", "C 5", "D 3"};
        int roll4 = 5;
        String[][] shop4 = {
                {"A", "A", "A"},
                {"A", "B", "B"},
                {"A", "B", "B"},
                {"A", "B", "B"}
        };
        int money4 = 19;
        System.out.println(solution(tickets4, roll4, shop4, money4));
    }
}
