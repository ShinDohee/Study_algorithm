package programmers.codeTest.java;

import java.util.stream.IntStream;


public class CodeTest_ExSearch_TestSolution {
    public static int[] solution(int[] answers) {
        int [] firstPattern = {1, 2, 3, 4, 5};
        int [] secondPattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int [] thirdPattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int firstAnswer = countCorrectAnswers(answers, firstPattern);
        int secondAnswer = countCorrectAnswers(answers, secondPattern);
        int thirdAnswer = countCorrectAnswers(answers, thirdPattern);

        return compareAndReturn(firstAnswer, secondAnswer, thirdAnswer);
    }
    private static int countCorrectAnswers(int[] answers, int[] pattern) {
        return (int) IntStream.range(0, answers.length)
                .filter(i -> answers[i] == pattern[i % pattern.length])
                .count();
    }

    public static int[] compareAndReturn(int a, int b, int c) {
        if (a == b && b == c) {
            return new int[]{1, 2, 3};
        } else if ((a == b && a> c )|| (a == c && a> b) || (b == c && a<c)){
            if (a == b) return new int[]{1, 2};
            if (a == c) return new int[]{1, 3};
            if (b == c) return new int[]{2, 3};
        }

        int max = Math.max(a, Math.max(b, c));
        if (max == a) return new int[]{1};
        if (max == b) return new int[]{2};
        return new int[]{3};
    }

    public static void main(String[] args) {
       int [] answers ={1,2,3,4,5};
       solution(answers);
    }
}
