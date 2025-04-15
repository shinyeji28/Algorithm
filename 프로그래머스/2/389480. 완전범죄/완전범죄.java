// /*
// A가 훔칠 것인가 말것이가 -> dp
// */
// import java.util.*;
// class Solution {
//     public int solution(int[][] info, int n, int m) {
//         int answer = 0;
//         int[][] dpA = new int[info.length][2];
//         int[][] dpB = new int[info.length][2];
//         for(int i=0;i<dpA.length;i++){
//             dpA[i][0] = dpA[i][1] = dpB[i][0] = dpB[i][1] = Integer.MAX_VALUE; 
//         }
        
//         // 0 : A가 훔치지않는다, 1 : A가 훔친다
//         dpA[0][0] = 0;
//         dpA[0][1] = info[0][0];
//         dpB[0][0] = info[0][1];
//         dpB[0][1] = 0;
        
//         if(info[0][0] >= n && info[0][1] >= m) return -1;
//         if(info[0][0] >= n) {
//             dpA[0][1] = 0;
//             dpB[0][1] = info[0][1];
//         }
//         if(info[0][1] >= m) {
//             dpA[0][0] = info[0][0];
//             dpB[0][0] = 0;
//         }
        
//         System.out.println(dpA[0][0]+" "+dpA[0][1]+" "+dpB[0][0]+" "+dpB[0][1]);
        
//         for(int i=1;i<dpA.length;i++){
//             boolean flag = false;
//             int a = info[i][0];
//             int b = info[i][1];
//             if(dpA[i-1][0] + a < n) {
//                 if(dpA[i][1] > dpA[i-1][0] + a){
//                     dpA[i][1] = dpA[i-1][0] + a;
//                     dpB[i][1] = dpB[i-1][0];
//                 }
//                 flag = true;
//             }
//             if(dpA[i-1][1] + a < n) {
//                 if(dpA[i][1] > dpA[i-1][1] + a){
//                     dpA[i][1] = dpA[i-1][1] + a;
//                     dpB[i][1] = dpB[i-1][1];
//                 }
//                 flag = true;

//             }
            
//             if(dpB[i-1][0] + b < m) {
//                 if(dpA[i][0] > dpA[i-1][0]){
//                     dpA[i][0] = dpA[i-1][0];
//                     dpB[i][0] = dpB[i-1][0] + b;
//                 }
//                 flag = true;

//             }
//             if(dpB[i-1][1] + b < m) {
//                 if(dpA[i][0] > dpA[i-1][1]){
//                     dpA[i][0] = dpA[i-1][1];
//                     dpB[i][0] = dpB[i-1][1] + b;
//                 }
//                 flag = true;

//             }
//             if(!flag)return -1;
//             if(i==dpA.length-1 )continue;
//             if(dpA[i][0]==Integer.MAX_VALUE)dpA[i][0] = 0;
//             if(dpA[i][1]==Integer.MAX_VALUE)dpA[i][1] = 0;
//             if(dpB[i][0]==Integer.MAX_VALUE)dpB[i][0] = 0;
//             if(dpB[i][1]==Integer.MAX_VALUE)dpB[i][1] = 0;
//         }

//         return Math.min(dpA[dpA.length-1][0],dpA[dpA.length-1][1]);
//     }
// }

import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        // INF: 충분히 큰 값 (최대 누적 흔적은 40*3 = 120이하이므로 1e9로 설정)
        final int INF = 1000000000;
        // dp[b] = 현재까지 처리한 물건들에서 B의 누적 흔적이 b일 때의 A의 누적 흔적의 최솟값.
        // dp 배열의 크기는 m (B의 누적 흔적은 m 미만이어야 하므로)
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;  // 아무것도 훔치지 않았을 때, A의 흔적 0, B의 흔적 0.
        
        // 각 물건에 대해 전이
        for (int i = 0; i < itemCount; i++) {
            int aTrace = info[i][0]; // 물건 i를 A 도둑이 훔칠 때 증가하는 A 흔적
            int bTrace = info[i][1]; // 물건 i를 B 도둑이 훔칠 때 증가하는 B 흔적
            int[] newDp = new int[m];
            Arrays.fill(newDp, INF);
            for (int b = 0; b < m; b++) {
                if (dp[b] == INF) continue; // 해당 상태는 불가능한 상태
                // Case 1: 물건 i를 A도둑이 훔침 → A 누적 흔적은 aTrace만큼 증가, B는 그대로.
                int newA = dp[b] + aTrace;
                int newB = b;  // B는 변하지 않음.
                if (newA < n) { // A 도둑이 경찰에 붙잡히지 않으려면 newA < n 이어야 함.
                    newDp[newB] = Math.min(newDp[newB], newA);
                }
                // Case 2: 물건 i를 B도둑이 훔침 → B 누적 흔적은 bTrace만큼 증가, A는 그대로.
                newA = dp[b];  // A는 변하지 않음.
                newB = b + bTrace;
                if (newB < m) { // B 도둑은 newB < m 이어야 함.
                    newDp[newB] = Math.min(newDp[newB], newA);
                }
            }
            dp = newDp;  // 다음 물건 처리를 위해 dp 업데이트
        }
        
        // 모든 물건을 처리한 후, 가능한 상태(dp[b] != INF) 중에서 A 누적 흔적의 최소값을 찾음.
        int answer = INF;
        for (int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[b]);
        }
        return (answer == INF) ? -1 : answer;
    }
    
}
