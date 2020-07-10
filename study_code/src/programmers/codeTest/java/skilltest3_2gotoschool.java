package programmers.codeTest.java;

public class skilltest3_2gotoschool {
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] d = new int[n+1][m+1];
        
        for(int i=0; i<puddles.length; i++) {
            d[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        d[1][1] = 1;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(d[i][j] == -1) {
                    continue;
                }
                if(d[i][j-1] >= 0 && d[i][j] >= 0) {
                    d[i][j] += d[i][j-1] %1000000007 ;
                }
                if(d[i-1][j] >= 0 && d[i][j] >= 0) {
                    d[i][j] += d[i-1][j] % 1000000007;
                }
            }
        }

        answer = d[n][m]%1000000007;
        
        return answer;
    }
    public static void main(String[] args) {
        int[][] puddles = {{2, 2}, {3, 2}};
        System.out.println(solution(4, 3, puddles));
    }
}
