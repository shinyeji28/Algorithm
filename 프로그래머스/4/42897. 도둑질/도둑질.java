/*
dp[][0] 안 털었다 -> dp[][0] and dp[][1] 다음은 안털어도 되고 털어도 되고
dp[][1] 털었다 -> dp[][0] 다음 털지 못함

*/
import java.util.*;
class Solution {
    public int solution(int[] money) {

        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];

        // 첫번째 집 안 턺
        dp1[0] = 0;
        dp1[1] = Math.max(money[1], dp1[0]);
        for(int i=2;i<money.length;i++){
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
        }
        
        // 첫번째 집 턺
        dp2[0] = money[0];
        dp2[1] = Math.max(money[1], dp2[0]);
        for(int i=2;i<money.length-1;i++){
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);

        }
       

        return Math.max(dp1[money.length-1], dp2[money.length-2]);
    }
}