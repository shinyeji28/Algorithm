import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] graph;
	static PriorityQueue<Node> q;
	static int[] phase; 
	static int[] strahler;
	static int[] input;
	public static class Node implements Comparable<Node>{
		int v;
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return o.w - this.w;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			graph = new List[M+1];
			phase = new int[M+1];  // 진입차수 저장
			strahler = new int[M+1];
			input = new int[M+1];
			for (int i = 1; i < M+1; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				phase[to]++;;
			}
			q = new PriorityQueue<Node>();
			for (int i = 1; i <= M; i++) {
				if(phase[i]==0) {
					q.offer(new Node(i,1));
					strahler[i] = 1;
				}
			}

			topologicalSorting();
			int max = 0;
			for (int i = 1; i <= M; i++) {
				max = Math.max(strahler[i], max);
			}
			sb.append(K+" "+max).append('\n');
		}
		System.out.println(sb);
	}
	private static void topologicalSorting() {
		Node cur;
		
		while(!q.isEmpty()) {	
			cur = q.poll();
			if(input[cur.v]>=2) strahler[cur.v]++;
			for(int to : graph[cur.v]) {
				phase[to]--;
				if(strahler[to] < strahler[cur.v]) {
					strahler[to] = strahler[cur.v];
					input[to] = 1;
				}else if(strahler[to] == strahler[cur.v]) {
					input[to]++;
					
				}
				if(phase[to] == 0) q.offer(new Node(to,strahler[to]));
			}
		}
	}
}