/**
 * 조건>
 * 얼리 아답터가 아닌 사람들은 자신의 모든 친구들이 얼리 아답터일 때만 이 아이디어를 받아들인다.
 * 트리
 * 출력 >
 * 모든 개인이 최소 아이디어를 수용하기 위해 필요한 최소 얼리 어답터의 수 구하기
 * 
 * 구현방법>
 * DFS + dp
 * n이 얼리어답터일 때 -> 자식은 얼리어답터여도 되고 아니여도 된다 - dp[0][rootNode] += 1 + Math(dp[0][childNode], dp[1][childNode]);
 * n이 얼리어답터가 아닐 때 -> 자식은 얼리어답터여야 한다.     - dp[1][rootNode] += dp[0][childNode];
 * 
 * dp : n을 root로 하는 얼리어답터 수
 * dp_얼리어답터 선정[n] : 정점 n이 얼리어답터일 때
 * dp_얼리어답터 미선정[n] : 정점 n이 얼리어답터가 아닐 때
 * 
 * 
 *
 */

import java.util.*;
import java.io.*;
public class Main {
	
	static List<Integer>[] graph;
	static int[][] dp;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
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

		dp = new int[2][N+1];
		dfs(1);

		System.out.println(Math.min(dp[0][1],dp[1][1]));
	}

	private static void dfs(int v) {
		visited[v] = true;
		
		dp[0][v] += 1;  // 얼리어답터 선정
		
		boolean flag = true;
		for (Integer node: graph[v]) {
			if(visited[node])continue;
			dfs(node);  // 자식노드로 넘기기
			dp[0][v] += Math.min(dp[0][node],dp[1][node]);  // 내가 얼리어답터면 자식은 얼리어답터여도 되고 아니여도 된다.-> 그중 작은 값을 뽑으면된다.
			dp[1][v] += dp[0][node];  // 내가 얼리어답터가 아닐때, 자식은 얼리어답터여야 한다.
			flag = false;
		}

		
		if(flag) {  // 리프노드
			dp[0][v] = 1;  // 얼리어다터 선정 선정
		}
		
	}

}