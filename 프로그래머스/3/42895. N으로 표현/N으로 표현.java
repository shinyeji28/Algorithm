
import java.util.*;
class Solution {
    public int solution(int N, int number) {
        
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i=0;i<=8;i++){
            dp.add(new HashSet<>());
        }
        
        for(int i=1;i<=8;i++){
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        

        
        for(int i=1;i<=8;i++){
            for(int j=1;j<i;j++){
                for(Integer a : dp.get(j)){
                    for(Integer b : dp.get(i-j)){
                    
                        dp.get(i).add(a - b);
                        dp.get(i).add(a + b);
                        dp.get(i).add(a * b);
                        if(b!=0)dp.get(i).add(a / b);
                    }
                }

            }
                            
            if(dp.get(i).contains(number)){
                return i;
            }
        }
        return -1;

        
    }
}