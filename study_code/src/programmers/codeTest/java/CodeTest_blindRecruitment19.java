package programmers.codeTest.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CodeTest_blindRecruitment19 {
    public static String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> resultMg = new ArrayList<>();
        Map<String, String > nameId = new HashMap<>();
        
        for (int i = 0; i < record.length; i++) {
    		String id= record[i].split(" ")[1];
    		
        	if(record[i].contains("Enter") ||record[i].contains("Change") ) {    		
        		nameId.put(id, record[i].split(" ")[2]); 
        	}
		
		}
        
        for (String string : record) {
        	String id = string.split(" ")[1];
        	String name = nameId.get(id);
    		
			if(string.contains("Enter")) {
				resultMg.add(name +"님이 들어왔습니다.");
				
			}else if(string.contains("Leave")) {			
				resultMg.add(nameId.get(id) +"님이 나갔습니다.");
			}
		}
        answer=  resultMg.toArray(answer);
        return answer;
        
    }
    public static void main(String[] args) {
    	String [] adasdf  ={"Enter uid1234 Muzi", 
    						"Enter uid4567 Prodo",
    						"Leave uid1234",
    						"Enter uid1234 Prodo",
    						"Change uid4567 Ryan"};
    	
    	/**
    	 *  Enter uid1234 Muzi
			Enter uid4567 Prodo
			Leave uid1234
			Enter uid1234 Prodo
			Change uid4567 Ryan
]
    	 * ["Prodo님이 들어왔습니다.", 
    	 * "Ryan님이 들어왔습니다.",
    	 *  "Prodo님이 나갔습니다.", 
    	 *  "Prodo님이 들어왔습니다."]
    	 */
		solution(adasdf);
	}
}
