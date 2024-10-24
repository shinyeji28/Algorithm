/*
    아이디어 : 1~1000000000에서 최소 시간 찾기 
    이분탐색으로 각 시간에서 모든 사람이 심사를 받을 수 있는지 판단하여 
        심사 가능 -> 더 작은 시간으로 찾기
        심사 불가능 -> 더 큰 시간으로 찾기
*/
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = 1000000000 * 1000000000L;
        long answer = right;

        long mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            
            // 심사 가능 여부 판단
            long num = 0;
            for(int i=0;i<times.length;i++){
                num += mid / times[i];
                if(num >= n)break;
            }
            if(num >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
}