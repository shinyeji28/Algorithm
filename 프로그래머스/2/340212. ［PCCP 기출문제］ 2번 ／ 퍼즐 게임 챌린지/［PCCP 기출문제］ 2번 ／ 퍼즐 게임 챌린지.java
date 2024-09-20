// 누적합
// 이분탐색

import java.util.*;
class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        long answer = Long.MAX_VALUE;
        
        long[] sumTime = new long[times.length];
        
        sumTime[0] = times[0];
        for(int i=1;i<times.length;i++){
            sumTime[i] = times[i-1] + times[i];
        }
        
        long left = 0;
        long right = Long.MAX_VALUE;
        long mid = 0;
        while(left<=right){
            mid = (left + right) / 2;  // 숙련도
            // 시간 구하기
            long time = 0;
            boolean flag = false;
            for(int i=0;i<diffs.length;i++){
                if(diffs[i] <= mid) time += times[i];
                else time += sumTime[i]*(diffs[i] - mid) + times[i];
                if(time > limit){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                if(mid!=0)answer = Math.min(mid, answer);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }
}