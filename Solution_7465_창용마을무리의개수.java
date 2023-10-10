package algo;

/**
 * DFS 탐색하여 연결될 수 있는 관계를 연결 
 * 기저조건에서 무리++
 * 
 * @author SSAFY
 *
 */
import java.util.*;
import java.io.*;
public class Solution_7465_창용마을무리의개수_신예지 {
	
	static int cnt,N;
	static List<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			graph = new List[N+1];
			visited = new boolean[N+1];
			for (int i = 1; i < N+1; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				graph[to].add(from);
			}
			cnt = 0;
			for (int i = 1; i <= N; i++) {
				if(visited[i]==false) {
					dfs(i);				
					cnt++;
				}
			}
			sb.append("#"+t+" "+cnt).append('\n');
		}
		System.out.println(sb);
	}

	private static void dfs(int cur) {
		if(visited[cur])return;
		visited[cur] = true;
		
		for (int node:graph[cur]) {
			dfs(node);	
		}
	}
}
