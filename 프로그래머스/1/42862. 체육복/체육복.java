import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        boolean[] reserves = new boolean[n+1];
        boolean[] complete = new boolean[n+1];
        for(int r : reserve){
            reserves[r] = true;
        }

        Arrays.sort(lost);
        
        for(int stu : lost){
            if(reserves[stu]){
                reserves[stu] = false;
                answer++;
                complete[stu] = true;
            }
        }
        
        for(int stu : lost){
            
            if(complete[stu]) continue;

            else if((stu -1) > 0 && reserves[stu-1]){
                reserves[stu-1] = false;
                answer++;
            }
            else if((stu +1) <= n && reserves[stu+1]){
                reserves[stu+1] = false;
                answer++;
            }
        }
        return answer + (n - lost.length);
    }
}