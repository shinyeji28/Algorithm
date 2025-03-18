/*
난이도 > 숙련도 : ( curTime + preTime ) * 틀릴 수(난이도-레벨) + curTime 의 시간을 사용


*/

class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        long answer = limit;
        
        long left = 1;
        long right = limit;
        long mid = 1;
        while(left <= right){
            mid = (left + right) / 2;
            long time = calcTime(mid, diffs, times, limit);
            if(time <= limit){
                right = mid - 1;
                answer = Math.min(answer, mid);
            }else left = mid + 1;
            
        }
        return answer;
    }
    public static long calcTime(long level, int[] diffs, int[] times, long limit){
        long time = 0;
        
        for(int i=0;i<diffs.length;i++){
            if(diffs[i]<=level){
                time += times[i];
            }else{
                long wrongCnt = diffs[i] - level;
                time += (times[i] + times[i-1]) * wrongCnt + times[i];
            }
            if(time > limit) return limit+1;
        }
        
        return time;
    }
}