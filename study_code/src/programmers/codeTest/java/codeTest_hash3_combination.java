package programmers.codeTest.java;

import java.util.HashMap;
import java.util.Map;

public class codeTest_hash3_combination {
	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> hash = new HashMap<>();

		for (String[] strings : clothes) { //종류별로 옷가지수 체크
			hash.put(strings[1], hash.getOrDefault(strings[1], 0) + 1);
		}

		//모든 종류에 안입는 옷의 경우수 * result
		// result = (A 옷가지의 경우의수 +1)*(B 옷가지의 경우의수 +1)*(C 옷가지의 경우의수 +1) -1
		//-1 은 모든 옷을 안입는 경우 
		for (int value : hash.values()) {
			answer *= (value+1) ; 
			
		}

		return answer-1;
	}

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution(clothes));
	}



}
