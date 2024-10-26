import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> completionHash = new HashMap<>();
        
        for(String c : completion){
            completionHash.put(c, completionHash.getOrDefault(c, 0) + 1);
        }
        for(String p : participant){
            if(completionHash.get(p)!=null && completionHash.get(p)!=0){
                completionHash.put(p, completionHash.get(p)-1);
            }else{
                answer = p;
                break;
            }
        }
        
        return answer;
    }
}