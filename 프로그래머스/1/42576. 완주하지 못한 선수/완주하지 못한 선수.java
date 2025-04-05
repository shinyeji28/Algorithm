import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = ""; 
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(String c : completion){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        for(String p : participant){
            if(!hm.containsKey(p)){
                answer = p;
                break;
            }
            int value = hm.get(p);
            if(value == 1){
                hm.remove(p);
            }else{
                hm.replace(p,value-1);
            }
        }
        return answer;
    }
}