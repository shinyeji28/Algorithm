/*
* 다익스트라
* 왕복 = 각 노드에서 목표지까지 최단 거리 + 목표지에서 본인 노드까지 최단 거리
* 최대 비용이 걸리는 노드의 비용 출력
* */
import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int to;
        int cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static List<Node>[] map;
    static int n;
    static int[] roundTrip;
    static int[] distance;
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        map = new List[n+1];
        roundTrip = new int[n+1];
        for(int i=1;i<=n;i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[from].add(new Node(to,cost));
        }

        // 파티에 갈 최단 경로
        for(int i=1;i<=n;i++){

            dijkstra(i,x);
            if(i==x){
                for(int j=1;j<=n;j++){
                    roundTrip[j] += distance[j];
                }
                continue;
            }
            roundTrip[i] += distance[x];

        }
        int result = 0;
        for(int i=1;i<=n;i++){
            if(i!=x) result = Math.max(result, roundTrip[i]);
        }

        System.out.println(result);
    }
    public static void dijkstra(int start, int x){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node->node.cost));
        boolean[] visited = new boolean[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            int cost = cur.cost;
            if(visited[node]) continue;
            visited[node] = true;

            for(Node nextNode: map[node]){
                int nNode = nextNode.to;
                int nCost = cost + nextNode.cost;
                if(distance[nNode]>nCost) {
                    distance[nNode] = nCost;
                    pq.offer(new Node(nNode, nCost));
                }
            }
        }
    }
}