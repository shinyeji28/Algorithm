import java.util.*;
/*
     
     dp[i][j] = dp[i-1][j] + dp[i][j-1]
     웅덩이면 pass
*/
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
                
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
            
        for(int[] p : puddles){
            dp[p[1]-1][p[0]-1] = -1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0&&j==0) || dp[i][j] == -1) continue;
                dp[i][j] = (((i-1 < 0 || dp[i-1][j]==-1)?0:dp[i-1][j]) + ((j-1 < 0 || dp[i][j-1]==-1)?0:dp[i][j-1])) % 1000000007;
            }
        }
        
        return dp[n-1][m-1];
    }
}