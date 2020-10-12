package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.List;

public class Blindrecruitment2020_2 {
	public static void main(String[] args) {
		int[][] key= {{0, 0, 0}, 
				      {1, 0, 0},
				      {0, 1, 1}};
		int[][] lock= {{1, 1, 1}, 
					   {1, 1, 0}, 
					   {1, 0, 1}};
		
		System.out.println(solution(key, lock));
		
	}
	/**

	 * [0, 0, 0, 0, 0, 0, 0], 
	 * [0, 0, 0, 0, 0, 0, 0],
	 * [0, 0, 1, 1, 1, 0, 0], 
	 * [0, 0, 1, 1, 0, 0, 0], 
	 * [0, 0, 1, 0, 1, 0, 0], 
	 * [0, 0, 0, 0, 0, 0, 0], 
	 * [0, 0, 0, 0, 0, 0, 0]]

	 * */
	
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        int over_idx = key.length-1; 
        int nArrlen= over_idx*2+lock.length;
        int [][] newArray = new int [nArrlen][nArrlen];
        List num = new ArrayList<>();
        int count=0; //회전 카운트
        //새로운 lock  배열 만들기 

        
        for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock[i].length; j++) {
				newArray[i+over_idx][j+over_idx] =lock[i][j];	

			}
		}
        
       while(count<4) {
    	   if(count !=0) {
    		   key = rotation(key);
    	   }
    	   
    	   answer = search(key, newArray, lock);
    	   count++;
       }
    
        
        System.out.println("??");
        
        return answer;
    }
    
	/**
	 * 키를 lock 에 비교 
	 * 
	 * @param key
	 * @param newArray
	 * @param lock
	 * @author dhshin
	 * @return
	 */	    
    public static boolean search (int[][] key, int[][] newArray,  int[][] lock) {

    	for (int i = 0; i < newArray.length-2; i++) {
			for (int j = 0; j < newArray[i].length-2; j++) {
//				System.out.println("i == "+ i + "					J == "+j);
		    	int [][] coppyArray=   newArray;
				for (int idx_x = 0; idx_x < 3; idx_x++) {
					for (int idx_y = 0; idx_y < 3; idx_y++) {
						
//						System.out.println("idx_x :"+idx_x+"  ///// idx_y"+idx_y+"  //// key[idx_x][idx_y]  :: "+key[idx_x][idx_y]+" //////    lock[x_indx][y_indx]"+  newArray[idx_x+i][idx_y+j] 
//									+ "///			sum => "+key[idx_x][idx_y]+ newArray[idx_x+i][idx_y+j] );
						if(key[idx_x][idx_y]+ newArray[idx_x+i][idx_y+j] == 2 ) {
							newArray[idx_x+i][idx_y+j] =2;
						}else if(key[idx_x][idx_y]+ newArray[idx_x+i][idx_y+j] == 1 ) {
							newArray[idx_x+i][idx_y+j] =1;
						}
						
					}
				}
				
			if(	search1(coppyArray, key.length)) return true;
			}
		}
		return true;
	}
    public static boolean search1 (int[][] array, int size) {
    	for (int i = size; i < array.length-size; i++) {
			for (int j = size; j < array.length-size; j++) {
				if(array[i][j]==0||array[i][j]==2) return false;
			}
		}
    	
    	
    	return true;
    }
    
    /**
     * 배열 회전 함수 
     * @param arr
     * @author dhshin
     * @return
     */
    public static int [][] rotation(int [][] arr ){
    	int n= arr.length;
    	int [][] B = new int [n][n];
    	
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				B[i][j] = arr[n-1-j][i];
			}
			
		}
    	
    	return B;
    }
}
