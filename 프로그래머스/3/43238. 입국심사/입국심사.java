import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        
        long left = 1L;
        long right = 1000000000L * 100000L;
        long answer = right;
        while(left <= right){
            long mid = (left + right) / 2L;
            long complete = 0L;
            for(int t : times){
                complete += mid / (long)t;
            }
            if(complete < n){
                left = mid + 1L;
            }else {
                right = mid - 1L;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }
}