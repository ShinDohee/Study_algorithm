package programmers.codeTest.java;

import java.util.Arrays;

public class codetest_hash2 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book); // 배열정렬 (오름차순)

        for (int i = 0; i < phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) { //startWith() 함수로 사용하여 배열의 접두사 여부 확인
				return false;
			}
		}
        
        return answer;
    }
    
    public static void main(String[] args) {
    	String [] sfsdf= {"12","121111111123","135","121" ,"567","88"};
    	System.out.println(solution(sfsdf));
    	
    }
}
