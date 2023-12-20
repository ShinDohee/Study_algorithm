package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Solution00_findNegativeNum {
    /**
     * 정수 리스트 num_list가 주어질 때, 첫 번째로 나오는 음수의 인덱스를 return하도록 solution 함수를 완성해주세요. 음수가 없다면 -1을 return합니다.
     * @param num_list
     * @return
     */
    public static int solution(int[] num_list) {
        return  IntStream.range(0 , num_list.length).filter(x -> num_list[x] <0).findFirst().orElse(-1);
        /**
         * IntStream  기본형 int에 특화된 연산을 제공하여 성능을 향상시킬 수 있도록 설계되어짐
         * rang() 주어진 범위에서 연속된 int 값을 생성 한 뒤, num_list 에서 음수의 index값 중 처음 index값을 뽑아낸다.
         */
    }

    public static void main(String[] args) {
        int [] num_list ={12, 4, 15, 46, 38, -2, 15};

        solution(num_list);
    }
}



