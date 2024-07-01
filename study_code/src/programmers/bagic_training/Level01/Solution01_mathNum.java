package programmers.bagic_training.Level01;

import java.util.stream.IntStream;

public class Solution01_mathNum {
    /**
     * 분수의 덧셈
     * 제출 내역
     * 문제 설명
     * 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1,
     * 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
     * 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
     * @param numer1
     * @param denom1
     * @param numer2
     * @param denom2
     * @return
     */
    public int[] solution_fractionSum(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int [2];

        //분모의 최소 공배수 구함
        int lcm = lcm(denom1,denom2);
        //분자의 합
        int sum_numer = numer1*(lcm/denom1) + numer2*(lcm/denom2);
        //최대공약수 구함

        int gcd= gcd(lcm, sum_numer);




        return new int[]{sum_numer/gcd, lcm/gcd};
    }

    //최소공배수
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
     * 옷가게 할인 받기
     * 제출 내역
     * 문제 설명
     * 머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인해줍니다.
     * 구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.
     * @param price
     * @return
     */
    public static int solution_dcprice(int price) {
        double dcRate = 0;
        if(price>=100000 && price < 300000)  dcRate =0.05;
        else if (price>=300000 && price < 500000) dcRate =  0.1;
        else if (price >=500000) dcRate=0.2;

        return (int) (price*(1-dcRate));
    }


    /**
     * 아이스 아메리카노
     * 제출 내역
     * 문제 설명
     * 머쓱이는 추운 날에도 아이스 아메리카노만 마십니다. 아이스 아메리카노는 한잔에 5,500원입니다. 머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때, 머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와 남는 돈을 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
     * @param money
     * @return
     */
    public int[] solution_iceAmericano(int money) {

        return new int []{money/5500, money%5500};
    }


    /**
     * 나이 출력
     * 제출 내역
     * 문제 설명
     * 머쓱이는 선생님이 몇 년도에 태어났는지 궁금해졌습니다. 2022년 기준 선생님의 나이 age가 주어질 때, 선생님의 출생 연도를 return 하는 solution 함수를 완성해주세요
     *
     * 제한사항
     * 0 < age ≤ 120
     * 나이는 태어난 연도에 1살이며 매년 1월 1일마다 1살씩 증가합니다.
     * @param age
     * @return
     */
    public int solution_calcAge(int age) {
        int answer = 0;
        return 2022-age +1;
    }

    /**
     * 머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다.
     * 양꼬치는 1인분에 12,000원,
     * 음료수는 2,000원입니다.
     * 정수 n과 k가 매개변수로 주어졌을 때,
     * 양꼬치 n인분과 음료수 k개를 먹었다면 총얼마를 지불해야 하는지 return 하도록 solution 함수를 완성해보세요.
     * @param n
     * @param k
     * @return
     */

    public int solution(int n, int k) {
        int serviceCount = n/10;
        return (n*1200)+(k-serviceCount)*2000;
    }

    public int solution_sumeven(int n) {
        int answer = IntStream.range(0, n).filter(i -> i%2==0).sum();
        return answer;
    }
}
