package programers.codeTest.java8;

import java.math.BigInteger;

public class Square_Solution {
    public static long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        long answer = ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
        return answer;
}


    public static void main(String[] args) {
        System.out.println(solution(4,5));
        System.out.println(solution(7,15));
        System.out.println( solution(8, 12));

    }
}
