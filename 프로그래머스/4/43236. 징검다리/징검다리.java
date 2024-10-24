/*
    아이디어 : 거리의 최소값을 이분탐색으로 찾아 가능 여부 탐색
    mid가 최소값이 되기 위해서는 거리의 차가 mid보다 모두 커야함
    mid보다 거리의차가 작으면 바위 제거
    n개만큼 바위를 제거했는데도 mid보다 작은 것이 있다면 mid를 늘려야함
*/
import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = Integer.MIN_VALUE;
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        while(left<=right){
            int mid = left + (right - left)/2;
            // 판단
            if(isValid(rocks, mid, n, distance)){
                answer = Math.max(mid, answer);
                left = mid + 1;

            }else{
                right = mid - 1;
            }
            
        }
        
        return answer;
    }
    public static boolean isValid(int[] rocks, int mid, int n, int distance){
        int prev = 0;
        for(int r : rocks){
            
            int diff = r - prev;
        
            if(diff < mid){
                if(n == 0) return false;
                n--;
            }else {
                prev = r;
            }

        }
        // 마지막 바위와 도작지점 사이 측정
        int diff = distance - prev;
        if(diff < mid){
            if(n == 0) return false;
            n--;
        }
        return true;
    }
}