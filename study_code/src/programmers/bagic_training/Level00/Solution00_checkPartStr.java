package programmers.bagic_training.Level00;

public class Solution00_checkPartStr {
     public static int solution(String my_string, String target) {
        int answer = 0;
//        System.out.println(my_string.contains(target));
        return my_string.contains(target) == true ? 1:0;
    }
    public static void main(String[] args) {
        System.out.println("sdfsd  sdfs f   ===>>>   "+solution("banana","ana"));
    }
}
