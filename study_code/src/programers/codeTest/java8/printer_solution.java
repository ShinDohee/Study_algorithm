package programers.codeTest.java8;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class printer_solution {
	public static int solution(int[] priorities, int location) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위가 높은 순


		for (int priority : priorities){
			pq.offer(priority);
		}

		while (!pq.isEmpty()){
			for (int i = 0; i < priorities.length; i++) {
				if(pq.peek() == priorities[i]){
					pq.poll();
					answer++;

					if(location==i){
						pq.clear();
						break;
					}
				}
			}

		}


		return answer;
	}
    
    
    public static void main(String[] args) {
    	int[] priorities= {2, 1, 3, 2};
    	int location = 2;
		System.out.println(solution(priorities, location));
		
	}
}
