package programmers.recruit;

import  java.util.*;

/**
 * generateAllCombinations 메서드 추가:
 * filterExistingNumbers 메서드 추가:
 * generateCombinations 메서드의 위치를 변경하여 generateAllCombinations 메서드와 가깝게 배치했습니다.
 * findAvailablePhoneNumbers 메서드에서 가능한 번호 생성과 필터링을 분리했습니다.
 */
public class Travel_Solution1_2 {
    public static void main(String[] args) {
        // 첫 번째 테스트 케이스
        String hope_number1 = "123-4xx";
        String[] exist_number1 = {
                "123-XX0", "XXX-4X1", "123-4X2", "123-4X3", "123-4X4", "123-4X5", "123-4X7", "123-4X8", "123-4X9", "123-456", "XXX-X9X"
        };

        String[] result1 = findAvailablePhoneNumbers(hope_number1, exist_number1);
        printResults(result1);

        // 두 번째 테스트 케이스
        String hope_number2 = "0XX-XXX";
        String[] exist_number2 = {
                "0XX-XX0", "0XX-XX1", "0XX-XX2", "0XX-XX3", "0XX-XX4", "0XX-XX5", "0XX-XX6", "0XX-XX7", "0XX-XX8", "0XX-XX9"
        };

        String[] result2 = findAvailablePhoneNumbers(hope_number2, exist_number2);
        printResults(result2);
    }

    public static String[] findAvailablePhoneNumbers(String hope_number, String[] exist_numbers) {
        List<String> availableNumbers = generateAllCombinations(hope_number);

        // 가능한 번호 중에서 존재하지 않는 번호를 결과 리스트에 추가한다.
        List<String> resultNumbers = filterExistingNumbers(availableNumbers, exist_numbers);

        // 결과 리스트가 비어있다면 "-1"을 반환한다.
        return resultNumbers.isEmpty() ? new String[]{"-1"} : resultNumbers.toArray(new String[0]);
    }

    /**
     * hope_number의 x 위치에 0~9까지 숫자를 대입하여 가능한 모든 번호를 생성합니다.
     * @param hope_number
     * @return
     */
    private static List<String> generateAllCombinations(String hope_number) {
        List<String> combinations = new ArrayList<>();
        List<Integer> xIndices = new ArrayList<>();

        for (int i = 0; i < hope_number.length(); i++) {
            if (hope_number.charAt(i) == 'x' || hope_number.charAt(i) == 'X') {
                xIndices.add(i);
            }
        }

        generateCombinations(hope_number.toCharArray(), xIndices, 0, combinations);
        return combinations;
    }

    private static void generateCombinations(char[] pattern, List<Integer> xIndices, int index, List<String> combinations) {
        if (index == xIndices.size()) {
            combinations.add(new String(pattern));
            return;
        }

        int pos = xIndices.get(index);
        for (char digit = '0'; digit <= '9'; digit++) {
            pattern[pos] = digit;
            generateCombinations(pattern, xIndices, index + 1, combinations);
        }
        pattern[pos] = 'x'; // 다음 반복을 위해 원래대로 복원
    }

    /**
     * 가능한 번호 중에서 존재하지 않는 번호를 필터링합니다.
     * @param availableNumbers
     * @param exist_numbers
     * @return
     */
    private static List<String> filterExistingNumbers(List<String> availableNumbers, String[] exist_numbers) {
        List<String> resultNumbers = new ArrayList<>();

        for (String number : availableNumbers) {
            if (!existNumberExists(number, exist_numbers)) { // exist에 없는 숫자가 있으면 추가
                resultNumbers.add(number);
            }
        }

        Collections.sort(resultNumbers); // 숫자가 작은 순서대로 정렬
        return resultNumbers;
    }

    /**
     * exist_numbers에  phoneNumber 있는지 확인
     * @param phoneNumber : 이용가능한 전화번호
     * @param exist_numbers: 존재하는 전화번호
     * @return
     */
    private static boolean existNumberExists(String phoneNumber, String[] exist_numbers) {
        for (String number : exist_numbers) {
            if (matchesPattern(phoneNumber, number)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 정규식 비교
     * @param phoneNumber
     * @param pattern
     * @return
     */
    private static boolean matchesPattern(String phoneNumber, String pattern) {
        if (phoneNumber.length() != pattern.length()) {
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (pattern.charAt(i) != 'X' && pattern.charAt(i) != 'x' && phoneNumber.charAt(i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void printResults(String[] results) {
        for (String number : results) {
            System.out.print("\"" + number + "\" ");
        }
        System.out.println();
    }
}

