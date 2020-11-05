package programmers.codeTest.java;


import java.util.*;


//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

public class Codetest_heep01 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        
      PriorityQueue<Integer> heep = new PriorityQueue<>();
      // FIFO
      for (int i : scoville) {
    	  heep.offer(i);
	}
      
      
      
      while(heep.peek()<K) {
    	  //새로운 코빌 지수 
    	  if(heep.size()<2) {
    		  answer = -1;
    		  break;
    	  }
    	  
    	  int firstLowscoville = heep.poll();
    	  int secondLowscoville = heep.poll();
    	  int mix_scoville = firstLowscoville+ (secondLowscoville*2);
    	
    	  heep.offer(mix_scoville);
    	  answer++;
      }
      

        return answer;
    }

    
    
    public static void main(String[] args) {
//    	[1, 2, 3, 9, 10, 12], 7
//    		2
    	int [] scoville = {1,2,3,9,10,12};
    	int K = 7;
    	
    	System.out.println(solution(scoville, K));;
	}
}
