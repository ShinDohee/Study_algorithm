package programmers.bagic_training.Level00;

import java.util.stream.IntStream;
import java.util.stream.Stream;

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


    public static void main(String[] args) {
        System.out.println(solution(0, 	"wsdawsdassw"));
    }
}
