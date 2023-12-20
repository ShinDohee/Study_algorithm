package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution00_mixNumSum {
    public static int solution(int[] num_list) {
        int answer = 0;
        String evenNum =Arrays.stream(num_list).filter(x -> x%2 ==0).mapToObj(String::valueOf).collect(Collectors.joining());
        String oddNum =Arrays.stream(num_list).filter(x -> x%2 ==1).mapToObj(String::valueOf).collect(Collectors.joining());

        return  Integer.parseInt(evenNum) + Integer.parseInt(oddNum);
    }



    public static void main(String[] args) {
        int [] num = {3, 4, 5, 2, 1}    ;
       System.out.println( solution(num));
    }
}
