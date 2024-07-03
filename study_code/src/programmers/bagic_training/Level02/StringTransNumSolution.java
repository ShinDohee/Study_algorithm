package programmers.bagic_training.Level02;

public class StringTransNumSolution {
    public String solution_stringTransInt(int age) {
        String strAge = String.valueOf(age);
        StringBuilder answer = new StringBuilder();
        for (char ch : strAge.toCharArray()){
           answer.append((char) ('a' + ch - '0'));
        }
        return answer.toString();
    }
}
