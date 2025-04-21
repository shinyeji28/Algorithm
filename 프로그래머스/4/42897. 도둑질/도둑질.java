import java.util.*;

/*
2차원 배열을 배열 조회 시 2단계 인덱싱으로 1차원 배열 2개를 바로 접근하는 것보다 메모리 효율성이 떨어져 비효율적임 : 시간 초과 발생 이유
1차원으로 풀어서 접근하는게 유리함
*/
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int[] dp1 = new int[money.length];  // 0 안 턴다, 1 턴다
        int[] dp2 = new int[money.length];
        // 0번집을 안 턴다
        for(int i=1;i<dp1.length;i++){
            dp1[i] = Math.max(dp1[i-1], dp2[i-1]);
            dp2[i] = dp1[i-1] + money[i];

        }
        answer = Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);
        
        // 0번집을 턴다 -> 1번째와 마지막은 무조건 안 털어야 함
        dp1 = new int[money.length];  
        dp2 = new int[money.length];
        dp1[0] = dp2[0] = dp2[1] = money[0];
        
        for(int i=1;i<dp1.length;i++){
            dp1[i] = Math.max(dp1[i-1], dp2[i-1]);
            if(i != 1 && i!=dp1.length-1)dp2[i] = dp1[i-1] + money[i];
        }
        answer = Math.max(answer, Math.max(dp1[dp1.length-1],dp2[dp2.length-1]));

        return answer;
    }
}