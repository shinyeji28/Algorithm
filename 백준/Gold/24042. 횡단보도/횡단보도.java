/*
* N 100,000 , M 700,000
* 1. List<Node>[] graph선언 ( Node 멤버변수 : to, time)
* 2. 가중치가 있는 다익스트라로 최단 루트 찾기 (PQ : 시간 초가 짧은 것을 우선)

*
* */
import java.util.*;
import java.io.*;
public class Main{
    public static class Node{
        int to;
        long time;
        public Node(int to, long time){
            this.to = to;
            this.time = time;
        }
    }
    static List<Node>[] graph;
    static int N;
    static int M;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(new Node(node2, i));
            graph[node2].add(new Node(node1, i));
        }

        //1부터 시작
        System.out.println(dijkstra());
    }
    public static long dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Long.compare(a.time, b.time));
        boolean[] visited = new boolean[N+1];
        long[] distance = new long[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;
        pq.offer(new Node(1, 0)); // node , time
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            long time = cur.time;
            if(node == N){
                return time;
            }
            if(visited[node])continue;
            visited[node] = true;
            for(Node next : graph[node]){
                // time 구하기
                long nextTime;
                if((time % M ) < next.time){
                    nextTime = time + (next.time - (time % M ));

                }else{
                    nextTime = time + (M - (time % M )) + next.time;
                }
                // 최소 값 갱신
                if(distance[next.to] > nextTime){
                    distance[next.to] = nextTime;
                    pq.offer(new Node(next.to, nextTime));
                }
            }
        }
        return 0;
    }
}