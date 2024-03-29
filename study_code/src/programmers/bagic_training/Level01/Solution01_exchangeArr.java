package programmers.bagic_training.Level01;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution01_exchangeArr {
    public static int[] solution_mkdoublevalue(int[] numbers) {
        int[] answer =  Arrays.stream(numbers)
                .map(x-> x = 2*x)
                .toArray();

        return answer;
    }

    /**
     * 중앙값 구하기
     * 제출 내역
     * 문제 설명
     * 중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다. 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다. 정수 배열 array가 매개변수로 주어질 때, 중앙값을 return 하도록 solution 함수를 완성해보세요.
     * @param array
     * @return
     */
    public int solution_findmiddleNum(int[] array) {
        Arrays.sort(array);
        int index = array.length/2;
        return array[index];
    }


    /**
     * 최빈값 구하기
     * 제출 내역
     * 문제 설명
     * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
     * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return
     * 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다
     * @param array
     * @return
     */
    public static int solution_findNumers(int[] array) {
        Map<Integer, Long> map =
                Arrays.stream(array)
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //최빈도 찾기
        Map.Entry<Integer, Long> entry = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (entry !=null) {
            long num= entry.getValue();

            boolean isOnlyone = map.values()
                    .stream()
                    .filter(freq -> freq == num)
                    .count() > 1;

            if (!isOnlyone) {
                return entry.getKey(); // 최빈값 반환
            }
        }
        return -1;
    }

    public static int solution(int[] array) {
        List<Map.Entry<Integer, List<Integer>>> list =
                new ArrayList<>(Arrays.stream(array)
                                .boxed()
                                .collect(Collectors.groupingBy(o -> o))
                                .entrySet())
                        .stream()
                        .sorted((t0, t1) ->
                                Integer.compare(t1.getValue().size(), t0.getValue().size()))
                        .collect(Collectors.toList());
        return list.size() > 1 && list.get(0).getValue().size() - list.get(1).getValue().size() == 0 ? -1 : list.get(0).getKey();
    }


    public int[] solution_reverseArray(int[] num_list) {
        int [] result = IntStream.range(0, num_list.length)
                .map(i -> num_list[num_list.length - 1 - i])
                .toArray();
        return  result;
    }

    /**
     *
     * @param n
     * @return
     */

    public int[] solution_mkOddArr(int n) {
        int[] answer = IntStream.range(0,n)
                .filter( i -> i%2!=0)
                .toArray();
        return answer;
    }

    public static void main(String[] args) {

        int [] arr = {1,1,2,2,2,3,3,4};
        int []arr2 ={1,1,2,2};
//        solution_findNumers(arr);
        solution(arr2);

    }
}
