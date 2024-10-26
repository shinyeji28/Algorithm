import java.util.*;
class Solution {

    static List<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        answer = dijkstra(n);
        return answer;
    }
    public static int dijkstra(int n){
        Queue<Integer> q= new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        q.offer(1);
        visited[1] = true;
        
        int size = 0;
        while(!q.isEmpty()){
            size = q.size();
            for(int s=0;s<size;s++){
                int cur = q.poll();
                for(int next : graph[cur]){
                    if(visited[next])continue;
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return size;
    }
}