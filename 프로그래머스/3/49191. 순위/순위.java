/*
 연결된 진입 차수 + 연결된 진출 차수 = n -1 이면 순위를 매길 수 있음 
 진입 차수는 역방향 그래프로 계산
*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Integer>[] graph = new ArrayList[n+1];
        List<Integer>[] reverseGraph = new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();

        }
        for(int[] re : results){
            graph[re[0]].add(re[1]);
            reverseGraph[re[1]].add(re[0]);
        }
        
        for(int i=1;i<=n;i++){
            int cnt = bfs(graph, i) + bfs(reverseGraph, i);  // 진출차수 + 진입차수
            if(cnt == n+1)answer++;
        }

        return answer;
    }
    // 연결된 개수 세기
    public static int bfs(List<Integer>[] graph, int from){
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        
        q.offer(from);
        visited[from] = true;
        
        while(!q.isEmpty()){
            int to = q.poll();
            cnt++;
            for(int next : graph[to]){
                if(visited[next])continue;
                q.offer(next);
                visited[next] = true;
            }
        }
        return cnt;
    }
}