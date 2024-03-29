package programmers.bagic_training.Level01;

public class Solution01_sharePie {
    public static int solution_sharePie01(int n) {
        int answer = 0;
        if(n%7 == 0 ) answer = n/7;
        else answer = n/7 +1;
        return answer;
    }

    /**
     * 피자 나눠 먹기 (2)
     * 제출 내역
     * 문제 설명
     * 머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다.
     * 피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때,
     * n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
     * @param n
     * @return
     */
    public static int solution_sahrePie02(int n) {
        int answer = lcm(n,6);
        return answer/6;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // 최대공약수
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    /**
     * 피자 나눠 먹기 (3)
     * 제출 내역
     * 문제 설명
     * 머쓱이네 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라줍니다.
     * 피자 조각 수 slice와 피자를 먹는 사람의 수 n이 매개변수로 주어질 때,
     * n명의 사람이 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
     *
     *
     * 입출력 예 #1
     *
     * 10명이 7조각으로 자른 피자를 한 조각 이상씩 먹으려면 최소 2판을 시켜야 합니다.
     * 입출력 예 #2
     *
     * 12명이 4조각으로 자른 피자를 한 조각 이상씩 먹으려면 최소 3판을 시켜야 합니다.
     *
     * @param slice
     * @param n
     * @return
     */
    public int solution_sharePie03(int slice, int n) {
        int numOfPizza =1;
        if(slice < n){
            while ( numOfPizza*slice < n){
                numOfPizza++;
            }
        }
       return  numOfPizza ;

    }

    public static void main(String[] args) {
        solution_sahrePie02(6);
    }
}
