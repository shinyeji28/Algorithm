/*
* 그래프에서 원하는 만큼 간선을 삭제해, 서로 다른 크기의 트리 2개로 분할해보자!
*
* 트리 조건 : 사이클 존재 X, 간선 수 + 1 = 정점 수
*
* 가능 한 경우 조건
* 1. 주어진 트리 그룹 개수 2개 이하 (트리 그룹 개수 구하기(dfs))
* 2. 그룹이 2개 라면, 서로 다른 크기(정점 개수) 인지 확인 -> 출력
* 3. 그룹이 1개 라면, 정점이 2개가 아니면 -> 정점 1개(리프노드), 그 외로 분할 -> 출력
*    ** 스패닝 트리 만들기 : 사이클이 있는 간선 제거를 위해 크루스칼로 방문체크 하기 (dfs)
*       가중치가 없는 스패닝 트리 만들기 : 크루스칼(dfs/bfs)
*       가중치가 있는 스패닝 트리 만들기 : 프림 (union find)
* 그 외 -1출력
*
*
* */

import java.util.*;
import java.io.*;


public class Main {

    public static class Node{
        int idx;
        int to;
        public Node(int idx, int to){
            this.idx = idx;
            this.to =to;
        }
    }
    static List<Node>[] graph;
    static boolean[] visited;
    static List<int[]> group;
    static int n;
    static int leafNode;
    static List<Node> edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        if(n<=2) {
            System.out.println("-1");
            System.exit(0);
        }

        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        graph = new List[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(new Node(i, node2));
            graph[node2].add(new Node(i, node1));
        }

        // 그룹 개수 구하기
        group = new ArrayList<>(); // 그룹 노드 저장하기
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                int cnt = countGroup(i);
                group.add(new int[]{i, cnt});
            }
        }

        // 조건에 맞는지 검토 후 출력
        checkCondition();

        System.out.println(sb);

    }
    public static void checkCondition(){
        if(group.size()<=2){
            int[] group1 = group.get(0);
            if(group.size()==1){
                sb.append(group1[1]-1+" ").append(1).append('\n');

                // 트리 분리 (정점 1개(리프노드)와 그 외로 그룹을 나눔)
                findLeafNode(group1[0], new boolean[n+1]);  // 리프 노드 찾기

                edges = new ArrayList<>();
                edges.add(new Node(0, group1[0]));
                makeSpanningTree(group1[0], new boolean[n+1]);
                print();

                sb.append(leafNode).append('\n');

            }else if(group.size()==2 && group.get(0)[1] != group.get(1)[1]){
                int[] group2 = group.get(1);
                sb.append(group1[1]+" ").append(group2[1]).append('\n');

                // 사이클 제거를 위해 스패닝 트리로 출력
                edges = new ArrayList<>();
                edges.add(new Node(0, group1[0]));
                makeSpanningTree(group1[0], new boolean[n+1]);
                print();

                edges = new ArrayList<>();
                edges.add(new Node(0, group2[0]));
                makeSpanningTree(group2[0], new boolean[n+1]);
                print();
            }else{
                sb.append("-1");
            }
            return;
        }
        sb.append("-1");   // 분할 불가
    }
    public static void print(){
        edges.sort((a,b)->a.to-b.to);
        for(Node node : edges){
            sb.append(node.to+" ");
        }
        sb.append('\n');
        edges.sort((a,b)->a.idx-b.idx);
        for(Node node : edges){
            if(node.idx==0)continue;
            sb.append(node.idx+" ");
        }
        sb.append('\n');
    }
    public static void makeSpanningTree(int node, boolean[] visited){

        visited[node] = true;

        for(Node next : graph[node]){
            if(visited[next.to]) continue;
            if(leafNode!=next.to) edges.add(next);
            makeSpanningTree(next.to, visited);

        }
    }
    public static void findLeafNode(int node, boolean[] visited){

        boolean isLeaf = true;
        visited[node] = true;

        for(Node next : graph[node]){
            if(visited[next.to]) continue;
            isLeaf = false;
            findLeafNode(next.to, visited);

        }
        if(isLeaf){
            leafNode = node;
        }
    }
    public static int countGroup(int startNode){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(startNode);
        visited[startNode] = true;
        int injectionCnt = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            for(Node next : graph[node]){
                if(visited[next.to])continue;
                visited[next.to] = true;
                q.offer(next.to);
                injectionCnt++;
            }
        }
        return injectionCnt;
    }

}

