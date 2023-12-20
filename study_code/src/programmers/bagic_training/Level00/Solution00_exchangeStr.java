package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution00_exchangeStr {
    public String solution(String rny_string) {
        String answer = "";
        return rny_string.replace("m", "rn");
    }

    /**
     * 글자 이어 붙여 문자열 만들기
     * 문자열 my_string과 정수 배열 index_list가 매개변수로 주어집니다.
     * my_string의 index_list의 원소들에 해당하는 인덱스의 글자들을 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
     * @param my_string
     * @param index_list
     * @return
     */
    public static String solution_makeString(String my_string, int[] index_list) {
        String answer = "";
//        for(int i =0; i <index_list.length; i++){
//            answer += my_string.charAt(index_list[i]);
//        }
//        IntStream.of(index_list)
//                .mapToObj(my_string::charAt)
//                .map(String::valueOf)
//                .collect(Collectors.joining());

        return  IntStream.of(index_list)
                .mapToObj(my_string::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**
     * 문자 리스트를 문자열로 변환하기
     * 문자들이 담겨있는 배열 arr가 주어집니다. arr의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.
     * @param arr
     * @return
     */
    public String solution_transFromListToStr(String[] arr) {
        String answer = "";



        return   Arrays.stream(arr).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        /**
         *         int n = 10 ;
         *         String answer = String.valueOf(n);
         *         System.out.println(answer);
         *          https://school.programmers.co.kr/learn/courses/30/lessons/181845 (문자열로 변환 )
         */

        String myString = "cvsgiorszzzmrpaqpe";
        int[] indexList = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
        System.out.println(solution_makeString(myString, indexList));

    }
}
