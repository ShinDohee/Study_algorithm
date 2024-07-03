package programmers.bagic_training.Level02;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvergencySolution {
    public static int[] solution(int[] emergency) {

        List<Integer> rankList = IntStream.range(0,emergency.length)
                .boxed()
                .sorted((i, j) -> Integer.compare(emergency[j], emergency[i]))
                .collect(Collectors.toList());

        int [] answer =new int[emergency.length];
        for (int rank = 0; rank < rankList.size(); rank++) {
            answer[rankList.get(rank)] = rank + 1;
        }

        return answer;


    }

    public static void main(String[] args) {
        int[] emergency ={3, 76, 24};
        solution(emergency);
    }
}
