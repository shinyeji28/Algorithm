/*
특정 시간 동안 알람 울린 횟수 구하기
(초침 == 시침 || 초침 == 분침) 일때 알람 울림
*/

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int cnt = 0;
        
        double endTime = h2 * 3600 + m2 * 60 + s2;
        double startTime = h1 * 3600 + m1 * 60 + s1; 
        
        if(startTime == 0 || startTime == 12 * 60 * 60) cnt++;
        
        while(startTime < endTime){
            double s = startTime * 6 % 360;
            double m = startTime / 10 % 360;
            double h = startTime / 120 % 360;
            
            double ns = calc((startTime + 1) * 6 % 360);
            double nm = calc((startTime + 1) / 10 % 360);
            double nh = calc((startTime + 1) / 120 % 360);
    
            if(s < m && ns >= nm) cnt++;
            if(s < h && ns >= nh) cnt++;
            if(ns == nm && ns == nh) cnt--;
            
            startTime++;
        }

        
        return cnt;
    }
    
    // 다음 시 분 초가 현재 보다 작을 수 없기 때문
    public static double calc(double x){
        if(x == 0) return 360;
        return x;
    }
}