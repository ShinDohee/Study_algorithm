package programmers.codeTest.java;

public class codetest_124 {
	/**
	 * 
	 * 
	 * 10진법 	124 나라	10진법	124 나라
		1		1		6		14
		2		2		7		21
		3		4		8		22
		4		11		9		24
		5		12		10		41
	 * 효율성 쉣 
	 * @param n
	 * @return
	 */
    public static String solution(int n) {
//        Stri	ng answer = "";
        StringBuilder sb = new StringBuilder();
        int a = 0;
        
        while( n != 0) {
            a = n%3;
            n  /= 3;   
            
            if(a== 0) {
            	n -=1;
            	a =4;
            }
            sb.insert(0, a);
//            answer= a+answer;
//         
        }

       return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(solution(13));
	}
    
}
