package programmers.bagic_training.Level00;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.OptionalInt;
    import java.util.ArrayList;
    import java.util.List;

public class Solution00_exchangeArray {

    /**
     * 정수 배열 arr가 주어집니다. arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고, 50보다 작은 홀수라면 2를 곱합니다. 그 결과인 정수 배열을 return 하는 solution 함수를 완성해 주세요.
     *
     * 제한사항
     * 1 ≤ arr의 길이 ≤ 1,000,000
     * 1 ≤ arr의 원소의 값 ≤ 100
     * 입출력 예
     * arr	result
     * [1, 2, 3, 100, 99, 98]	[2, 2, 6, 50, 99, 49]
     * @param arr
     * @return
     */
    public static int[] solution(int[] arr) {
        return   Arrays.stream(arr)
                .map( num ->{
                    if(num >49 && num%2 ==0){
                        return num/2;
                    }else if(num <50  && num%2 ==1){
                        return num*2;
                    }else{
                        return num;
                    }
                        }

                ).toArray();

    }

    /**
     * n 번째 원소까지
     * 정수 리스트 num_list와 정수 n이 주어질 때, num_list의 첫 번째 원소부터 n 번째 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     * https://school.programmers.co.kr/learn/courses/30/lessons/181889
     * @param num_list
     * @param n
     * @return
     */
    public int[] solution_copyofArray(int[] num_list, int n) {
        int[] answer = Arrays.copyOfRange(num_list, 0, n);
        return answer;
    }

    /**
     * 원소들의 곱과 합
     * 문제 설명
     * 정수가 담긴 리스트 num_list가 주어질 때,
     * 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.
     * @param num_list
     * @return
     */
    public int solution_diffSumOrMulti(int[] num_list) {
;
        int answer = Arrays.stream(num_list).sum()* Arrays.stream(num_list).sum() >Arrays.stream(num_list).reduce(1, (a, b) -> a * b)? 1:0;
        return answer;
    }

    /**
     *카운트 업
     문제 설명
     정수 start_num와 end_num가 주어질 때,
     start_num부터 end_num까지의 숫자를 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     *
     */
    public int[] solution_makeArray(int start_num, int end_num) {
        int[] answer = IntStream.rangeClosed(start_num, end_num +1).toArray();

        return answer;
    }


    /**
     * 조건에 맞게 수열 변환하기 3
     *  정수 배열 arr와 자연수 k가 주어집니다.
     *
     * 만약 k가 홀수라면 arr의 모든 원소에 k를 곱하고, k가 짝수라면 arr의 모든 원소에 k를 더합니다.
     *
     * 이러한 변환을 마친 후의 arr를 return 하는 solution 함수를 완성해 주세요.
     * @param arr
     * @param k
     * @return
     */
    public int[] solution_optionArray(int[] arr, int k) {
        int[] answer = {};
        if(k%2 ==0 ){
            //모든원소에 k 더하고
            answer=  Arrays.stream(arr).map(x->x+k).toArray();
        }else {
            // 모든 원소에 k 곱하고
            answer=  Arrays.stream(arr).map(x->x*k).toArray();
        }

        return answer;
    }

    /**
     * 카운트 다운
     * 문제 설명
     * 정수 start_num와 end_num가 주어질 때, start_num에서 end_num까지 1씩 감소하는 수들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     * @param start
     * @param end_num
     * @return
     */
    public int[] solution_countDownArray(int start, int end_num) {
        int[] answer = IntStream.range(end_num, start)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }

    /**
     * 배열 만들기 1
     * 정수 n과 k가 주어졌을 때, 1 이상 n이하의 정수 중에서 k의 배수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
     * @param n
     * @param k
     * @return
     */
    public int[] solution(int n, int k) {
        int[] answer = IntStream.range(0, n)
                .filter(x -> x%k ==0).toArray();
        return answer;
    }

    /**
     * 배열 만들기 2
     * 문제 설명
     * 정수 l과 r이 주어졌을 때, l 이상 r이하의 정수 중에서 숫자 "0"과 "5"로만 이루어진 모든 정수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
     *
     * 만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.
     * @param l
     * @param r
     * @return
     */
    public int[] solution_mkArray2(int l, int r) {
        int[] answer =  IntStream.range(l,r)
                .filter(x -> String.valueOf(x).chars().allMatch(c -> c == '5' || c == '0'))
                .toArray();
        return answer.length == 0 ? new int[]{-1} : answer;

    }

