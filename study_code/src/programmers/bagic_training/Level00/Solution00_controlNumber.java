package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Solution00_controlNumber {
    /**
     * 수조작 하기 1
     * 정수 n과 문자열 control이 주어집니다. control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며, control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.
     *
     * "w" : n이 1 커집니다.
     * "s" : n이 1 작아집니다.
     * "d" : n이 10 커집니다.
     * "a" : n이 10 작아집니다.
     * 위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return 하는 solution 함수를 완성해 주세요.
     * * https://school.programmers.co.kr/learn/courses/30/lessons/181926
     * @param n
     * @param control
     * @return
     */
    public static int solution(int n, String control) {
        int answer = 0;
        int w_count =(int)control.chars().filter(x -> x =='w').count();
        int s_count =(int)control.chars().filter(x -> x =='s').count();
        int d_count=(int)control.chars().filter(x -> x =='d').count();
        int a_count =(int)control.chars().filter(x -> x =='a').count();

        answer = n+ w_count -s_count +(10*d_count) -(10*a_count);

        return answer;
    }

    /**
     * 수 조작하기 2
     * 문제 설명
     * 정수 배열 numLog가 주어집니다. 처음에 numLog[0]에서 부터 시작해 "w", "a", "s", "d"로 이루어진 문자열을 입력으로 받아 순서대로 다음과 같은 조작을 했다고 합시다.
     *
     * "w" : 수에 1을 더한다.
     * "s" : 수에 1을 뺀다.
     * "d" : 수에 10을 더한다.
     * "a" : 수에 10을 뺀다.
     * 그리고 매번 조작을 할 때마다 결괏값을 기록한 정수 배열이 numLog입니다. 즉, numLog[i]는 numLog[0]로부터 총 i번의 조작을 가한 결과가 저장되어 있습니다.
     *
     * 주어진 정수 배열 numLog에 대해 조작을 위해 입력받은 문자열을 return 하는 solution 함수를 완성해 주세요.
     * [0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1]	"wsdawsdassw"
     *
     *        StringBuffer sb = new StringBuffer();
     *         for(int i = 1; i < numLog.length; i++){
     *             if(numLog[i-1] + 1 == numLog[i]){ sb.append("w"); }
     *             else if(numLog[i-1] - 1 == numLog[i]){ sb.append("s"); }
     *             else if(numLog[i-1] + 10 == numLog[i]){ sb.append("d"); }
     *             else if(numLog[i-1] - 10 == numLog[i]){ sb.append("a"); }
     *         }
     *         return sb.toString();
     *
     *
     *         StringBuffer를 이용한 것이 훠얼씬 빠르다~~
     * @param numLog
     * @return
     */
    public String solution(int[] numLog) {
        String answer ="";
        for (int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1];

            if (diff == 1) {
                answer +="w";
            } else if (diff == -1) {
                answer +="s";
            } else if (diff == 10) {
                answer +="d";
            } else if (diff == -10) {
                answer +="a";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(0, 	"wsdawsdassw"));
    }
}
