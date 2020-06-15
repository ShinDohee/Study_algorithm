package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.omg.CosNaming.IstringHelper;
/*
 * 	1. 참가자 해쉬 맵에  이름과 key값을 입력 하고, 일 이름이 다면 키값에 ( default 0) +1  해줌
	2. 완주한 사람이름은 참가자 해쉬맵에 있으면 키값을 -1 해줌
	3. 그래서 해당 키값이 0 인 사람의 이름을 return
 * 
 */
public class codeTest_hash1 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String	, Integer> hash = new HashMap<>();
        
        for (String string : participant) hash.put(string, hash.getOrDefault(string, 0)+1);
        for (String string : completion) hash.put(string, hash.get(string)-1);
       
        for (String name : hash.keySet()) {
        	if(hash.get(name) != 0) return name;
			
		}
        
        return answer;
    }
    
    public static void main(String[] args) {
    	String[] participant = {"mislav","stanko","mislav","ann"}; 
    	String[] completion= {"stanko","ana","mislav"};
    	
    	System.out.println(solution( participant, completion));
	}
}
