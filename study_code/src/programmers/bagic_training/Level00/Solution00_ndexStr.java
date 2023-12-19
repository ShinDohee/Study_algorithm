package programmers.bagic_training.Level00;

public class Solution00_ndexStr {
    public static String solution(String my_string, int n) {
        String answer = "";
        return my_string.substring(0,n);
    }

    public static void main(String[] args) {
        System.out.println(solution("ProgrammerS123"	,11));
    }
}
