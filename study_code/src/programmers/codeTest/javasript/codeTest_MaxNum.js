/**
 * 
 */


function solution(numbers) {    
     var answer = numbers.map(v=>v+'')  // 각숫자들 문자로변환
                        .sort((a,b) => (b+a) - (a+b))  // 문자로 변환한 숫자 연결하여 비교정렬
                        .join(''); // 문자열로  합치기 
    return answer[0]==='0'?'0':answer; //배열이 0으로만 구성될 경우 0만 출력 
}