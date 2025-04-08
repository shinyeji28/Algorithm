import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        boolean[] done = new boolean[routes.length];
        PriorityQueue<int[]> start = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<int[]> end = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<routes.length;i++){
            int[] route = routes[i];
            start.offer(new int[]{route[0],i});
            end.offer(new int[]{route[1],i});
        }
        
        int cnt = 0;
        while(!end.isEmpty()){
            int[] e = end.poll();
            int ep = e[0];
            int epIdx = e[1];
            if(done[epIdx])continue;
            cnt++;
            while(!start.isEmpty() && start.peek()[0] <= ep){
                int[] s = start.poll();
                int spIdx = s[1];
                done[spIdx] = true;

            }
        }
        
        return cnt;
    }
}