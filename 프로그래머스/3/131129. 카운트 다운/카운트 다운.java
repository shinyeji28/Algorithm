/* dp */
import java.util.*;
class Solution {
    public int[] solution(int target) {
        
        int[] dpRound = new int[target+1];
        int[] dpSingleBall = new int[target+1];
        List<Integer> scores = new ArrayList<>(); 
        
        Arrays.fill(dpRound, Integer.MAX_VALUE);
        dpRound[0] = 0;
        
        for(int i=1;i<=20;i++){
            
            scores.add(i);
            scores.add(i*2);
            scores.add(i*3);
            if(i<=target) dpRound[i] = 1;
            if(i*2<=target) dpRound[i*2] = 1;
            if(i*3<=target) dpRound[i*3] = 1;

        }
        scores.add(50);
        if(50<=target) dpRound[50] = 1;



        
        for(int i=1;i<=target;i++){
            for(int score : scores){
                if(i>=score){
                    int tempRound = dpRound[i-score] + 1;
                    int tempSingleBall = dpSingleBall[i-score] + ((score<=20 || score==50)?1:0);
                    
                    if(tempRound < dpRound[i]){
                        dpRound[i] = tempRound;
                        dpSingleBall[i] = tempSingleBall;
                    }else if(tempRound == dpRound[i] && tempSingleBall > dpSingleBall[i]){
                         dpSingleBall[i] = tempSingleBall;
                    }
                }
                
            }
        }


        return new int[]{dpRound[target],dpSingleBall[target]};
    }
}