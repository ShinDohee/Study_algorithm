package programmers.bagic_training.Level00;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution00_diceMkNumObj {
    // 숫자와 카운트 정보를 저장하는 클래스

    public static int solution_diceGame3(int a, int b, int c, int d) {
        int [] dice = {a,b,c,d};
        Set<Integer> nonDuplicates = Arrays.stream(dice)
                .boxed()  // Convert int to Integer
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)  // Filter out duplicates
                .mapToInt(Map.Entry::getKey)
                .boxed()
                .collect(Collectors.toSet());

        int [] arr2 = nonDuplicates.stream().mapToInt(Integer::intValue).toArray(); // 중복된 수가 아예 포함이 안된 arr
        int [] duparr = Arrays.stream(dice).distinct().sorted().toArray(); //중복만 제거

        if(duparr.length==4){  // 각 수가 다를 때
            return duparr[0];
        }else if (duparr.length==3){ // 2개 같고, 나머지 다를때,
            return arr2[0] * arr2[1];
        }else if ( duparr.length == 2){ //3개가 같을때 or 2개가 2개씩 같을때
            if(arr2.length ==1 ){ //3개가 같을때  -->세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
                int q = duparr[0] == arr2 [0] ? duparr[0] : duparr[1];
                int p = duparr[0] == q  ? duparr[1] : duparr[0];

                return (int) Math.pow((10*p+q),2);
            }else { //2개가 2개 씩 같을 때
               return  (duparr[0] + duparr[1]) * (Math.abs(duparr[0]- duparr[1]));
            }

        }else if ( duparr.length ==1){ // 4개 같을 때.
            return 1111* a;
        }

        return 0;
    }

    public static void main(String[] args) {
        solution_diceGame3(		4, 1, 4, 4);
//        2,	2,	2,	2	2222
//4,	1,	4,	4	1681
//6	,3,	3,	6	27
//2	,5,	2,	6	30
//6,	4,	2,	5	2
    System.out.println( solution_diceGame3(		2,	2,	2,	2));
    System.out.println( solution_diceGame3(		4, 1, 4, 4));
    System.out.println( solution_diceGame3(		6	,3,	3,	6));
    System.out.println( solution_diceGame3(		2	,5,	2,	6));
    System.out.println( solution_diceGame3(		6,	4,	2,	5));
    }
}
