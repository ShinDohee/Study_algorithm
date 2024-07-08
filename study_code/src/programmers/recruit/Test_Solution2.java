package programmers.recruit;
import java.util.*;
public class Test_Solution2 {
    // 메인 솔루션 메서드
    public static int solution(String[] tickets, int roll, String[][] shop, int money) {
        // 각 티켓의 가격을 저장하는 맵
        Map<String, Integer> ticketPrices = new HashMap<>();
        for (String ticket : tickets) {
            String[] parts = ticket.split(" ");
            String type = parts[0];
            int price = Integer.parseInt(parts[1]);
            ticketPrices.put(type, price);
        }

        int n = shop.length; // 상점의 수

        // BFS를 위한 큐 초기화
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, money, 0));

        int maxGoldTickets = 0; // 최대 황금 티켓 수

        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 현재 상점 인덱스가 상점 개수를 초과하면 탈출
            if (current.shopIndex >= n) {
                maxGoldTickets = Math.max(maxGoldTickets, current.goldTickets);
                continue;
            }

            // 현재 상점에서 가능한 모든 상품 조합을 탐색
            for (int k = 0; k < shop[current.shopIndex].length; k++) {
                String ticket = shop[current.shopIndex][k];
                int price = ticketPrices.get(ticket);

                // 티켓의 가격보다 현재 돈이 많거나 같은 경우에만 구매 시도
                if (current.money >= price) {
                    queue.offer(new State(current.shopIndex, current.money - price, current.goldTickets + 1));
                }
            }

            // 상점을 새로고침하는 경우 다음 상점으로 이동
            if (current.shopIndex + 1 < n) {
                queue.offer(new State(current.shopIndex + 1, current.money - roll, current.goldTickets));
            }
        }

        // 최대 황금 티켓 수를 반환 (3개의 일반 티켓을 황금 티켓으로 교환하는 규칙에 따름)
        return maxGoldTickets / 3;
    }

    // 상태를 나타내는 클래스
    static class State {
        int shopIndex; // 현재 상점 인덱스
        int money;     // 현재 가지고 있는 돈
        int goldTickets; // 현재까지 황금 티켓 개수

        public State(int shopIndex, int money, int goldTickets) {
            this.shopIndex = shopIndex;
            this.money = money;
            this.goldTickets = goldTickets;
        }
    }

    public static void main(String[] args) {
        // 테스트 케이스 예시
        String[] tickets1 = {"A 1", "B 2", "C 5", "D 3"};
        int roll1 = 10;
        String[][] shop1 = {
                {"B", "C", "B", "C"},
                {"A", "A", "A", "B"},
                {"D", "D", "C", "D"}
        };
        int money1 = 30;
        System.out.println(solution(tickets1, roll1, shop1, money1));  // Expected output: 2

        // 추가 테스트 케이스들을 여기에 추가할 수 있습니다
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
