import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        
        int[] count = new int[e+1];
        for(int i=1;i<=e;i++){
            for(int j=1;j<=e/i;j++){
                count[i*j]++;
            }
            
        }
        
        int[] result = new int[e+1];
        int maxIdx = e;
        for(int i=e;i>=1;i--){
            int k = maxIdx;
            int v = count[k];
            if(count[i] > v){
                maxIdx = i;
            }else if(count[i] == v && i < k){
                maxIdx = i;
            }
            
            result[i] = maxIdx;
        }

        for(int i=0;i<starts.length;i++){
            answer[i] = result[starts[i]];
        }
        
        return answer;
    }
}