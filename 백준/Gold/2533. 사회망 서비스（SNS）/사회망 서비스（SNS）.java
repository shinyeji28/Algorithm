/**
 * 조건>
 * 우수 마을로 선정된 주민 총합이 최대
 * 인접한 마을 모두 우수마을로 선정하는 것은 불가
 * 선정되지 못한 마을은 우수마을에 인접해야 함
 * 
 * 구현 방법>
 * 우수마을 - 미선정 - 우수마을 이런식으로 들쑥날쑥 했을 때 최대 주민 수 합
 * 트리 + dp
 * dp : idx를 정점번호로 하는 자식노드부터 해당 노드까지의 선정/미선정을 종합한 최대 주민수 합
 * dp_우수마을 선정[n] = dp_우수마을 미선정[n의 자식] + n정점의 주민 수
 * 출력 >
 * Max(dp_우수마을 선정[0], dp_우수마을 미선정[0])
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
//		print();
		
		// dp[0][n] : n을 우수마을로 선정
		// dp[1][n] : n을 우수마을로 미선정
		dp = new int[2][N+1];
		dfs(1);
//		System.out.println(Arrays.toString(dp[0]));
//		System.out.println(Arrays.toString(dp[1]));
		System.out.println(Math.min(dp[0][1],dp[1][1]));
	}
	private static void print() {
		for (int i = 1; i < graph.length; i++) {
			System.out.println(graph[i].toString());
		}
	}
	private static void dfs(int v) {
		visited[v] = true;
		
		dp[0][v] += 1;  // 우수마을 선정
		
		boolean flag = true;
		for (Integer node: graph[v]) {
			if(visited[node])continue;
			dfs(node);  // 자식노드로 넘기기
			dp[0][v] += Math.min(dp[0][node],dp[1][node]);  // 내가 얼리어답터면 자식은 얼리어답터여도 되고 아니여도 된다.-> 그중 작은 값을 뽑으면된다.
			dp[1][v] += dp[0][node];  // 내가 얼리어답터가 아닐때, 자식은 얼리어답터여야 한다.
			flag = false;
		}

		
		if(flag) {  // 리프노드
			dp[0][v] = 1;  // 우수마을 선정
		}
		
	}

}