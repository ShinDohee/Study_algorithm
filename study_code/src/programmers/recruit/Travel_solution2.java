package programmers.recruit;

//import java.lang.management.ManagementFactory;
//import java.lang.management.MemoryMXBean;
//import java.lang.management.MemoryUsage;
import java.util.Arrays;
import java.util.*;
import java.util.stream.IntStream;

public class Travel_solution2
{
//    public static int[] Solution(int[] numbers, int[] start,int[] finish){
//        int[] result = new int[start.length]; // 결과 배열 생성
//
//        for (int i = 0; i < start.length; i++) {
//            int startIndex = start[i];//
//            int endIndex = finish[i]; //
//
//            // 해당 구간의 합 계산
//            int sum = 0;
//            for (int j = startIndex; j <= endIndex; j++) {
//                sum += numbers[j];
//            }
//
//            // 결과 배열에 저장
//            result[i] = sum;
//        }
//
//        return result;
//    }

    public static int[] solution(int[] numbers, int[] start, int[] finish) {
        return IntStream.range(0, start.length)
                .map(i -> IntStream.rangeClosed(start[i], finish[i])
                        .map(j -> numbers[j])
                        .sum())
                .toArray();
    }


    public static void main(String[] args) {
        int[] numbers = {100, 101, 102, 103, 104};
        int[] start = {1, 2};
        int[] finish = {2, 4};

        // solution 메서드 시간 측정
//        long startTime1 = System.currentTimeMillis();
//        int[] result1 = Solution(numbers, start, finish);
//        long endTime1 = System.currentTimeMillis();
//        long duration1 = endTime1 - startTime1;

//        // solution2 메서드 시간 측정
        long startTime2 = System.currentTimeMillis();
        int[] result2 = solution(numbers, start, finish);
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;

        // 결과 출력
//        System.out.println("Solution 1 time: " + duration1 + " milliseconds");
//        System.out.println("Solution 1 result: " + Arrays.toString(result1)); //4194304


        System.out.println("Solution 2 time: " + duration2 + " milliseconds");
        System.out.println("Solution 2 result: " + Arrays.toString(result2));

//        // 메모리 사용량 출력
//        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
//        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
//        System.out.println("Heap Memory Used: " + heapMemoryUsage.getUsed() + " bytes");
    }
}
