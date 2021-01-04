/**
 * int answer = 0; // 결과값 //list 로 변화 Arrays.sort(citations); //인용의 수 배열 오름 차순
 * 
 * for (int i = 0; i < citations.length; i++) { int smallNum =
 * Math.min(citations[i], citations.length-i); answer = Math.max(answer,
 * smallNum); }
 * 
 * return answer;
 */

function solution(citations) {
	var answer = 0;
    citations.sort((a, b) => b - a); 
    

    while(answer <= citations.length){
        if(answer + 1 <= citations[answer]){
        	answer++;   
        }else break;
    }
    return answer;
}