    /**
     * 배열 만들기 3
     * 문제 설명
     * 정수 배열 arr와 2개의 구간이 담긴 배열 intervals가 주어집니다.
     *
     * intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 각 구간은 닫힌 구간입니다. 닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미합니다.
     *
     * 이때 배열 arr의 첫 번째 구간에 해당하는 배열과 두 번째 구간에 해당하는 배열을 앞뒤로 붙여 새로운 배열을 만들어 return 하는 solution 함수를 완성해 주세요.
     * @param arr
     * @param intervals
     * @return
     */
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = {};
        int [] partOfArr ={};
        ArrayList<Integer> result_Arr = new ArrayList<>();
        for(int i=0; i <intervals.length; i++){
            partOfArr = Arrays.copyOfRange(arr,intervals[i][0], intervals[i][1]+1);
            result_Arr.addAll(Arrays.asList(Arrays.stream(partOfArr).boxed().toArray(Integer[]::new)));
        }

        answer = result_Arr.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    /**
     * 배열 만들기 4
     * 문제 설명
     * 정수 배열 arr가 주어집니다. arr를 이용해 새로운 배열 stk를 만드려고 합니다.
     *
     * 변수 i를 만들어 초기값을 0으로 설정한 후 i가 arr의 길이보다 작으면 다음 작업을 반복합니다.
     *
     * 만약 stk가 빈 배열이라면 arr[i]를 stk에 추가하고 i에 1을 더합니다.
     * stk에 원소가 있고, stk의 마지막 원소가 arr[i]보다 작으면 arr[i]를 stk의 뒤에 추가하고 i에 1을 더합니다.
     * stk에 원소가 있는데 stk의 마지막 원소가 arr[i]보다 크거나 같으면 stk의 마지막 원소를 stk에서 제거합니다.
     * 위 작업을 마친 후 만들어진 stk를 return 하는 solution 함수를 완성해 주세요.
     * @param arr
     * @return
     */
    public static int[] solution_mkArray4(int[] arr) {
        ArrayList<Integer> result_Arr = new ArrayList<>();
        int i =0;
        while(i<arr.length){
            if(result_Arr.isEmpty()){
                result_Arr.add(arr[i]);
                i++;
            }else{
                if(result_Arr.get(result_Arr.size()-1) < arr[i]){
                    result_Arr.add(arr[i]);
                    i++;
                }else {
                    result_Arr.remove(result_Arr.size()-1);
                }
            }
        }
        return result_Arr.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     *    배열 만들기 5
     *    문제 설명
     * 문자열 배열 intStrs와 정수 k, s, l가 주어집니다. intStrs의 원소는 숫자로 이루어져 있습니다.
     *
     * 배열 intStrs의 각 원소마다 s번 인덱스에서 시작하는 길이 l짜리 부분 문자열을 잘라내 정수로 변환합니다.
     * 이때 변환한 정수값이 k보다 큰 값들을 담은 배열을 return 하는 solution 함수를 완성해 주세요.
     *
     *
     * intStrs	                                        k	s	l	result
     * [	[56789, 99999]
     */
    public static int[] solution_mkArray5(String[] intStrs, int k, int s, int l) {

        Arrays.stream(intStrs)
                .forEach( x -> {
                    System.out.println(Integer.parseInt(x.substring(s,s+l)));
                    System.out.println(Integer.parseInt(x.substring(s,s+l)) > k );
                });

        int[] answer =
                Arrays.stream(intStrs)
                        .filter( x -> Integer.parseInt(x.substring(s,s+l)) >k  )
                        .mapToInt( x -> Integer.parseInt(x.substring(s,s+l))).toArray()
                        ;


        return answer;
    }

    /**
     * 배열의 길이에 따라 다른 연산하기
     * 정수 배열 arr과 정수 n이 매개변수로 주어집니다.
     * arr의 길이가 홀수라면 arr의 모든 짝수 인덱스 위치에 n을 더한 배열을,
     * arr의 길이가 짝수라면 arr의 모든 홀수 인덱스 위치에 n을 더한 배열을 return 하는 solution 함수
     * @param arr
     * @param n
     * @return
     */
    public int[] solution(int[] arr, int n) {
        if(arr.length %2 ==1) {
            IntStream.range(0, arr.length)
                    .filter(i -> i%2==0)
                    .forEach( index -> arr[index]=arr[index]+n);
        }else {
            IntStream.range(0, arr.length)
                    .filter(i -> i%2==1)
                    .forEach( index -> arr[index]=arr[index]+n);
        }
        return arr;
    }

    /**
     * 마지막 두 원소
     * 문제 설명
     * 정수 리스트 num_list가 주어질 때,
     * 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을
     * 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을
     * 추가하여 return하도록 solution 함수를 완성해주세요.
     * @param num_list
     * @return
     */
    public static int[] solution_lastIndex(int[] num_list) {
        int[] answer = Arrays.copyOf(num_list, num_list.length+1 );
        if(num_list[num_list.length-1] >num_list[num_list.length-2]){
            answer[answer.length-1] =  num_list[num_list.length-1] - num_list[num_list.length-2];
        }else {
            answer[answer.length-1] =  num_list[num_list.length-1] *2;
        }
        return answer;
    }

    /**
     * 수열과 구간 쿼리 4
     * 문제 설명
     * 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
     *
     * 각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 i가 k의 배수이면 arr[i]에 1을 더합니다.
     *
     * 위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
     *
     * 제한사항
     * 1 ≤ arr의 길이 ≤ 1,000
     * 0 ≤ arr의 원소 ≤ 1,000,000
     * 1 ≤ queries의 길이 ≤ 1,000
     * 0 ≤ s ≤ e < arr의 길이
     * 0 ≤ k ≤ 5
     * 입출력 예
     * arr	                queries	                    result
     * [0, 1, 2, 4, 3]	[[0, 4, 1],[0, 3, 2],[0, 3, 3]]	[3, 2, 4, 6, 4]
     * @param arr
     * @param queries
     * @return
     */
    public static int[] solution_sequence4(int[] arr, int[][] queries) {
        int[] answer = {};
        for (int[] query : queries) {
            int start = query[0] ;  // 1-based index를 0-based index로 변환
            int end = query[1] ;
            int k = query[2];

            IntStream.rangeClosed(start, end)
                    .filter(i -> i % k == 0)
                    .forEach(i -> arr[i]++);
        }

        return arr;
//        return answer;
    }

    /**
     * 수열과 구간 쿼리 3
     * 문제 설명
     * 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다.
     * queries의 원소는 각각 하나의 query를 나타내며, [i, j] 꼴입니다.
     *
     * 각 query마다 순서대로 arr[i]의 값과 arr[j]의 값을 서로 바꿉니다.
     *
     * 위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
     *
     * @param arr
     * @param queries
     * @return
     */
    public int[] solution_sequence3(int[] arr, int[][] queries) {
        Arrays.stream(queries)
                .forEach(query -> {
                    // query[0]과 query[1] 위치의 값 서로 바꾸기
                    int temp = arr[query[0]];
                    arr[query[0]] = arr[query[1]];
                    arr[query[1]] = temp;
                });
        return arr;



    }



    /**
     * 수열과 구간 쿼리 2
     * 문제 설명
     * 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
     *
     * 각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 k보다 크면서 가장 작은 arr[i]를 찾습니다.
     *
     * 각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
     * 단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.
     *
     * [0, 1, 2, 4, 3]	[[0, 4, 2],[0, 3, 2],[0, 2, 2]]	[3, 4, -1]
     *
     * 속도가 느리다!
     * 좀더 빠른걸로 알아보쟈~
     * @param arr
     * @param queries
     * @return
     */
    public  static int [] solution_sequence2(int[] arr , int[][]queries){
        int[] answer = new int [queries.length];
        int [] subArr = {};
        int[] filteredArray ={};

        for(int i =0 ; i < queries.length; i++ ){
            int[] query = queries[i];
            subArr = Arrays.copyOfRange(arr, query[0], query[1]+1 );

            filteredArray =  Arrays.stream(subArr)
                    .filter(value -> value > query[2])
                    .sorted()
                    .toArray();

            if (filteredArray.length == 0) {
                answer[i]= -1;
            }else {
                answer[i]= filteredArray[0];
            }

            // 정렬된 배열에서 가장 작은 값을 반환

        }

        return answer;
    }

    /**
     * 리스트 자르기
     * 문제 설명
     * 정수 n과 정수 3개가 담긴 리스트 slicer 그리고 정수 여러 개가 담긴 리스트 num_list가 주어집니다. slicer에 담긴 정수를 차례대로 a, b, c라고 할 때, n에 따라 다음과 같이 num_list를 슬라이싱 하려고 합니다.
     *
     * n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지
     * n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
     * n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
     * n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
     * 올바르게 슬라이싱한 리스트를 return하도록 solution 함수를 완성해주세요.
     * @param n
     * @param slicer
     * @param num_list
     * @return
     * TODO : 블로그
     */
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};

        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        if(n==1) { //0번 인덱스부터 b번 인덱스까지
            answer = Arrays.copyOfRange(num_list, 0, b+1);
        }else if (n==2) { // num_list의 a번 인덱스부터 마지막 인덱스까지
            answer = Arrays.copyOfRange(num_list, a , num_list.length +1);
        }else if (n==3){ //num_list의 a번 인덱스부터 b번 인덱스까지
            answer = Arrays.copyOfRange(num_list, a , b+1);
        }else if (n==4){ // num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
            answer = IntStream.range(0, (b - a) / c + 1)
                    .map(i -> num_list[a + i * c])
                    .toArray();
        }

        return answer;
    }

