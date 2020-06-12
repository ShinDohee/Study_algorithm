package programmers.codeTest.java;

import before.Solution;

/*
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 
 * 그다음 최소공배수를 넣어 반환하면 됩니다. 
 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 */
public class skilltest1_1st_LCM_GCD {

    public static int[] solution(int n, int m) {
        int[] answer = {0,0};
        int minNum = Math.min(n, m);
        int maxNum = Math.max(n, m);

        
        for (int i = 1; i < minNum+1; i++) {
			if(n%i == 0 && m%i == 0) {
				if(answer[0] < i) {
					answer[0]=i;
				}
			}
		}
        answer[1] = minNum*maxNum/answer[0];
        
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(3,12)[0]+"___"+solution(3,12)[1]);
	}
}
