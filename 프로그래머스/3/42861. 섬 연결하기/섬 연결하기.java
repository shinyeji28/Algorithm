import java.util.*;
/*
최소 신장 트리 - 프림 알고리즘 : PQ, 인접 간선만 넣기(BFS) 
*/
class Solution {
    static class Node{
        int to; 
        int cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static List<Node>[] graph;
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
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        boolean[] visited = new boolean[n];
        
        int total = 0;
        
        pq.offer(new Node(0,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            int cost = cur.cost;
            if(visited[node])continue; 
            visited[node] = true;
            total += cost;

            for(Node next : graph[node]){
                pq.offer(new Node(next.to,next.cost));
            }
        }
        return total;
    }
}