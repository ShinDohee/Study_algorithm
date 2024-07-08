package programmers.recruit;

import java.util.*;

public class Travel_Solution3 {
//    public static int[] checkSurveys(String[] replies, int n, int k) {
//        int[] result = new int[replies.length];
//
//        for (int i = 0; i < replies.length; i++) {
//            result[i] = isDefective(replies[i], n, k) ? 0 : 1;
//        }
//
//        return result;
//    }
//
//    private static boolean isDefective(String reply, int n, int k) {
//        int len = reply.length();
//
//        for (int size = n; size <= len / k; size++) {
//            for (int start = 0; start <= len - size * k; start++) {
//                String pattern = reply.substring(start, start + size);
//
//                boolean isConsecutive = true;
//                for (int j = 1; j < k; j++) {
//                    int nextStart = start + j * size;
//                    if (!pattern.equals(reply.substring(nextStart, nextStart + size))) {
//                        isConsecutive = false;
//                        break;
//                    }
//                }
//
//                if (isConsecutive) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /**
     * 각 설문지를 체크하여 불량 설문지인지 여부를 판별하는 메소드
     * @param replies 설문지 배열
     * @param n 패턴의 최소 길이
     * @param k 패턴이 연속되는 최소 횟수
     * @return 불량 설문지일 경우 0, 정상 설문지일 경우 1로 구성된 결과 배열
     */
    public static int[] checkSurveys(String[] replies, int n, int k) {
        return Arrays.stream(replies)
                .mapToInt(reply -> isDefective(reply, n, k) ? 0 : 1)
                .toArray();
    }

    /**
     * 특정 설문지가 불량 설문지인지 판별하는 메소드
     * @param reply 검사할 설문지 문자열
     * @param n 패턴의 최소 길이
     * @param k 패턴이 연속되는 최소 횟수
     * @return 불량 설문지일 경우 true, 정상 설문지일 경우 false
     */
    private static boolean isDefective(String reply, int n, int k) {
        int len = reply.length();

        Set<String> checkedPatterns = new HashSet<>(); // 이미 검사한 패턴을 관리하기 위한 Set

        // 패턴 길이 n부터 시작하여 최소 k번 연속되는 패턴을 검사
        for (int size = n; size <= len / k; size++) {
            for (int start = 0; start <= len - size * k; start++) {
                String pattern = reply.substring(start, start + size); // 패턴 추출

                // 이미 검사한 패턴이면 넘어감
                if (checkedPatterns.contains(pattern)) continue;

                // 패턴이 연속해서 k번 나타나는지 검사
                if (isPatternConsecutive(reply, pattern, start, size, k)) {
                    return true; // 불량 설문지로 판단
                }

                checkedPatterns.add(pattern); // 검사한 패턴을 Set에 추가
            }
        }
        return false; // 정상 설문지로 판단
    }

    /**
     * 특정 패턴이 연속해서 k번 나타나는지 검사하는 메소드
     * @param reply 검사할 설문지 문자열
     * @param pattern 검사할 패턴
     * @param start 패턴의 시작 위치
     * @param size 패턴의 길이
     * @param k 패턴이 연속되는 최소 횟수
     * @return 연속해서 k번 나타나면 true, 그렇지 않으면 false
     */
    private static boolean isPatternConsecutive(String reply, String pattern, int start, int size, int k) {
        for (int j = 1; j < k; j++) {
            int nextStart = start + j * size; // 다음 패턴의 시작 위치 계산
            // 다음 패턴이 현재 패턴과 일치하지 않으면 연속하지 않은 것으로 판단
            if (!pattern.equals(reply.substring(nextStart, nextStart + size))) {
                return false;
            }
        }
        return true; // 패턴이 연속해서 k번 나타남
    }
    public static void main(String[] args) {
        // 테스트 데이터
        String[] replies1 = {"AFFFDEFDEFDEEC", "ABABABABBCCEF", "FFFFFFFFFFFF", "FCBBBFCBBECBB"};
        int n1= 3;
        int k1 = 2;


        String[] replies2 = {"AFFDEFDEFDEEC", "ABABABABBCCEF", "FFFFFFFFFFFF", "FCBBBFCBBECBB"};
        int n2= 2;
        int k2 = 4;

        String[] replies3 = {"FFCCAAFCCAAA", "AAAABBBBCCCC", "ABCABCABCABC"};
        int n3= 4;
        int k3 = 2;

        String[] replies4 = {"FFCCAAFCCAAA", "AAAABBBBCCCC", "ABCABCABCABC"};
        int n4= 3;
        int k4 = 3;


        // 결과 출력
        int[] result = checkSurveys(replies1, n1, k1);
        System.out.println("1  :: "+Arrays.toString(result));

        int[] result2 = checkSurveys(replies2, n2, k2);
        System.out.println(Arrays.toString(result2));

        int[] result3 = checkSurveys(replies3, n3, k3);
        System.out.println(Arrays.toString(result3));

        int[] result4 = checkSurveys(replies4, n4, k4);
        System.out.println(Arrays.toString(result4));
    }
}
