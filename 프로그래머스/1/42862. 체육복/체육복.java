/*
왼쪽먼저 빌려주기
lost와 reserve 둘 다 있는 수는 제거하기

*/
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int cnt = 0;
        boolean[] notAble = new boolean[n+1];  // 체육복이 없는 학생 true
        boolean[] notReserve = new boolean[reserve.length];
        for(int l : lost){
            notAble[l] = true;
            cnt++;
        }
        for(int i=0;i<reserve.length;i++){
            if(notAble[reserve[i]]){
                cnt--;
                notReserve[i] = true;
                notAble[reserve[i]] = false;
            }        
        }
        for(int i=0;i<reserve.length;i++){
            int r = reserve[i];
            if(notReserve[i]) continue;
            if(r-1>=0 && notAble[r-1]){
                cnt--;
                notAble[r-1] = false;
            }else if(r+1<n+1 && notAble[r+1]){
                cnt--;
                notAble[r+1] = false;
            }
        }
        
        
        return n-cnt;
    }
}