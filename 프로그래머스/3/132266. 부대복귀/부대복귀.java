// 다익스트라
import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        List<Integer>[] map = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            map[i] = new ArrayList<>();
        }
        for(int[] r : roads){
            map[r[0]].add(r[1]);
            map[r[1]].add(r[0]);
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
            
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];

        q.offer(destination);
        visited[destination] = true;
        distance[destination] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : map[cur]){
                if(visited[next])continue;
                if(distance[next] > distance[cur] + 1){
                    distance[next] = distance[cur] + 1;
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        
        
        for(int i=0;i<sources.length;i++){
            answer[i] = distance[sources[i]];
            if(answer[i] == Integer.MAX_VALUE)answer[i] = -1;
        }
        
    
        return answer;
    }
    
}