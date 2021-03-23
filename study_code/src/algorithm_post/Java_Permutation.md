# Java - 순열 



## 순열 (Permutation)

순열이란? 서로 다른 n 개중 r개를 골라 일렬로 배열한 나열한 경우의 수 

( C, C++은 라이브러리 함수를 지원하지만, java는 지원하지 않는다. )

> 집합 원소가 {A,B,C} 일때, 3개의 원소를 모두 사용하여 순서를 고려해 나열하는 경우의 수는
>
> ABC , ACB , BAC, BCA, CAB, CBA  총 가지가 나오게 됩니다. 



![NewPermutation](http://www.eandbsoftware.org/wp-content/uploads/2013/07/NewPermutation.gif)

​	출처 : http://www.eandbsoftware.org/print-all-permutations-of-a-given-string/



<pre>
순열 알고리즘 Java

    public class Permutation {
    	public static void main(String[] args) {
    		char[] arr = { 'A', 'B', 'C' };
    		permutation(arr, 0, 3);
    	}
    
    	/**
    	 * 
    	 * @param arr - 순열을 진행 할 문자  배열
    	 * @param depth - 시작 깊이 
    	 * @param r - 추출할 문자 갯수 
    	 */
    	static void permutation(char[] arr, int depth, int r) {
    		if (depth == r) { // 깊이 == 추출할 문자의 갯수가 동일하면 출력하고, resturn 값 추출 
    			for (int i = 0; i < r; i++) {
    				System.out.print(arr[i] + "\t");
    			}
    			System.out.println();
    			return;
    		}
    
    		for (int i = depth; i < arr.length; i++) {
    			char tmp = arr[depth];
    			arr[depth] = arr[i];
    			arr[i] = tmp;
    			//재귀함수, 다음 단계 
    			permutation(arr, depth + 1, r);
    
    			arr[i] = arr[depth];
    			arr[depth] = tmp;
    		}
    	}
    }
</pre>