    /**
     * 2의 영역
     * 문제 설명
     * 정수 배열 arr가 주어집니다. 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 solution 함수를 완성해 주세요.
     *
     * 단, arr에 2가 없는 경우 [-1]을 return 합니다.
     * @param arr
     * @return
     */
    public static int[] solution_find2(int[] arr) {
        int[] answer = {};
        int count2 = (int) Arrays.stream(arr).filter(x -> x==2).count();

        if(count2 == 0) return new int[]{-1};

        // 첫 번째 2의 인덱스 찾기
        int firstIndex = findFirstIndex(arr, 2);

        // 마지막 2의 인덱스 찾기
        int lastIndex = findLastIndex(arr, 2);
        // 첫 번째 2의 인덱스 찾기

        return Arrays.copyOfRange(arr, firstIndex, lastIndex+1);
    }
    private static int findFirstIndex(int[] array, int targetValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == targetValue) {
                return i;
            }
        }
        return -1; // 찾고자 하는 값이 배열에 없는 경우
    }

    private static int findLastIndex(int[] array, int targetValue) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == targetValue) {
                return i;
            }
        }
        return -1; // 찾고자 하는 값이 배열에 없는 경우
    }

    /**
     * 왼쪽 오른쪽
     * 문제 설명
     * 문자열 리스트 str_list에는
     * "u", "d", "l", "r" 네 개의 문자열이 여러 개 저장되어 있습니다.
     * str_list에서 "l"과 "r" 중 먼저 나오는 문자열이 "l"이라면 해당 문자열을 기준으로 왼쪽에 있는 문자열들을 순서대로 담은 리스트를,
     * 먼저 나오는 문자열이 "r"이라면 해당 문자열을 기준으로 오른쪽에 있는 문자열들을 순서대로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     * "l"이나 "r"이 없다면 빈 리스트를 return합니다.
     * @param str_list
     * @return
     * Tod0 : 블로그 왼쪽 오른쪽 ... 왜 90점이냐 .. --? 조건이 안맞앗음
     */
    public  static String[] solution_leftRight(String[] str_list) {
        String[] answer = {};

        int l_index = IntStream.range(0, str_list.length)
                .filter(i -> str_list[i].equals("l"))
                .findFirst()
                .orElse(-1);

        int r_index = IntStream.range(0, str_list.length)
                .filter(i -> str_list[i].equals("r"))
                .findFirst()
                .orElse(-1);

//        if(l_index == -1  || r_index == -1) {
//            return new String[]{};
//        }else if ( l_index < r_index ){
//            answer = Arrays.copyOfRange(str_list, 0, l_index);
//        }else if ( r_index < l_index ) {
//            answer = Arrays.copyOfRange(str_list, r_index, str_list.length);
//        }


        if(l_index != -1 && (r_index == -1 || l_index < r_index)) {
            answer = Arrays.copyOfRange(str_list, 0, l_index);
        }else if (r_index != -1 && (l_index == -1 || l_index > r_index) ) {
            answer = Arrays.copyOfRange(str_list, r_index+1, str_list.length);
        }

        return answer;
    }
    public  static String[] solution_leftRight2(String[] str_list) {
        List<String> resultList = new ArrayList<>();


        int lIndex = Arrays.asList(str_list).indexOf("l");
        int rIndex = Arrays.asList(str_list).indexOf("r");

        if (lIndex != -1 && (rIndex == -1 || lIndex < rIndex)) {
            // "l"이 포함되어    있고 "r"이 없거나 "l"이 먼저 나온 경우
            resultList.addAll(Arrays.asList(str_list).subList(0, lIndex));
        } else if (rIndex != -1 && (lIndex == -1 || rIndex < lIndex)) {
            // "r"이 포함되어 있고 "l"이 없거나 "r"이 먼저 나온 경우
            resultList.addAll(Arrays.asList(str_list).subList(rIndex + 1, str_list.length));
        }

        return resultList.toArray(new String[0]);

    }

    /**
     * 배열 조각하기
     * 문제 설명
     * 정수 배열 arr와 query가 주어집니다.
     *
     * query를 순회하면서 다음 작업을 반복합니다.
     *
     * 짝수 인덱스에서는 arr에서 query[i]번 인덱스를 제외하고 배열의 query[i]번 인덱스 뒷부분을 잘라서 버립니다.
     * 홀수 인덱스에서는 arr에서 query[i]번 인덱스는 제외하고 배열의 query[i]번 인덱스 앞부분을 잘라서 버립니다.
     * 위 작업을 마친 후 남은 arr의 부분 배열을 return 하는 solution 함수를 완성해 주세요.
     * @param arr
     * @param query
     * @return
     */
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr;
        int [] tmp = {};
        ArrayList arrList = (ArrayList) Arrays.asList(arr);
        for( int i =0; i< query.length; i++){
            if(i%2==0){
                tmp = Arrays.copyOfRange(answer, 0, query[i]+1);
            }else {
                tmp = Arrays.copyOfRange(answer, query[i], answer.length+1);
            }
            answer = tmp;
        }
        return answer;
    }
    public static  int[] solution_exchangeindex(int[] num_list, int n) {

        int [] after_n = Arrays.copyOfRange(num_list, n, num_list.length+1);
        int [] before_n = Arrays.copyOfRange(num_list,0, n);
        int[] answer = IntStream.concat(Arrays.stream(after_n), Arrays.stream(before_n)).toArray();

        return answer;
    }

    /**
     * 할 일 목록
     * 문제 설명
     * 오늘 해야 할 일이 담긴 문자열 배열 todo_list와 각각의 일을 지금 마쳤는지를 나타내는
     * boolean 배열 finished가 매개변수로 주어질 때,
     * todo_list에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
     * @param todo_list
     * @param finished
     * @return
     */
    public String[] solution_todoList(String[] todo_list, boolean[] finished) {
        List<String> resultList = new ArrayList<>();
        String[] answer = {};
        for( int i =0; i< finished.length; i++ ){
            if(finished[i] == false){
                resultList.add(todo_list[i]);
            }
        }


        List<String> resultList2 = IntStream.range(0, finished.length)
                .filter(i -> !finished[i])
                .mapToObj(i -> todo_list[i])
                .collect(Collectors.toList());
//        return answer;
        return resultList2.toArray(new String[0]);
    }

    /**
     * n보다 커질 때까지 더하기
     * 문제 설명
     * 정수 배열 numbers와 정수 n이 매개변수로 주어집니다. numbers의 원소를 앞에서부터 하나씩 더하다가 그 합이 n보다 커지는 순간 이때까지 더했던 원소들의 합을 return 하는 solution 함수를 작성해 주세요.
     * @param numbers
     * @param n
     * @return
     */
    public int solution_sumvsN(int[] numbers, int n) {
        int answer =0;

        for(int i =0; i<numbers.length; i++){
            answer+=numbers[i];
            if(answer > n){
                break;
            }
        }

        return answer;

    }

    /**
     * 배열의 원소만큼 추가하기
     * 문제 설명
     * 아무 원소도 들어있지 않은 빈 배열 X가 있습니다.
     * 양의 정수 배열 arr가 매개변수로 주어질 때,
     * arr의 앞에서부터 차례대로 원소를 보면서 원소가 a라면 X의 맨 뒤에 a를 a번 추가하는 일을 반복한 뒤의 배열 X를 return 하는 solution 함수를 작성해 주세요.
     * @param arr
     * @return
     */
    public int[] solution_add(int[] arr) {
        int[] answer = {};
        int[] repeatedArray = {};
        for(int i=0; i< arr.length; i++){
            int n  = arr[i];
            repeatedArray = IntStream.generate(() -> n).limit(arr[i]).toArray();
            answer= IntStream.concat(Arrays.stream(answer), Arrays.stream(repeatedArray)).toArray();
        }
        return answer;
    }
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 100, 99, 98};
        int[] arr = {1, 4, 2, 5, 3};
        int [][] queris = {{0, 4, 1},{0, 3, 2},{0, 3, 3}};

//        // solution 메서드 호출
//        int[] result = solution(arr);

//        // 결과 출력
//        Arrays.stream(result).forEach(System.out::println);

//        solution_lastIndex(arr);

//        solution_sequence2(arr, queris);

//        String[] intStrs ={"0123456789","9876543210","9999999999999"};
//        int k =50000;
//        int s =	5;
//        int l =	5;
//       int [] result =  solution_mkArray5(intStrs , k, s, l);
//        int[] array = {1, 2, 3, 2, 5, 2, 7}; // 예시 배열
//
//        solution_find2(array);

        String [] str =  {"u", "u", "r", "l" ,"u","sdf"	};
       solution_leftRight2 (str);

//       int []arr123 = {2, 1, 6} ;
//       solution_exchangeindex(arr123, 2);
//       System.out.println(result);

    }


 
}
