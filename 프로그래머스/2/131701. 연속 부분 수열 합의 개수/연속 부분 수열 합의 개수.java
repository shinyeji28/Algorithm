import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> sh = new HashSet<>();
        int[] sum = new int[elements.length*2-1];
        sum[0] = elements[0];
        sh.add(sum[0]);

        for(int i=1;i<sum.length;i++){
            sum[i] = sum[i-1] + elements[i%elements.length];
            if(i/elements.length<=0) {
                sh.add(sum[i]);
            }
        }
        
        for(int i=0;i<elements.length;i++){
            for(int j=i+1;j<elements.length + i;j++){
                sh.add(sum[j] - sum[i]);
            }
        }

        return sh.size();
    }
}
