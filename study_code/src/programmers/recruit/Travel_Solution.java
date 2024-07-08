package programmers.recruit;

import  java.util.*;
public class Travel_Solution {
    // 희망 전화번호 형식에 맞춰 가능한 전화번호들을 생성하여 반환합니다.
    public static String[] solution(String hope_number, String[] exist_number) {
        List<String> availableNumbers = new ArrayList<>();

        String[] hopeParts = hope_number.split("-");
        String prefix = hopeParts[0];
        String middlePattern = hopeParts[1];

        int xCount = (int) middlePattern.chars().filter(ch -> ch == 'x' || ch == 'X').count();

        generateCombinations(prefix, middlePattern.toCharArray(), 0, xCount, exist_number, availableNumbers);

        if (availableNumbers.isEmpty()) {
            return new String[]{"-1"};
        } else {
            Collections.sort(availableNumbers);
            return availableNumbers.toArray(new String[0]);
        }
    }

    private static void generateCombinations(String prefix, char[] pattern, int index, int xCount, String[] exist_number, List<String> availableNumbers) {
        if (index == pattern.length) {
            String phoneNumber = prefix + "-" + new String(pattern);

            if (!existNumberExists(phoneNumber, exist_number)) {
                availableNumbers.add(phoneNumber);
            }
            return;
        }

        if (pattern[index] == 'X' || pattern[index] == 'x') {
            for (char digit = '0'; digit <= '9'; digit++) {
                pattern[index] = digit;
                generateCombinations(prefix, pattern, index + 1, xCount, exist_number, availableNumbers);
            }
            pattern[index] = 'X';
        } else {
            generateCombinations(prefix, pattern, index + 1, xCount, exist_number, availableNumbers);
        }
    }

    private static boolean existNumberExists(String phoneNumber, String[] exist_number) {
        for (String number : exist_number) {
            if (phoneNumber.matches(convertToRegex(number))) {
                return true;
            }
        }
        return false;
    }

    private static String convertToRegex(String number) {
        return number.replace("X", "[0-9]")
                .replace("x", "[0-9]");
    }

    public static void main(String[] args) {
//        String hope_number1 = "123-4xx";
//        String[] exist_number1 = {
//                "123-XX0", "XXX-4X1", "123-4X2", "123-4X3", "123-4X4", "123-4X5", "123-4X7", "123-4X8", "123-4X9", "123-456", "XXX-X9X"
//        };
//
//        String[] result1 = solution(hope_number1, exist_number1);
//        System.out.println("Result 1 length: " + result1.length); // 예상 출력: 8
//        for (String number : result1) {
//            System.out.println(number);
//        }

        String hope_number2 = "0XX-XXX";
        String[] exist_number2 = {
                "0XX-XX0", "0XX-XX1", "0XX-XX2", "0XX-XX3", "0XX-XX4", "0XX-XX5", "0XX-XX6", "0XX-XX7", "0XX-XX8", "0XX-XX9"
        };

        String[] result2 = solution(hope_number2, exist_number2);
        System.out.println("Result 2 length: " + result2.length); // 예상 출력: 1
        for (String number : result2) {
            System.out.println(number);
        }
    }
}
