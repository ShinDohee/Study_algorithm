package programmers.codeTest.java;

public class CodeTest_checkPrimeNumber {
	static boolean [] visit;
	static int [] result;
	static int [] arr ;
	
    public static int solution(String numbers) {
        int answer = 0;
        int size = numbers.length();
        
        //완전 탐색으로 만들 수 있는 수 생성 
        visit = new boolean[size];
        result = new int [size];
        arr = new int [size];
        int [] num = new int [size];
        for (int i = 0; i < numbers.length(); i++) {
        	num[i] = (int)numbers.charAt(i);
        	arr[i] = numbers.charAt(i);
        }
        int [] makenum ;

        
//        dfs(visit, size);
        
        
        for (int i = 0; i < num.length; i++) {
			//소수 체크
        	if(checkPrime(num[i])) {
				answer ++;
			}
		}
        
        return answer;
    }
    
    /**
     * 소수 체크 
     * @param num
     * @return
     */
    public static boolean checkPrime(int num) {
		// TODO Auto-generated method stub
    	
    	for (int i = 2; i < num; i++) {
			if(num %i==0) {
				return false;
			}
    		
		}
    	return true;
	}
    
    public static void dfs(int n ) {
   	
    	if(n== result.length ) {
    		
    		for (int i = 0; i < visit.length; i++) {
    			if(visit[i]) { 
    				
    		           System.out.print(arr[i]);
                }
            }System.out.println();
        }else{
            System.out.println("depth : " + n);
            visit[n] = true;
            result[n] = arr[n];
            dfs(n+1);
            visit[n] = false;
            dfs(n+1);
        }
	}
    
    public static void main(String[] args) {
//    	arr = {1,2,3}
    	
		System.out.println(solution("123") );
	}
}
