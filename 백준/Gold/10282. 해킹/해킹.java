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
    static int N;
    static int totalTime, totalComputer;
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t =0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];

            for(int i=1;i<=N;i++){
                graph[i] = new ArrayList<>();
            }

            totalTime = 0;
            totalComputer = 0;

            for(int d=0;d<D;d++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new Node(a,s));
            }
            bfs(C);
            System.out.println(totalComputer+" "+totalTime);
        }
    }
    public static void bfs(int c){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        boolean[] visited = new boolean[N+1];
        pq.offer(new Node(c,0));
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[c] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int from = cur.to;

            if(visited[from])continue;
            visited[from] = true;
            totalComputer++;

            for(Node node : graph[from]){

                if(distance[node.to] <= distance[from] + node.cost)continue;
                distance[node.to] = distance[from] + node.cost;
                pq.offer(new Node(node.to, distance[node.to] ));

            }
        }
        for(int i=1;i<=N;i++){
            if(distance[i]==Integer.MAX_VALUE)continue;
            totalTime = Math.max(distance[i], totalTime) ;
        }

    }
}