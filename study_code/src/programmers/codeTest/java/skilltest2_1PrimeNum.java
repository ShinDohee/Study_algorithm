package programmers.codeTest.java;
/*
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
 * nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

public class skilltest2_1PrimeNum {
	   public int solution(int[] nums) {
	        int count =0;
	        
	        for (int i = 0; i < nums.length; i++) {
				for (int j = i+1; j < nums.length; j++) {
					for (int j2 = j+1; j2 < nums.length; j2++) {
						int sum = nums[i]+ nums[j]+nums[j2];
						
						if(isPrime(sum)) count++;
					}
				}
			}
	        
	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
	        System.out.println("Hello Java");

	        return count;
	    }
	   
	   public static boolean isPrime(int num) {
	        boolean result = true;
	        for(int i = 2; i < num; i++) {
	            if( num%i == 0) {
	                result = false;
	                break; 
	                //나누어 떨어지면 더이상 소수가 아니므로 break를 걸어 for문을 끝낸다.
	            } else {
	                result = true;
	            }
	        }        
	        return result;        
	    }


}
