package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.Collections;

import before.Solution;

public class MonthlyCallege2 {
	  public static int[] solution(int n) {
	        int [][] tri_arr = new int [n][n]; //삼각형에 넣을 2차원 배열 
	        int x_dx =-1; //행 index
	        int y_dx =0; //열 index
	        int num =1;	 //배열에 들어가는 수    
	        int copyn = n; // 돌리는 방향 수
	        
	        for(int x = 1; x<n+1 ; x++) {	        	
	        	for(int i= copyn; i>0; i--) {
	        		if(x%3 ==1 ) {
	        			x_dx++;
	        		}else if(x%3==2 ) {
	        			y_dx++;
	        			
	        		}else {
	        			x_dx--;
	        			y_dx--;
	        		}
	        		
	        		tri_arr[x_dx][y_dx]=num++;
	        	}
	        	copyn--;
	        }
	        int[] answer = new int [num-1];
	       int answ_indx= 0; 
	        for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(tri_arr[i][j]==0) continue;
					
					answer[answ_indx++] = tri_arr[i][j];
				}
			}

	        return answer;
	    }
    
    public static void main(String[] args) {
    	

    	solution(4);

	}
}
