import java.util.*;
class Solution {
    public int solution(int storey) {
        
        int cnt = 0;
        while(storey>0){
            int curNum = storey % 10;
            int nextNum = storey / 10;
            if(curNum > 5 || (curNum==5 && nextNum % 10 >= 5)){
                cnt += 10 - curNum;
                storey += 10 - curNum; 
            }else{
                cnt += curNum;
            }
            storey /= 10;
        }
        return cnt;
    }
}