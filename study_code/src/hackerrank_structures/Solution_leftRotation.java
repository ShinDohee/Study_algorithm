package hackerrank_structures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Queue 를 써서 다시 구현 해볼것 
public class Solution_leftRotation {
	 public static void main(String[] args) throws IOException {
//	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//	        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
////
//	        int n = Integer.parseInt(firstMultipleInput[0]);
	        	int n =5;
//	        int d = Integer.parseInt(firstMultipleInput[1]);
	        int d = 4;

//	        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
	        int [] arrTemp = {1,2,3,4,5};
	        
	        List<Integer> arr = new ArrayList<>();


	        for (int i = 0; i < n; i++) {
	            int arrItem =arrTemp[i];
	            arr.add(arrItem);
	        }

	        List<Integer> result = rotateLeft(d, arr);
	        
	        System.out.println("?");

//	        for (int i = 0; i < result.size(); i++) {
//	            bufferedWriter.write(String.valueOf(result.get(i)));
//
//	            if (i != result.size() - 1) {
//	                bufferedWriter.write(" ");
//	            }
//	        }
//
//	        bufferedWriter.newLine();
//
//	        bufferedReader.close();
//	        bufferedWriter.close();
	    }
	 
     public static List<Integer> rotateLeft(int d, List<Integer> arr) {
     // Write your code here
     	List<Integer> result = new ArrayList<Integer>();
     	
     	int startindex= d%arr.size();
     	int index=0;
     	if(d %arr.size()==0) {
     		return arr;
     	}else {

     	 for (int i = 0; i < arr.size(); i++) {
     		 if(i+startindex <= arr.size()-1) {
     			 index = i+startindex;
     			 
     		 }else {
     			 index = i+startindex-arr.size();
     		 }
     		 result.add(i, arr.get(index));
			}
     	}
     	return result; 
     }
}
