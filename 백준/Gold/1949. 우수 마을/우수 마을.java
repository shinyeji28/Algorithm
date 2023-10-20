/**
 * 조건>
 * 우수 마을로 선정된 주민 총합이 최대
 * 인접한 마을 모두 우수마을로 선정하는 것은 불가
 * 선정되지 못한 마을은 우수마을에 인접해야 함
 * 
 * 구현 방법>
 * 우수마을 - 미선정 - 우수마을 이런식으로 들쑥날쑥 했을 때 최대 주민 수 합
 * 트리 + dp
 * 내가 선정되면 - 반드시 자식은 선정되면 안된다  - dp[0][n] += 
 * 내가 선정되지 않으면 - 자식중 하나 이상이 선정되야 된다 - 
 */

import java.util.*;
import java.io.*;
public class Main {
	
	static int[] popul;
	static List<Integer>[] graph;
	static int[][] dp;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		popul = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		graph = new List[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
//		print();
		
		// dp[0][n] : n을 우수마을로 선정
		// dp[1][n] : n을 우수마을로 미선정
		dp = new int[2][N+1];
		dfs(1);
		
		System.out.println(Math.max(dp[0][1],dp[1][1]));
	}
	private static void print() {
		for (int i = 1; i < graph.length; i++) {
			System.out.println(graph[i].toString());
		}
	}
	private static void dfs(int v) {
		visited[v] = true;
		
		boolean flag = true;
		
		dp[0][v]+=popul[v];
		
		for (Integer node: graph[v]) {
			if(visited[node])continue;
			dfs(node);  // 자식노드로 넘기기
			dp[0][v] += dp[1][node];
			dp[1][v] += Math.max(dp[0][node], dp[1][node]);
		
			flag = false;
		}

		if(flag) {  // 리프노드
			dp[0][v] = popul[v];  // 우수마을 선정
		}
		
	}

}