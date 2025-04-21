import java.util.*;
class Solution {
    static final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n+1][m+1];
        boolean[][] map = new boolean[n+1][m+1];
        
        for(int[] puddle : puddles){
            map[puddle[1]][puddle[0]] = true;
        }
        
        dp[1][1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1 && j==1)continue;
                if(map[i][j]) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }
        return dp[n][m];
    }
}