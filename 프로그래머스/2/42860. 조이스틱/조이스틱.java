import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // A가 아닌 것들의 상하 조정 횟수 기록
        for(int i=0;i<name.length();i++){
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        // 연속된 A를 찾아 양끝을 활용
        
        int movingCnt = name.length()-1;
        for(int left=0;left<name.length();left++){
            int right = left+1;
            while(right < name.length() && name.charAt(right)=='A'){  // 연속된 A 범위
                right++;
            }
            // 연속A의 시작 + len - 연속 A의 끝 + (돌아오는 것)
            movingCnt = Math.min(movingCnt, left + name.length() - right + Math.min(left, name.length()-right));
        }
        
        return answer + movingCnt;
    }
}