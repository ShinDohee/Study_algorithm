package programmers.bagic_training.Level00;

import java.lang.reflect.Array;
import java.math.BigInteger;
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

    /**
     * x 사이의 개수
     * 문제 설명
     * 문자열 myString이 주어집니다. myString을 문자 "x"를 기준으로 나눴을 때 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
     * @param myString
     * @return
     */
    public static  int[] solution_checkx(String myString) {
        String [] strarrv = myString.replace("x",", ").split(",");
        int[] answer = Arrays.stream(strarrv).mapToInt(x-> x.trim().length()).toArray();
        return answer;
    }

    /**
     * 문자열 잘라서 정렬하기
     * 문제 설명
     * 문자열 myString이 주어집니다. "x"를 기준으로 해당 문자열을 잘라내 배열을 만든 후 사전순으로 정렬한 배열을 return 하는 solution 함수를 완성해 주세요.
     *
     * 단, 빈 문자열은 반환할 배열에 넣지 않습니다.
     * @param myString
     * @return
     */
    public static String[] solution_strSplit(String myString) {
        String [] answer = myString.split("x");
        return Arrays.stream(answer).filter(x -> !x.isEmpty())
                .sorted()
                .toArray(String[]::new) ;
    }

    /**
     * 세 개의 구분자
     * 제출 내역
     * 문제 설명
     * 임의의 문자열이 주어졌을 때 문자 "a", "b", "c"를 구분자로 사용해 문자열을 나누고자 합니다.
     *
     * 예를 들어 주어진 문자열이 "baconlettucetomato"라면 나눠진 문자열 목록은 ["onlettu", "etom", "to"] 가 됩니다.
     *
     * 문자열 myStr이 주어졌을 때 위 예시와 같이 "a", "b", "c"를 사용해 나눠진 문자열을 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
     *
     * 단, 두 구분자 사이에 다른 문자가 없을 경우에는 아무것도 저장하지 않으며, return할 배열이 빈 배열이라면 ["EMPTY"]를 return 합니다.
     * @param myStr
     * @return
     */
    public static  String[] solution_severalSplit(String myStr) {

        String[] answer = Arrays.stream(myStr.split("[abc]")).filter(x-> !x.isEmpty()).toArray(String[]::new);

        return Arrays.stream(answer).count() ==0 ? new String[]{"EMPTY"} : answer;
    }

    public static String solution_(String n_str) {
        int n = Integer.parseInt(n_str);

        return String.valueOf(n);
    }


    public static  String solution_sumAB(String a, String b) {
        BigInteger numA = new BigInteger(a);
        BigInteger numB = new BigInteger(b);

        return String.valueOf(  numA.add(numB));
    }

    /**
     * 꼬리 문자열
     * 제출 내역
     * 문제 설명
     * 문자열들이 담긴 리스트가 주어졌을 때, 모든 문자열들을 순서대로 합친 문자열을 꼬리 문자열이라고 합니다. 꼬리 문자열을 만들 때 특정 문자열을 포함한 문자열은 제외시키려고 합니다. 예를 들어 문자열 리스트 ["abc", "def", "ghi"]가 있고 문자열 "ef"를 포함한 문자열은 제외하고 꼬리 문자열을 만들면 "abcghi"가 됩니다.
     *
     * 문자열 리스트 str_list와 제외하려는 문자열 ex가 주어질 때, str_list에서 ex를 포함한 문자열을 제외하고 만든 꼬리 문자열을 return하도록 solution 함수를 완성해주세요.
     * @param str_list
     * @param ex
     * @return
     */
    public static String solution_mkStr(String[] str_list, String ex) {
        String answer = Arrays.stream(str_list)
                .filter(x -> !x.contains(ex))
                .collect(Collectors.joining());
        return answer;
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
//         String str = "rermgorpsam";
////         int [][] arr = {{2, 3},{0, 7},{5, 9},{6, 10}};
////        solution_stransStr(str, arr);
//
//        solution_strSplit ("dxccxbbbxaaaa");
//        solution_severalSplit("baconlettucetomato");

        solution_sumAB("18446744073709551615", "287346502836570928366");
        solution_("00010");
    }
}
