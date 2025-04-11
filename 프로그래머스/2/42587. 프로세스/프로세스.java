import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> cnts = new PriorityQueue<>((a,b)->b-a);
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> temp = new ArrayDeque<>();

        for(int i=0;i<priorities.length;i++){
            q.offer(new int[]{priorities[i], i});
            cnts.offer(priorities[i]);
        }
        
        while(!cnts.isEmpty()){
            int priority = cnts.poll();
            int[] process = q.poll();
            if(priority == process[0]){
                answer++;
                if(process[1] == location)break;
            }else{
                q.offer(new int[]{process[0], process[1]});
                cnts.offer(priority);
            }
        }
        return answer;
    }
}