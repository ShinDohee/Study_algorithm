package programmers.bagic_training.Level01;

import java.util.stream.IntStream;

public class Solution01_countArr {

    public int[] solution_countOddandEven(int[] num_list) {
        int[] answer = {
                (int) IntStream.range(0, num_list.length)
                .filter(i-> num_list[i]%2==0).count(),
                (int) IntStream.range(0, num_list.length)
                        .filter(i-> num_list[i]%2!=0).count()};

        return answer;
    }
}
