package programmers.bagic_training.Level00;

import java.util.Scanner;

public class Solution00_transferUptoLow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
//
        System.out.println(a.chars().mapToObj(c -> Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());

//        for( int i =0; i<a.length() ; i++){
//            System.out.println(a.charAt(i));
//        }
//        int n =0;

//        System.out.println("!@#$%^&*(\\'\"<>?:;");
    }

    public String solution(String myString) {
        return myString.chars().mapToObj(c -> c=='a' || c=='A' ? Character.toUpperCase(c): Character.toLowerCase(c))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
