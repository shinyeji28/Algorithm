import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> sh = new HashMap<>();
        
        for(String[] c : clothes){
            sh.put(c[1], sh.getOrDefault(c[1], 0) +1);
        }
        int combination = 1;
        for(Map.Entry<String, Integer> s : sh.entrySet()){
            int num = 
            combination *= (s.getValue() +1);
        }
        
        return combination-1;
    }
}