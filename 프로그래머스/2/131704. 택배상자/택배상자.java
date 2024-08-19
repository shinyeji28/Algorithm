// import java.util.*;
// class Solution {
//     public int solution(int[] order) {
//         int[] boxes = new int[order.length];
//         for(int i=0;i<boxes.length;i++){
//             boxes[order[i]-1] = i;
//         }
//         Stack<Integer> stack = new Stack<>();
//         int num = 1;
//         for(int box : boxes){
//             if(num!= box){
//                 stack.push(box);

//             }else{
                
//                 num++;
//             }
//            while(!stack.isEmpty() && stack.peek()==num){

//                 stack.pop();               
//                 num++;
//            }
            
//         }
//         while(!stack.isEmpty() && stack.peek()==num){

//                 stack.pop();               
//                 num++;
//            }
        
//         return num;
//     }
// }

import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;  
        
        for (int i = 1; i <= order.length; i++) {
            stack.push(i);
            
            while (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                index++;
            }
        }
        
        return index;
    }
}
