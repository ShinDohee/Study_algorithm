package interviewbit;

public class NumberoOf1Bits {
    public static int countOneBits(int number) {
        return Integer.bitCount(number);
    }

    public static void main(String[] args) {
//        // 테스트를 위한 예제
        int number1 = 11;  // 101 in binary, 1의 개수: 2

        System.out.println("Number: " + number1 + " -> 1 Bit Count: " + countOneBits(number1));

    }
}
