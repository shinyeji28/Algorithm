/*
B흔적에 대하여 A흔적 최소값 찾기
B흔적 b: 0~m개 일 때 dp[b] = A흔적 최소값 저장
*/
import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        
        int[] dp = new int[m];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=0;i<info.length;i++){
            int aEvi = info[i][0];
            int bEvi = info[i][1];
            
            int[] newDp = new int[m];
            Arrays.fill(newDp,Integer.MAX_VALUE);
            
            for(int b=0;b<m;b++){
                if(dp[b] == Integer.MAX_VALUE) continue;

                // A가 훔치고 흔적을 남길 때, B는 훔치지 않아 흔적이 없음
                int aCost = dp[b] + aEvi;
                int bCost = b;

                if(aCost < n) newDp[bCost] = Math.min(newDp[bCost], aCost);

                // B가 훔치고 흔적을 남길 때, A는 훔치지 않아 흔적이 없음
                aCost = dp[b];
                bCost = b + bEvi;

                if(bCost < m) newDp[bCost] = Math.min(newDp[bCost], aCost);

            }
            dp = newDp;
        } 
        for(int i=0;i<m;i++){
            answer = Math.min(dp[i], answer);
        }
        
        
        return answer==Integer.MAX_VALUE?-1:answer;
    }
}