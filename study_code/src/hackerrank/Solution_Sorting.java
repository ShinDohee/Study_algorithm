package hackerrank;

import java.util.*;


public class Solution_Sorting {
	
	public static void countSwaps(int[] array) {
	    int size = array.length;
	     int count=0;
	    for(int i=0; i < size-1; i++) {
	        for(int j=0; j < size -1 -i;  j++) {
	            if(array[j] > array[j+1]){
	            	swap(array, j, j+1);
	                count++;
	                
	            }
	            System.out.printf("\n");

	        }
	    }
	    
	    
        System.out.println("Array is sorted in "+count+" swaps.");
        System.out.println("First Element: "+array[0]);
        System.out.println("Last Element: "+array[array.length-1]);
	    
	}
	 
	public static void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
