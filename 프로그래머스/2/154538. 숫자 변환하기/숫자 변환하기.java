import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        while(!q.isEmpty()){
            int num = q.poll();
            if(num==y){
                answer = dp[num];
                break;
            }
            
            int nextNum = num + n;
            if(nextNum <= y && dp[nextNum] > dp[num]+1){
                dp[nextNum] = dp[num]+1;
                q.offer(nextNum);
            }
            nextNum = num *2;
            if(nextNum <= y && dp[nextNum] > dp[num]+1){
                dp[nextNum] = dp[num]+1;
                q.offer(nextNum);
            }
            nextNum = num *3;
            if(nextNum <= y && dp[nextNum] > dp[num]+1){
                dp[nextNum] = dp[num]+1;
                q.offer(nextNum);
            }

            
        }
        
        return answer;
    }

}