package programmers.recruit;
import java.util.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Travel_solution1_4 {
    /**
     * IntStream.range(0, hope_number.length())와 람다 표현식을 사용하여 xIndices를 생성했습니다.
     * IntStream.rangeClosed(0, 9).forEach와 람다 표현식을 사용하여 generateCombinations 메서드 내에서 반복 작업을 처리했습니다.
     * @param args
     */
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

    private static List<String> generateAllCombinations(String hope_number) {
        List<Integer> xIndices = IntStream.range(0, hope_number.length())
                .filter(i -> hope_number.charAt(i) == 'x' || hope_number.charAt(i) == 'X')
                .boxed()
                .collect(Collectors.toList());

        List<String> combinations = new ArrayList<>();
        generateCombinations(hope_number.toCharArray(), xIndices, 0, combinations);
        return combinations;
    }

    private static void generateCombinations(char[] pattern, List<Integer> xIndices, int index, List<String> combinations) {
        if (index == xIndices.size()) {
            combinations.add(new String(pattern));
            return;
        }

        int pos = xIndices.get(index);
        IntStream.rangeClosed(0, 9).forEach(digit -> {
            pattern[pos] = (char) ('0' + digit);
            generateCombinations(pattern, xIndices, index + 1, combinations);
        });
        pattern[pos] = 'x'; // 다음 반복을 위해 원래대로 복원
    }

    private static List<String> filterExistingNumbers(List<String> availableNumbers, String[] exist_numbers) {
        return availableNumbers.stream()
                .filter(number -> Arrays.stream(exist_numbers).noneMatch(exist -> matchesPattern(number, exist)))
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean matchesPattern(String phoneNumber, String pattern) {
        if (phoneNumber.length() != pattern.length()) {
            return false;
        }
        return IntStream.range(0, phoneNumber.length())
                .allMatch(i -> pattern.charAt(i) == 'X' || pattern.charAt(i) == 'x' || phoneNumber.charAt(i) == pattern.charAt(i));
    }

    public static void printResults(String[] results) {
        Arrays.stream(results).forEach(number -> System.out.print("\"" + number + "\" "));
        System.out.println();
    }
}