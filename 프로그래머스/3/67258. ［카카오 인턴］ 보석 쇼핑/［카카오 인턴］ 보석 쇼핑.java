import java.util.*;
class Solution {
    static int dis;
    static int[] answer;
    public int[] solution(String[] gems) {
        answer = new int[2];
        HashSet<String> types = new HashSet<>();
        HashMap<String, Integer> gets = new HashMap<>();
        
        for(String g : gems){
            types.add(g);
        }
        int size = types.size();
        
        
        int left = 0;
        int right = 0;
        dis = gems.length+1;
    
        while(left < gems.length ){
            while(right < gems.length && gets.size() < size){
                gets.put(gems[right], gets.getOrDefault(gems[right],0)+1);
                right++;
            }

            if(gets.size() == size)update(left, right-1);

            int leftValue = gets.get(gems[left]);
            if(leftValue == 1){
                gets.remove(gems[left]);
            }else gets.put(gems[left], leftValue-1);
            

            left++;

        }
        
        
        return answer;
    }
    public static void update(int left , int right){
        if(dis > right-left+1){
            dis = right-left+1;
            answer[0] = left+1;
            answer[1] = right+1;
        }
    }
}