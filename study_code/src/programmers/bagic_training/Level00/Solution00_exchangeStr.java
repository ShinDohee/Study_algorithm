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
     * 문자열 여러 번 뒤집기
     * 문제 설명
     * 문자열 my_string과 이차원 정수 배열 queries가 매개변수로 주어집니다.
     * queries의 원소는 [s, e] 형태로, my_string의 인덱스 s부터 인덱스 e까지를 뒤집으라는 의미입니다.
     * my_string에 queries의 명령을 순서대로 처리한 후의 문자열을 return 하는 solution 함수를 작성해 주세요.
     *
     * "rermgorpsam"	[[2, 3], [0, 7], [5, 9], [6, 10]]	"programmers"
     *
     *
     * @param my_string
     * @param queries
     * @return
     */
    public static String solution_stransStr(String my_string, int[][] queries) {
        String answer = my_string;
        int i = 1;
        for (int [] query: queries) {
            answer = reverseSubstring(answer, query[0], query[1]);

            System.out.println(i++ +"번째 교환 : "+answer);
        }

        return answer;
    }

    /**
     * 문자열 뒤집기
     * 문제 설명
     * 문자열 my_string과 정수 s, e가 매개변수로 주어질 때, my_string에서 인덱스 s부터 인덱스 e까지를 뒤집은 문자열을 return 하는 solution 함수를 작성해 주세요.
     * @param my_string
     * @param s
     * @param e
     * @return
     */
    public String solution(String my_string, int s, int e) {
        String answer =  answer = reverseSubstring(my_string, s, e);
        return answer;
    }

    /**
     * 해당 범위의 str 뒤집는 메소드
     * @param str
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static String reverseSubstring(String str, int startIndex, int endIndex) {
        char[] charArray = str.toCharArray();
        while (startIndex < endIndex) {
            char temp = charArray[startIndex];
            charArray[startIndex] = charArray[endIndex];
            charArray[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
        return new String(charArray);
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

//        String myString = "cvsgiorszzzmrpaqpe";
//        int[] indexList = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
//        System.out.println(solution_makeString(myString, indexList));
         String str = "rermgorpsam";
         int [][] arr = {{2, 3},{0, 7},{5, 9},{6, 10}};
        solution_stransStr(str, arr);

    }
}
