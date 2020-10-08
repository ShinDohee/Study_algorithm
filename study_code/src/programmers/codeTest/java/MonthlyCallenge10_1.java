package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
 * 답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
45	1200	0021	7
따라서 7을 return 해야 합니다.
입출력 예 #2

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
125	11122	22111	229
 * @author dhshin
 *
 */
public class MonthlyCallenge10_1 {
    public static int solution(int n) {
        int answer = 0;
        List output = new ArrayList();
        String s = "";
        
        while( n != 0) {
            output.add(n %3); // 나머지가 저장됨
            s +=Integer.toString(n %3);
            n  /= 3;   
        }
       answer= Integer.parseInt(s, 3); //3진법 -> 10진법으로 변경 
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int [] asd = {2,1,3,4,1};
//    	solution(125);
    	solution(45);
	}
}
