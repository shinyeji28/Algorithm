import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        stack.push(number.charAt(0));
        
        int i = 1;
        A: for(i=1;i<number.length();i++){
            char c = number.charAt(i);
            while(k>0 && !stack.isEmpty() && stack.peek() < c){
                stack.pop();
                k--;
                if(k <=0)break A;
            }
            stack.push(c);

        }
        while(!stack.isEmpty()){
            answer = stack.pop() + answer;
        }
        answer += number.substring(i, number.length()); 
        answer = answer.substring(0, answer.length()-k); 
    

        return answer;
    }
}