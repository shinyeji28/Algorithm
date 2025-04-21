
import java.util.*;
/*
stack : peek가 arr보다 낮으면 pop
*/
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        ArrayDeque<Character> q = new ArrayDeque<>();
        for(int i=0;i<number.length();i++){
            char num = number.charAt(i);
            
            while(!q.isEmpty() && q.peekLast() < num && k > 0){
                q.pollLast();
                k--;
            }
            q.offerLast(num);
        }
        while(!q.isEmpty() && k>0){
            q.pollLast();
            k--;
        }
        while(!q.isEmpty()){
            answer += q.pollFirst();
        }
        return answer;
    }
}