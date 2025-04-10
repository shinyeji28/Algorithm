import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> cnts = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<progresses.length;i++){
            int dday = 100-progresses[i];
            if(dday!=0) dday = (int)Math.ceil((double)dday/(double)speeds[i]);
            q.offer(dday);
        }
        while(!q.isEmpty()){
            int day = q.poll();
            int cnt = 1;
            while(!q.isEmpty() && q.peek() <= day){
                cnt++;
                q.poll();
            }
            cnts.add(cnt);
        }
        int[] answer = new int[cnts.size()];
        for(int i=0;i<cnts.size();i++){
            answer[i] = cnts.get(i);
        }
        
        return answer;
    }
}