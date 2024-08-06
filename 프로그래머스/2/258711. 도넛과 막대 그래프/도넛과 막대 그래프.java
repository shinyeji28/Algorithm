// 도넛 : 사이클 1개 , 정점 수 == 간선 수
// 막대 : 사이클 X , 정점 수 == 간선 수 +1
// 8자 : 사이클 2개 , 2 * 정점수 +2 (홀수) = 2 * 간선 수 +1 

// 새로운 노드 조건
    // 진입 차수가 0인 것들이 new node의 후보
    // 이중 가장 간선 수가 많은 것이 새로운 노드
// dfs를 통해 정점 수와 간선 수를 비교하고 사이클 여부 판단
    // dfs depth 1 인것 부터 시작

import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int[] inNode;
    static int cycle;
    static int[] count = new int[3];
    static boolean[] visited;
    static int nCnt, eCnt;
    public int[] solution(int[][] edges) {
        
        int n = edges.length;
        
        for(int i=0;i<edges.length;i++){
            n = Math.max(Math.max(n,edges[i][0]),edges[i][1]);
        }
        
        graph = new ArrayList[n+1];
        inNode = new int[n+1];
        for(int i=1;i<n+1;i++){
            graph[i] = new ArrayList<>(); 
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            inNode[edge[1]]++;
        }
        int maxEdge = 0;
        int newNode = 0;
        for(int i=1;i<n+1;i++){
            if(inNode[i] == 0){
                if(maxEdge < graph[i].size()){
                    maxEdge = graph[i].size();
                    newNode = i;
                }
            }
        }
        visited = new boolean[n+1];

        for(int i=1;i<n+1;i++){
            if(inNode[i] == 0 && !visited[i]&& newNode!=i){
                for(Integer g : graph[i]){
                    cycle = 0;
                    nCnt = 0;
                    eCnt = 0;
                    dfs(g);   
                } 
            }
        }
        for(Integer g : graph[newNode]){
            if(visited[g])continue;
            cycle = 0;
            nCnt = 0;
            eCnt = 0;
            dfs(g);   
        } 
        
        return new int[]{newNode, count[0], count[1], count[2]};
    }

    public static void dfs(int node){
        Queue<Integer> q = new ArrayDeque<>();
        visited[node] = true;
        q.offer(node);

        while(!q.isEmpty()){
            int cNode = q.poll();
            nCnt++;
            eCnt += graph[cNode].size();
            for(Integer g : graph[cNode]){
                if(visited[g]){
                    cycle++;
                    continue;
                }
                visited[g] = true;
                q.offer(g);
            }
            
        }
        if(cycle == 1 && nCnt==eCnt) count[0]++;
        if(cycle == 0 && nCnt==eCnt+1)count[1]++;
        if(cycle == 2 && nCnt%2 ==1 && nCnt!=1 && nCnt+1==eCnt)count[2]++;
    }
}