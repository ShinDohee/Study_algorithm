package programmers.codeTest.java;

public class BlindRecruitment2020 {

	public static void main(String[] args) {
		System.out.println("123".replace("1", "").length());
		System.out.println(solution("aabbaccc"));
		
	}
	public static int solution(String s) {
		int answer = 0;
		int strlenght_Min=s.length();
		String vsStr = "";
		
		for (int i = 1; i < s.length(); i++) { // 압축 길이가 1개씩 증가 . 
			 vsStr= s.substring(0, i); // 비교 문구 추출 
			 String copyS= s;
			 String vsS ="";
			 String answerS ="";
			 int countvsS =0;
			 while(copyS.length()>0) { //문자열의 길이가 0보다 클때!
				 if(vsS.length()>copyS.length()) {
					 answerS +=copyS;
					 break;
				 }
				 if(vsS.equals("") || !vsS.equals(copyS.substring(0, i))) {	
					 if(countvsS==1) {
						 answerS += vsS;
					 }else if(countvsS>1) {
						 answerS += countvsS+ vsS;
					 }
					 
					 vsS = copyS.substring(0, i);
					 countvsS = 0;
					 
				 }
				
				 if(copyS.indexOf(vsS) ==0) {
					 copyS = copyS.substring(i);
					 countvsS++;
				 }
				 
				 				 
			 }
			 
			 if(countvsS==1) {
				 answerS += vsS;
			 }else if(countvsS>1) {
				 answerS += countvsS+ vsS;
			 }
			 
			 if(answerS.length()< strlenght_Min) {
				 strlenght_Min=answerS.length();
			 }
		}
		answer = strlenght_Min;
		return answer;
	}
}
