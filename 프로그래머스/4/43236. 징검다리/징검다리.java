import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 0;
        int right = 1000000000;
        while(left <= right){
            int mid = (left + right) / 2; // 거리의 최소값
            // mid가 가능한지 판단
            int p = 0;
            int removeCnt = 0;
            for(int i=0;i<rocks.length;i++){
                // mid가 사이값이 크면 돌 제거
                int diff = rocks[i] - p;
                if(mid > diff){
                    removeCnt++;
                }else{
                    p = rocks[i];
                }
            }
            if(mid > distance - p){
                removeCnt++;
            }
            
            if(removeCnt > n) { // 제거한 돌이 n을 넘으면 더 작은 수 탐색
                right = mid - 1;
            }else{
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        
        return answer;
    }
}