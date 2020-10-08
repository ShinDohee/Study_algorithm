package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.List;

/***
 * 
 * 0과 1로 이루어진 2n x 2n 크기의 2차원 정수 배열 arr이 있습니다. 당신은 이 arr을 쿼드 트리와 같은 방식으로 압축하고자 합니다. 구체적인 방식은 다음과 같습니다.

당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.
arr이 매개변수로 주어집니다. 위와 같은 방식으로 arr을 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * arr	result
[[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]	[4,9]
[[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]	[10,15]
 * 
 * 비트 연산 ^ => 둘다 0,1 이면 --> 0
 * 			   다 다른거면 1 
 * 
 * =>>> 다시 풀것 
 * 
 * 
 * @author intei0909
 *
 */
public class MonthlyCallenge10_2 {
    public static int[] solution(int[][] arr) {
        int[] answer = new int [2];
        int n = arr.length*arr.length; // 최종 타일의 수 
        int  searchArea = n /4 ; // 최대 분할 횟수 
        int searchmode = 1; 
        ArrayList arr1 = new ArrayList<Integer>();
        boolean sametype  = true;
        int zero_count=0;
        int one_count=0;
        int num=0;
        int len_size = arr.length/2; //처음 분할 시 한 변 사이즈 
    	int x_index=0,  y_index=0;
    	
        while (len_size>1 ) {
        	
    		//시작 index 0인 사각형 압축 

        	arr1 = arraytoList(x_index, y_index,len_size,  arr);        	
        	sametype = t_F_tamplate(arr1);         
        	
            if(arr1.size() ==4 && sametype== false) {
            	for (int i = 0; i < arr1.size(); i++) {
      
            		if((int) arr1.get(i) ==1) one_count++;
            		else zero_count++;
    				
    			}
            }else if(sametype == true) {
            	if((int) arr1.get(0) ==1) one_count++;
        		else zero_count++;
            	
            }
            // 시작 index x -> len_size 에서 끝까지 
        	//2번째 x index 
        	x_index=0;
        	y_index = y_index;
           	arr1 = arraytoList(x_index ,y_index+len_size , len_size, arr);   
           	sametype = t_F_tamplate(arr1);
           	
            if(arr1.size() ==4 && sametype== false) {
            	for (int i = 0; i < arr1.size(); i++) {
      
            		if((int) arr1.get(i) ==1) one_count++;
            		else zero_count++;
    				
    			}
            }else if(sametype == true) {
            	if((int) arr1.get(0) ==1) one_count++;
        		else zero_count++;
            	
            }
            
           	//3번째 시작 index  8,0
            x_index = x_index+len_size;
           	y_index=0;
           	arr1 = arraytoList(x_index ,y_index, len_size, arr);   
           	sametype = t_F_tamplate(arr1);
            if(arr1.size() ==4 && sametype== false) {
            	for (int i = 0; i < arr1.size(); i++) {
      
            		if((int) arr1.get(i) ==1) one_count++;
            		else zero_count++;
    				
    			}
            }else if(sametype == true) {
            	if((int) arr1.get(0) ==1) one_count++;
        		else zero_count++;
            	
            }
           	//4번째 시작 index  8,0
           	x_index = len_size;
           	y_index = len_size;
           	arr1 = arraytoList(x_index ,y_index, len_size, arr);   
           	sametype = t_F_tamplate(arr1);
            

            if(arr1.size() ==4 && sametype== false) {
            	for (int i = 0; i < arr1.size(); i++) {
      
            		if((int) arr1.get(i) ==1) one_count++;
            		else zero_count++;
    				
    			}
            }else if(sametype == true) {
            	if((int) arr1.get(0) ==1) one_count++;
        		else zero_count++;
            	
            }
            
            num++;
            len_size= len_size/2;
			
		}

        
       answer[0] = zero_count;
       answer[1] = one_count;
        System.out.println(1/2);
        return answer;
    }
    
    public static ArrayList arraytoList (int x_satrt_index, int y_start_index, int size,int[][] arr) {
     	ArrayList arr1 = new ArrayList<Integer>();
      	for (int i = x_satrt_index; i < x_satrt_index+size; i++) {
    		for (int j = y_start_index; j < y_start_index+size-1; j++) {
    		
    				if(size==2 || arr[i][j]== arr[i][j+1]) {
    					arr1.add(arr[i][j]);
        				arr1.add(arr[i][j+1]);
    				}else {
    					if(arr[i][j]!= arr[i][j+1]) {
    						arr1.removeAll(arr1);
    						return arr1;
    					}
    					
    				}
    				
    			

			}
		}
    	return arr1;
    }
    
    public static boolean t_F_tamplate(ArrayList arr1) {
    	boolean sametype = true;
    	
       	if(arr1.size() == 0) {
    		sametype =false;
    	}else {
    		for (int i = 0; i < arr1.size()-1; i++) {            
    			if( arr1.get(i) != arr1.get(i+1) ) 
    			{
    				sametype = false;
    				break;
    			}
    			
    			sametype = true;
    			
    		}
    		
    	}
    	return sametype;
    }

    public static void main(String[] args) {
    	int [][]a = {{1,1,0,0},
    			      {1,0,0,0},
    			      {1,0,0,1},
    			      {1,1,1,1}};
    	
    	int [][]b =
    			{{1,1,1,1,1,1,1,1},
    			 {0,1,1,1,1,1,1,1},
    			 {0,0,0,0,1,1,1,1},
    			 {0,1,0,0,1,1,1,1},
    			 {0,0,0,0,0,0,1,1},
    			 {0,0,0,0,0,0,0,1},
    			 {0,0,0,0,1,0,0,1},
    			 {0,0,0,0,1,1,1,1}};	

		solution(b);
	}
}
