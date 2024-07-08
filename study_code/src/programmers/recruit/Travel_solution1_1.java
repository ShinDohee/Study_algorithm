package programmers.recruit;

import java.util.*;

public class Travel_solution1_1 {
    public static void main(String[] args) {
        String hope_number1 = "123-4xx";
        String[] exist_number1 = {
                "123-XX0", "XXX-4X1", "123-4X2", "123-4X3", "123-4X4", "123-4X5", "123-4X7", "123-4X8", "123-4X9", "123-456", "XXX-X9X"
        };

        String[] result1 = solution(hope_number1, exist_number1);
        printResults(result1);

        String hope_number2 = "0XX-XXX";
        String[] exist_number2 = {
                "0XX-XX0", "0XX-XX1", "0XX-XX2", "0XX-XX3", "0XX-XX4", "0XX-XX5", "0XX-XX6", "0XX-XX7", "0XX-XX8", "0XX-XX9"
        };

        String[] result2 = solution(hope_number2, exist_number2);
        printResults(result2);
    }

    public static String[] solution(String hope_number, String[] exist_numbers) {
        List<String> availableNumbers = new ArrayList<>();

        int idx = hope_number.indexOf('x');
        if (idx == -1) {
            return new String[] {"-1"};
        }

        for (char c = '0'; c <= '9'; c++) {
            StringBuilder possibleNumber = new StringBuilder();
            for (int i = 0; i < hope_number.length(); i++) {
                if (hope_number.charAt(i) == 'x') {
                    possibleNumber.append(c);
                } else {
                    possibleNumber.append(hope_number.charAt(i));
                }
            }

            boolean exists = false;
            for (String existNumber : exist_numbers) {
                if (existNumber.equals(possibleNumber.toString())) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                availableNumbers.add(possibleNumber.toString());
            }
        }

        if (availableNumbers.isEmpty()) {
            return new String[] {"-1"};
        } else {
            return availableNumbers.toArray(new String[0]);
        }
    }

    public static void printResults(String[] results) {
        for (String number : results) {
            System.out.print("\"" + number + "\" ");
        }
        System.out.println();
    }
}