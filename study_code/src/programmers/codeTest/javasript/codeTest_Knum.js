/**
 * 
 */

function solution(array, commands) {
    var answer = [];
    var emptyArr = [];
    
    for(var i=0; i<commands.length; i++){
    	var vsArray = array;
        
    	emptyArr= vsArray.slice(commands[i][0]-1,commands[i][1]);
    	emptyArr.sort(function (a,b){
    		return a-b;
    	});

    	answer[i] = emptyArr[commands[i][2]-1];
    }
    
    return answer;
}
