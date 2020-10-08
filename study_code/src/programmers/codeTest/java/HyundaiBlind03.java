package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.Collections;

import before.Solution;

public class HyundaiBlind03 {
	   public static String solution(String s) {
	        String answer = "";
	        ArrayList<String> result = new ArrayList<String>();
	        String tempstr ="";
	        
	        for(int i=1; i < s.length()+1;i++) {//길이!
	        	for (int j = 0; j < s.length()-i; j++) {//start index
	        		System.out.println("???");
	        		String s1 = reverseStr(s.substring(j, j+i));
	        		
	        		tempstr =  s.subSequence(0, j)+s1+ s.subSequence(i+j, s.length());
	        		
	        		result.add(tempstr);
	        		
				}
	        }
	        
	        Collections.sort(result);
	        
	        answer =result.get(result.size()-1);
	        return answer;
	    }
	   
	   public static String reverseStr(String s) {
		    return (new StringBuffer(s)).reverse().toString();
		  }

	   public static void main(String[] args) {
		
		   solution("zyxw");
	}
}
