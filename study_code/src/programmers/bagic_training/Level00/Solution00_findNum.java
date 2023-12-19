package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution00_findNum {
    public int solution(int[] num_list, int n) {
        AtomicInteger answer = new AtomicInteger();
        Arrays.stream(num_list).filter(value -> n == value ).forEach(value -> {
            answer.set(1);
        });
        return answer.get();
    }
}
