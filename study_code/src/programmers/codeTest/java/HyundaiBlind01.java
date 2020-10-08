package programmers.codeTest.java;


//n 이 짝수 일때 -> 최대값이 네 방향 모두 같고
//n 이 홀수 일떄 최대값이 1번째 가 가장 크고 나머지 는 -1 
//시계 방향 일때는 가로
// 반시계방향  세로 


/***
 * 
 * 
	[[1, 8, 7, 6, 5, 4, 3, 2, 1], 
	[2, 9, 14, 13, 12, 11, 10, 9, 8],
	[3, 10, 15, 18, 17, 16, 15, 14, 7], 
	[4, 11, 16, 19, 20, 19, 18, 13, 6], 
	[5, 12, 17, 20, 21, 20, 17, 12, 5], 
	[6, 13, 18, 19, 20, 19, 16, 11, 4], 
	[7, 14, 15, 16, 17, 18, 15, 10, 3], 
	[8, 9, 10, 11, 12, 13, 14, 9, 2], 
	[1, 2, 3, 4, 5, 6, 7, 8, 1]]
 * 
 * 
 * 
[[1, 8, 7, 6, 5, 4, 3, 2, 1],
 [2, 9, 14, 13, 12, 11, 10, 9, 8],
[3, 10, 15, 18, 17, 16, 15, 14, 7], 
[4, 11, 16, 0, 0, 0, 18, 13, 6],
 [5, 12, 17, 0, 0, 0, 17, 12, 5], 
 [6, 13, 18, 0, 0, 0, 16, 11, 4],
  [7, 14, 15, 16, 17, 18, 19, 20, 3],
   [8, 9, 20, 11, 12, 13, 14, 9, 2], [1, 2, 3, 4, 5, 6, 7, 8, 1]]




 * ***/
 
public class HyundaiBlind01 {
	  static int[][] answer = {} ;
	  public static int[][] solution(int n, boolean clockwise) {
	        int[][] answer = new int [n][n];
	        int max_num=0;;
	        int other_num =0;
	        int cnP = n;
	        int x_idx =0; 
	        int y_idx =0;
	        int [] idx = new int [2];

	        max_num= max_num(n-1);
	        if(n%2 ==0) {
	        	other_num= max_num;
	        }  else {
	        	other_num = max_num-1;
	        }
	        //1번쨰 둘래
	        answer[x_idx][y_idx]=1;
	        int Count =0; 
	        int cnpaddNum=n-1;
	        for(int i=2; i<max_num+1;i++) {

	          	if(i==cnP) {
	        		Count++;
	        		cnpaddNum=cnpaddNum-2;
	        		if(cnpaddNum <3 ) {
	        			cnP++;
	        		}else {
	        			
	        			cnP += cnpaddNum;
	        		}
	        	}
	          	idx=	setIndex(x_idx, y_idx, Count, clockwise);
	          	x_idx= idx[0];
	          	y_idx= idx[1];
	        	  answer[x_idx][y_idx]=i;

	        }
	        
	       //2번쨰 둘래
	        
	       Count =1; 
	       if(clockwise) {
	    	   x_idx=0;
	    	   y_idx=n-1;
	    	   
	       }else {
		       x_idx=n-1;
		       y_idx=0;
	       }
	       answer[x_idx][y_idx]=1;
	       cnP = n;
	        for(int i=2; i<other_num+1;i++) {

	          	if(i==cnP) {
	        		Count++;
	        		cnP = cnP*2-3;
	        	}
	          	idx=	setIndex(x_idx, y_idx, Count, clockwise);
	          	x_idx= idx[0];
	          	y_idx= idx[1];
	        	  answer[x_idx][y_idx]=i;

	        }
	        
	        
	        //3번째
	        
	       Count =2; 
		       x_idx=n-1;
		       y_idx=n-1;	       
	       answer[x_idx][y_idx]=1;
	       cnP = n;
	        for(int i=2; i<other_num+1;i++) {

	          	if(i==cnP) {
	        		Count++;
	        		cnP = cnP*2-3;
	        	}
	          	idx=	setIndex(x_idx, y_idx, Count, clockwise);
	          	x_idx= idx[0];
	          	y_idx= idx[1];
	        	  answer[x_idx][y_idx]=i;

	        }
	        
	        
	        //4번쨰
		       Count =3; 
		       
		       if(clockwise) {
			       x_idx=n-1;
			       y_idx=0;
		    	   
		       }else {
		    	   x_idx=0;
		    	   y_idx=n-1;
		       }
		       

		       answer[x_idx][y_idx]=1;
		       cnP = n;
		        for(int i=2; i<other_num+1;i++) {

		          	if(i==cnP) {
		        		Count++;
		        		cnP = cnP*2-3;
		        	}
		          	idx=	setIndex(x_idx, y_idx, Count, clockwise);
		          	x_idx= idx[0];
		          	y_idx= idx[1];
		        	  answer[x_idx][y_idx]=i;

		        }
		        
	    
	        return answer;
	    }
	  
	  public static int [] setIndex (int x_idx, int y_idx, int Count, boolean clockwise){
		  int  [] result = new int [2];
		  

    	
    	if(clockwise){
        	if(Count %4==0) {
        		y_idx++;
        	}
        	else if (Count%4==1) {
				x_idx++;
			}
        	else if (Count%4==2) {
        		y_idx--;
        	}
        	else if (Count%4==3) {
        		x_idx--;
        	}
    	}else {
        	if(Count %4==0) {
        		x_idx++;
        	}
        	else if (Count%4==1) {
				y_idx++;
			}
        	else if (Count%4==2) {
        		x_idx--;
        	}
        	else if (Count%4==3) {
        		y_idx--;
        	}
    	}
    	
    	result[0] =x_idx;
    	result[1] = y_idx;
    			
		  
		  return result;
	  }

    
    public static int max_num (int n){
        int max_num =0;
        
        while(n>0){
            max_num += n;
            if(n==2 || n ==3){
                break;
            }

            n = n-2;
            
          
        }

        max_num +=1;
        
        return max_num;
    }
    
    
    public static void main(String[] args) {
		max_num(9);
		System.out.println(max_num(9));
		solution(9, false);
	}
}
