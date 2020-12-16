package programmers.codeTest.java;

import java.math.BigInteger;

public class Solution_201215_Test01 {
    public static String solution(String a, String b) {
        BigInteger big_A= new BigInteger(a);
        BigInteger big_B = new BigInteger(b);
        
    	  StringBuilder sb = new StringBuilder();
    	  sb.insert(0, big_A.add(big_B));
       
        return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(solution("512345", "5678"));
	}
}
