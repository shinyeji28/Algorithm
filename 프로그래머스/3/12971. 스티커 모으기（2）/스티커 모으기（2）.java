/*
    뗄것인가 안뗄것인가? -> dp
    dp[0] : 안 떼는 경우 / dp[1] : 떼는 경우
    
    
    1. dp[i][0](i번째를 안 떼는 경우) : i-1번째를 떼어내는 경우와 안떼어내는 경우 중 큰 것 고르기 (Math.max(dp[i-1][0], dp[i-1][1]))
    2. dp[i][1](i번째를 떼는 경우) : i-1번째를 안 떼어내는 경우만 가능 + 스티커 값
    
    추가 고려사항) 
    3. 원형이기 때문에 마지막 위치에서 떼어내는 경우는 첫번째를 안떼어내는 경우를 포함해야함
        -> 마지막 위치에서 떼어내는 경우 (dp[n-1][1]])은 첫번째 위치의 원소를 배제하고 dp진행
        -> 마지막 위치에서 안떼어내는 경우는 첫번째 위치의 원소를 포함하고 dp진행
*/

import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = sticker[0];
        int n = sticker.length;
        
        int[][] dpDontPickUp = new int[n][2]; // 첫번째 위치를 안 떼어내는 경우 포함 -> 마지막 위치에서 떼어내는 것과 안떼어내는 것 모두 고려
        dpDontPickUp[0][0] = 0;
        dpDontPickUp[0][1] = 0;
        
        int[][] dpPickUp = new int[n][2];     // 첫번째 위치를 떼어내는 경우 포함 -> 마지막 위치는 안 떼어내야함
        dpPickUp[0][0] = 0;
        dpPickUp[0][1] = sticker[0];          // (첫번째 요소는 안떼어낸다고 설정)

        for(int i=1;i<n;i++){
            dpDontPickUp[i][0] = Math.max(dpDontPickUp[i-1][0], dpDontPickUp[i-1][1]);
            dpDontPickUp[i][1] = dpDontPickUp[i-1][0] + sticker[i];
            
            dpPickUp[i][0] = Math.max(dpPickUp[i-1][0], dpPickUp[i-1][1]);
            dpPickUp[i][1] = dpPickUp[i-1][0] + sticker[i];
        }
        
        if(n>1)answer = Math.max(dpPickUp[n-1][0], Math.max(dpDontPickUp[n-1][0], dpDontPickUp[n-1][1]));

        return answer;
    }
}