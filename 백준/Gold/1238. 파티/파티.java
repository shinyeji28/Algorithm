import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int to;
        int cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static List<Node>[] graph;
    static int n;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to,cost));
        }

        int[] totalCost = new int[n+1];
        for(int i=1;i<=n;i++){
            int[] dis = bfs(i);
            totalCost[i] += dis[x];
            if(i==x){
                for(int j=1;j<n+1;j++){
                    totalCost[j] += dis[j];
                }
            }
        }

        int result = 0;
        for(int i=1;i<=n;i++){
            result = Math.max(result, totalCost[i]);
        }
        System.out.println(result);
    }
    public static int[] bfs(int from){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.offer(new Node(from, 0));
        distance[from] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int to = cur.to;
            if(visited[to])continue;
            visited[to] = true;
            for(Node next : graph[to]){
                if(distance[next.to] > distance[to] + next.cost){
                    distance[next.to] = distance[to] + next.cost;
                    pq.offer(new Node (next.to, distance[next.to]));
                }

            }
        }


        return distance;
    }
}