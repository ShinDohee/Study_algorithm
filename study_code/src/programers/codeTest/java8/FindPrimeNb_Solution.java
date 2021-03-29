package programers.codeTest.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FindPrimeNb_Solution {
    public static int solution(String numbers) {
        String [] array = numbers.split("");
        List<String> list = Arrays.asList(array);

        List<String> combinations = list.stream()
                .reduce(Collections.<String>emptyList(),
                        (sets, item) -> {
                            System.out.println("sets==>"+sets);
                            System.out.println("item ==>"+item);
                            System.out.println( );
                            System.out.println("---------------------");
                            return Stream.of(
                                    sets.stream(),
                                    Stream.of(item),
                                    sets.stream().map(str->{
                                        String value =str + item;
                                        if(value.indexOf("0") ==0) value = value.substring(1);
//                                        System.out.println( value.substring(1));
                                        return value;
                                    } ),
                                    sets.stream().map(str-> {
                                        String value = item+str ;
                                        if(value.indexOf("0") ==0)value = value.substring(1);
//                                        System.out.println(value);
                                        return value;
                                    })

                            ).flatMap(x->x).distinct().collect(Collectors.toList());
                        },
                        (sets, sets2) -> {
                            throw new UnsupportedOperationException(
                                    "Impossible error in sequential streams");
                        }
                );

        combinations.stream().filter(item -> isPrime(item)).forEach(s-> System.out.println("결과물 ::::::::::::::"+s + "  " ));
        return  combinations.stream().filter(item -> isPrime(item)).distinct().collect(Collectors.toList()).size();
    }

    public static boolean isPrime(String number) {
        int num = Integer.parseInt(number);
        if(num == 1) return false;

        return num>1 && LongStream.rangeClosed(2, num / 2).noneMatch(i -> num % i == 0);
    }


    public static void main(String[] args) {
//        solution("17");
        System.out.println(solution("011"));
//        System.out.println(solution("17"));

    }
}
