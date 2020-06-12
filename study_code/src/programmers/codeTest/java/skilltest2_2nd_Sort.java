package programmers.codeTest.java;

import java.util.Arrays;
import java.util.Collections;

/*
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 */
public class skilltest2_2nd_Sort {
    public static String solution(String s) {
        String[] s_arr = s.split("");
        Arrays.sort(s_arr);
        Collections.reverse(Arrays.asList(s_arr));

        return String.join("",s_arr);
    }
    public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}
}
