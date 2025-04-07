import java.util.*;
class Solution {
    static List<Node>[] graph;
    public static class Node{
        int to;
        int v;
        public Node(int to, int v){
            this.to = to;
            this.v = v;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
       graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] cost : costs){
            graph[cost[0]].add(new Node(cost[1],cost[2]));
            graph[cost[1]].add(new Node(cost[0],cost[2]));
        }
        
        answer = bfs(n);
        
        
        return answer;
    }
    public static int bfs(int n){
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.v-b.v);
        boolean[] visited = new boolean[n];
        
        q.offer(new Node(0,0));
        int sum = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            int to = node.to;
            int v = node.v;
            if(visited[to])continue;
            visited[to] = true;
            sum += v;
            for(Node next : graph[to]){
                q.offer(new Node(next.to, next.v));

            }
        }
        return sum;
    }
}