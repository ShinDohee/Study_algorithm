package programmers.bagic_training.Level00;

import java.util.Arrays;

public class Solution00_mkStr {

    /**
     *  문자열에 따라 다음과 같이 두 수의 크기를 비교하려고 합니다.
     *
     *     두 수가 n과 m이라면
     *     ">", "=" : n >= m
     *     "<", "=" : n <= m
     *     ">", "!" : n > m
     *     "<", "!" : n < m
     *
     *     두 문자열 ineq와 eq가 주어집니다.
     *     ineq는 "<"와 ">"중 하나고,
     *     eq는 "="와 "!"중 하나입니다.
     *     그리고 두 정수 n과 m이 주어질 때,
     *     n과 m이 ineq와 eq의 조건에 맞으면 1을 아니면 0을 return하도록 solution 함수를 완성해주세요.
     *
     *     첫 시도 : 66점ㅌ
     * @param ineq
     * @param eq
     * @param n
     * @param m
     * @return
     */
    public static int solution(String ineq, String eq, int n, int m) {
        if (ineq.equals(">") && eq.equals("=")) {
            return n  >= m ? 1 : 0;
        } else if (ineq.equals(">") && eq.equals("!")) {
            return n > m ? 1 : 0;
        } else if (ineq.equals("<") && eq.equals("=")) {
            return n <= m ? 1 : 0;
        } else if (ineq.equals("<") && eq.equals("!")) {
            return n < m ? 1 : 0;
        }else {
            // 예외 처리: ineq와 eq가 주어진 조건을 만족하지 않는 경우
            return -1;
        }
    }

    /**
     * 부분 문자열 이어 붙여 문자열 만들기
     * 문제 설명
     * 길이가 같은 문자열 배열 my_strings와 이차원 정수 배열 parts가 매개변수로 주어집니다.
     * parts[i]는 [s, e] 형태로,
     * my_string[i]의 인덱스 s부터 인덱스 e까지의 부분 문자열을 의미합니다.
     * 각 my_strings의 원소의 parts에 해당하는 부분 문자열을 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
     *
     *                              my_strings                          	parts	                    result
     * ["progressive", "hamburger", "hammer", "ahocorasick"]	[[0, 4], [1, 2], [3, 5], [7, 7]]	"programmers"
     *
     * @param my_strings
     * @param parts
     * @return
     */
    public String solution_mkStr(String[] my_strings, int[][] parts) {
        String answer = "";
        for (int i =0; i < my_strings.length; i++){
            answer += my_strings[i].substring(parts[i][0] , parts[i][0] +parts[i][1]);
        }
        return answer;
    }

    /**
     * 접미사 배열
     * 문제 설명
     * 어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다. 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
     * 문자열 my_string이 매개변수로 주어질 때, my_string의 모든 접미사를 사전순으로 정렬한 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
     * @param my_string
     * @return
     */
    public static String[] solution_mkStrArray(String my_string) {
        String[] answer =new String [my_string.length()];
        for(int i =0; i < my_string.length() ; i++ ){
           answer[i]= my_string.substring(i,  my_string.length());
        }

        return Arrays.stream(answer).sorted().toArray(String[]::new);
    }

    public static String[] solution(String my_string) {
        String[] answer = my_string.split(" ");

        return Arrays.stream(answer).filter(word -> !word.isEmpty())
                .toArray(String[]::new);
    }

    /**
     * 접미사인지 확인하기
     * 문제 설명
     * 어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다. 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
     * 문자열 my_string과 is_suffix가 주어질 때, is_suffix가 my_string의 접미사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.
     * @param my_string
     * @param is_suffix
     * @return
     */
    public int solution_checkSuffixs(String my_string, String is_suffix) {
        String[] result =new String [my_string.length()];
        for(int i =0; i < my_string.length() ; i++ ){
            result[i]= my_string.substring(i,  my_string.length());
        }

        return Arrays.stream(result).filter(x -> x.equals(is_suffix)).count() >0 ?1 : 0;
    }

    /**
     * 접두사인지 확인하기
     * 문제 설명
     * 어떤 문자열에 대해서 접두사는 특정 인덱스까지의 문자열을 의미합니다. 예를 들어, "banana"의 모든 접두사는 "b", "ba", "ban", "bana", "banan", "banana"입니다.
     * 문자열 my_string과 is_prefix가 주어질 때, is_prefix가 my_string의 접두사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.
     *
     * contain 은 "banana", "nan" 이걸 못 걸러냄
     *         return my_string.startsWith(is_prefix)  ? 1 :0;
     * @param my_string
     * @param is_prefix
     * @return
     */
    public int solution_checkPrefix(String my_string, String is_prefix) {
        int answer = 0;
        return my_string.startsWith(is_prefix)  ? 1 :0;
    }

    /**
     * 글자 지우기
     * 문제 설명
     * 문자열 my_string과 정수 배열 indices가 주어질 때, my_string에서 indices의 원소에 해당하는 인덱스의 글자를 지우고 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
     * "apporoograpemmemprs"	[1, 16, 6, 15, 0, 10, 11, 3]	"programmers"
     * @param my_string
     * @param indices
     * @return
     * @TODO: 08일날 다시하기
     */
    public static String solution_removeChar(String my_string, int[] indices) {
        StringBuilder answer = new StringBuilder();

        for(int i =0; i< my_string.length(); i++){
            int index = i;
            if( Arrays.stream(indices).anyMatch(number -> number == index) ) continue;

            answer.append(my_string.charAt(i));
        }



        return answer.toString();
    }
    public static void main(String[] args) {
//        solution_mkStrArray("parogramers");
        int [] indices = {1, 16, 6, 15, 0, 10, 11, 3};
        String str = "apporoograpemmemprs";
        solution_removeChar (str, indices);

    }

}
