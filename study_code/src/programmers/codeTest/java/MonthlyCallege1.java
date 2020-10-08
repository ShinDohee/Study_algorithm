package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.Collections;

public class MonthlyCallege1 {
    public static int[] solution(int[] numbers) {
               
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        
        for(int i=0; i < numbers.length; i++) {
        	for(int j=0; j< numbers.length; j++ ) {
        		if(i==j) continue;
        		 
        		sum = numbers[i]+numbers[j];
        		
        		if(!arrayList.contains(sum)) arrayList.add(sum);
        	}
                	
        }
        Collections.sort(arrayList);
        int[] answer = new int[arrayList.size()];
        int indx =0;
        for (Integer integer : arrayList) {
    		answer[indx++] = integer;
       	}

        return answer;
    }
    
    public static void main(String[] args) {
    	int [] asd = {2,1,3,4,1};
    	solution(asd);
	}
}
