/*
* 구현 방법)
*  i : 1~N일 때 j(i<j) i~N , i시작노드 j끝노드 중복되지 않은 간선 수 세기
*  N = 300,000 O(N*N) -> 시간초과
*
*  해당 간선을 거치는 경우의 합 O(N)
*  전체에서 2개를 뽑는 경우의 수 (NC2) - (N - 서브 트리 노드 개수)에서 2개 뽑는 경우의 수
*                                    = 해당 간선을 거치는 경우
* */

import java.util.*;
import java.io.*;
public class Main {
    static List<Integer>[] graph;
    static int n;
    static int[] subTrees;
    static boolean[] visited;
    static long answer;
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        subTrees = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            graph[to].add(from);
            graph[from].add(to);
        }

        dfs(1);

        System.out.println(answer);
    }
    public static int dfs(int node){
        // 자식 노드 개수 구하기
        visited[node] = true;
        int subTreeContainMe = 1;
        for(Integer next : graph[node]){
            if(visited[next])continue;
            subTreeContainMe += dfs(next);
        }
        if(node!=1)answer += combination(n) - combination(n-subTreeContainMe);
        return subTreeContainMe;
    }
    // nC2
    public static long combination(int cnt){
        return (long) cnt * (cnt-1) / 2;
    }
}