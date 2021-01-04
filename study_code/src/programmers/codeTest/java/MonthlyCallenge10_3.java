package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.List;

/***
 * 
어떤 문자열 x의 아름다움을 다음과 같이 정의합니다.

만약 x의 모든 글자가 전부 같다면, 0입니다.
그렇지 않다면, 서로 다른 글자가 위치해 있는 두 인덱스 i, j를 골랐을 때의 j-i 값들 중 최대값입니다.
예를 들어, 문자열 abbca의 아름다움은 3입니다. 인덱스 1(b)과 4(a)를 고르거나, 또는 0(a)과 3(c)를 고를 때 최대값이기 때문입니다.

영어 소문자로 이루어진 문자열 s가 매개변수로 주어집니다. s의 모든 부분문자열의 아름다움의 합을 return 하도록 solution 함수를 완성해주세요.


 * 
 * @author intei0909
 *
 */
public class MonthlyCallenge10_3 {
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
    			if(arr[i][j]!= arr[i][j+1]) {
    				arr1.removeAll(arr1);
    				return arr1;
    				}
    					
				arr1.add(arr[i][j]);
				arr1.add(arr[i][j+1]);
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
    			if(Integer.compare((int) arr1.get(i),(int) arr1.get(i+1)) == 1 ) 
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

		solution(a);
	}
}
