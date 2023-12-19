package programmers.bagic_training.Level00;

public class Solution00_overWrapStr {

    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        StringBuilder result = new StringBuilder(my_string);
        result.replace(s, s+overwrite_string.length() , overwrite_string);
        return result.toString();
    }

    public static String solution_mixStr (String s1, String s2){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            result.append(s1.charAt(i)).append(s2.charAt(i));
        }

        return result.toString();

    }
    public static void main(String[] args) {

    }
}
