import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int[] dx = new int[]{-1,-1};
        int[] dy = new int[]{-1,0};
        
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                for(int d=0;d<2;d++){
                    if(j-1 < 0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        int result = 0;
        for(int d : dp[dp.length-1]){
            result = Math.max(d, result);
        }        
        return result;               

    }

}