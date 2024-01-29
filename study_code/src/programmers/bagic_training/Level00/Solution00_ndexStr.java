package programmers.bagic_training.Level00;

public class Solution00_ndexStr {
    public static String solution(String my_string, int n) {
        String answer = "";
        return my_string.substring(0,n);
    }

    /**
     * 특정 문자열로 끝나는 가장 긴 부분 문자열 찾기
     * 문제 설명
     * 문자열 myString과 pat가 주어집니다. myString의 부분 문자열중 pat로 끝나는 가장 긴 부분 문자열을 찾아서 return 하는 solution 함수를 완성해 주세요.
     * @param myString
     * @param pat
     * @return
     */
    public static String solution_findeLongIndex(String myString, String pat) {
        String answer = "";
        int lastIndexStart  =    myString.lastIndexOf(pat);
        int endIndex  =  myString.lastIndexOf(pat) + pat.length();



        return myString.substring(0, endIndex);
    }

    /**
     * 세로 읽기
     * 문제 설명
     * 문자열 my_string과 두 정수 m, c가 주어집니다. my_string을 한 줄에 m 글자씩 가로로 적었을 때 왼쪽부터 세로로 c번째 열에 적힌 글자들을 문자열로 return 하는 solution 함수를 작성해 주세요.
     * --> 블로그 포스팅! 너무 어렵게 생각하지 않긔..
     * @param my_string
     * @param m
     * @param c
     * @return
     */
    public String solution(String my_string, int m, int c) {
        StringBuilder result = new StringBuilder();

        for (int i = c - 1; i < my_string.length(); i += m) {
            result.append(my_string.charAt(i));
        }

        return result.toString();
    }

    /**
     * 문자열이 몇 번 등장하는지 세기
     * 문제 설명
     * 문자열 myString과 pat이 주어집니다. myString에서 pat이 등장하는 횟수를 return 하는 solution 함수를 완성해 주세요.
      * @param myString
     * @param pat
     * @return
     */
    public static int solution_countpat(String myString, String pat) {
        int answer = 0;
        for(int i =0; i< myString.length()-pat.length()+1 ; i++){
            if(myString.substring(i, i+pat.length()).equals(pat)) {
                answer++;
            }
        }
        return answer;
    }

    /**
     *  qr code
     *  문제 설명
     *  두 정수 q, r과 문자열 code가 주어질 때,
     *  code의 각 인덱스를 q로 나누었을 때 나머지가 r인 위치의 문자를 앞에서부터 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요
     * @param q
     * @param r
     * @param code
     * @return
     */
    public String solution(int q, int r, String code) {
        StringBuilder answer = new StringBuilder();

        for(int i =0; i< code.length(); i++){
            if(i%q ==r) answer.append(code.charAt(i));
        }

        return answer.toString();
    }

    /**
     * 원하는 문자열 찾기
     * 문제 설명
     * 알파벳으로 이루어진 문자열 myString과 pat이 주어집니다. myString의 연속된 부분 문자열 중 pat이 존재하면 1을 그렇지 않으면 0을 return 하는 solution 함수를 완성해 주세요.
     *
     * 단, 알파벳 대문자와 소문자는 구분하지 않습니다.
     * @param myString
     * @param pat
     * @return
     */
    public int solution_findStr(String myString, String pat) {
        int answer = 0;
        return myString.toLowerCase().contains(pat.toLowerCase()) ? 1 :0;
    }

    /**
     * 문자 개수 세기
     * 문제 설명
     * 알파벳 대소문자로만 이루어진 문자열 my_string이 주어질 때, my_string에서 'A'의 개수, my_string에서 'B'의 개수,..., my_string에서 'Z'의 개수, my_string에서 'a'의 개수, my_string에서 'b'의 개수,..., my_string에서 'z'의 개수를 순서대로 담은 길이 52의 정수 배열을 return 하는 solution 함수를 작성해 주세요.
     * @param my_string
     * @return
     */
    public int[] solution_countCh(String my_string) {
        int[] answer = new int [52];

        my_string.chars().filter(Character::isLetter).forEach(ch ->{
            if (ch >= 'A' && ch <= 'Z') {
                answer[ch - 'A']++;
            } else if (ch >= 'a' && ch <= 'z') {
                answer[ch - 'a' + 26]++;
            }
        });

        return answer;
    }


    public static void main(String[] args) {
//        System.out.println(solution("ProgrammerS123"	,11));
////        "AbCdEFG"	"dE"	"AbCdE"
//        solution_findeLongIndex("AbCdEFG", "dE");
//        solution_findeLongIndex("AAAAaaaa", "a");

        solution_countpat("banana", "ana");
    }

}
