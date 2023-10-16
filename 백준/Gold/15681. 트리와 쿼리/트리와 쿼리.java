/**
 * 출력> 
 * 쿼리의 정점을 root로하는 서브쿼리 개수 구하기
 * 
 * 구현방법
 * 서브쿼리 = 정점개수
 * 1. DFS or BFS로 자신부터 자식까지의 정점 개수를 구한다 -> 시간 초과
 * 2. dp로 풀자 (dp + DFS or BFS)
 *   2-1. 무향 그래프에서 쿼리 q를 root로 했을 때 누가 자식이 되는지 구하기
 *    - root를 시작으로 DFS로 탐색하며 정점개수 구하기 - 동시에 메모라이징
 *    dfs(정점개수 누적) 
 *   2-2. DP 
 *    - dp 테이블 점화식 : dp[n] = dp[n의 자식 노드] +1;
 *    - dp 테이블 정의 : idx를 정점으로 하는 서브쿼리 개수
 */

import java.util.*;
import java.io.*;
public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        graph = new List[N+1];
        visited = new boolean[N+1];
        dp = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
    
        }
        
        dfs(0, R); // 루트부터 탐색하여 dp 배열을 채운다.
       
        
        for (int i = 0; i < Q; i++) {
        	int query = Integer.parseInt(br.readLine());
        	sb.append(dp[query]).append('\n');
        }
        System.out.println(sb);
        
    }
    private static void print() {
    	for (int v = 1; v < graph.length; v++) {
    		for (Integer node : graph[v]) {
        		System.out.print(node+" ");
			}
    		System.out.println();
			
		}
	}
    /**
     * 재귀 정의 : 현재 정점의 개수를 포함 ( +1)을 하고 자식노드로 이동
     *         재귀 후 빠져나오는 지점에 dp배열에 메모라이징
     * @param sum : root 부터 시작해 누적된 노드 수
     * @param v : 현재 정점 번호
     */
	private static void dfs(int sum, int v) {
        
		dp[v] = 1;
        boolean flag = false;
		visited[v] = true;
        for (Integer node: graph[v]) {
            if(visited[node])continue;
            else {
            	dfs(sum+1,node);
                dp[v] += dp[node];
            	flag = true;	
            }
        }
        if(!flag) {  // 리프노드 (기저조건)
        	return;
        }
        
    }

}