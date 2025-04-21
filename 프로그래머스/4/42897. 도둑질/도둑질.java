import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int[] dp = new int[money.length+1];
        // 0번집을 안 턴다
        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i-1]);
        }
        answer = dp[dp.length-1];
        
        // 0번집을 턴다 -> 1번째와 마지막은 무조건 안 털어야 함
        dp = new int[money.length+1];
        dp[1] = dp[2] = money[0];
        for(int i=3;i<dp.length-1;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i-1]);
        }
        answer = Math.max(answer, dp[dp.length-2]);

        return answer;
    }
}