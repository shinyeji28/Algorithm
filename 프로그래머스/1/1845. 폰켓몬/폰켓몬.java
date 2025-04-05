import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int n : nums){
            hs.add(n);
        }
        answer = hs.size();
        if(answer>nums.length/2){
            answer = nums.length/2;
        }
        
        return answer;
    }
}