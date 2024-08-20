
import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int[] boxes = new int[order.length];
        for(int i=0;i<order.length;i++){
            boxes[order[i]-1] = i;
        }
        int num = 0;
        for(int box : boxes){
            stack.push(box);
            while(!stack.isEmpty() && stack.peek() == num){
                stack.pop();
                num++;
            }
        }
        
        return num;
    }
}
