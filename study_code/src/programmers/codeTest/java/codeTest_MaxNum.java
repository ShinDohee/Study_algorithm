package programmers.codeTest.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class codeTest_MaxNum {
    public static String solution(int[] numbers) {
        String [] str = Arrays.toString(numbers).substring(1,Arrays.toString(numbers).length()-1 ).split(", ");
        String answer ="";
        
        Arrays.sort(str, new Comparator<String>() {
        	public int compare(String o1, String o2) {
        		return (o2+o1).compareTo(o1+o2);
        		}
		});

        
        if(str[0].startsWith("0")) {
        	answer = "0";
        }else {
        	answer= Arrays.toString(str).substring(1,Arrays.toString(numbers).length()-1 ).replace(", ", "");
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int numbers[] = {3, 30, 34, 5, 9};
    	solution(numbers);
    	
	}
}
