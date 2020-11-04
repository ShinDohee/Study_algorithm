package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.StyledEditorKit.BoldAction;

//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

public class Codetest_heep01 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int count =0;
        
      ArrayList<Integer> heep  =  new ArrayList<>();
      
      int newScoville=0;
      	//int 배여 arraylist 로 
      for (int i = 0; i < scoville.length; i++) {
		heep.add(scoville[i]);
	}
      //오름차순 정렬 
      Collections.sort(heep);
    
      
      
      while(heep.size()>1) {
    	  //새로운 코빌 지수 
    	  newScoville =  heep.get(0)+(heep.get(1) *2);
    	  heep.remove(1);
    	  heep.remove(0);
    	  heep.add(newScoville);
    	  answer ++;
    	  Collections.sort(heep);

    	  if(!check(heep, K)) {
    		  continue;
    	  }else{
    		  break ;
    	}   
      }
      
      if(K > heep.get(0) && answer == scoville.length-1) {
    	  answer = -1;
      }

        return answer;
    }
    
    // 리스트 항목이 기준 값보다큰지, 작은지 체크 
    public static boolean check (ArrayList<Integer> n , int k) {
    	boolean a = true;
    	for (int i = 0; i < n.size(); i++) {
			if(k > n.get(i)) a= false;
		}
    	
		return a;
	}
    
    
    public static void main(String[] args) {
//    	[1, 2, 3, 9, 10, 12], 7
//    		2
    	int [] scoville = {1,2,3,9,10,12};
    	int K = 550;
    	
    	solution(scoville, K);
	}
}
