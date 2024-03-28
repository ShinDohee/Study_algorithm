package programmers.bagic_training.Level01;

public class Math_num {
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
}
