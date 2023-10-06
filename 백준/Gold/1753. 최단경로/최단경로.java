import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static List<Node>[] graph;
	static boolean[] visited;
	static int[] distance;
	
	public static class Node implements Comparable<Node>{
		int v;
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken()); 
		st = new StringTokenizer(br.readLine());
		
		graph = new List[V+1];
		visited = new boolean[V+1];
		distance = new int[V+1];
		
		for (int i = 1; i < V+1; i++) {
			graph[i] = new ArrayList<Node>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		int start = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[from].add(new Node(to,w));
		}
		
		
		dijstra(start);
		for (int i = 1; i < V+1; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
		
	}
	private static void dijstra(int start) {
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		distance[start] = 0;
		q.offer(new Node (start, distance[start]) );
		
		while(!q.isEmpty()) {

			Node cur = q.poll();
			visited[cur.v] = true;
			
			for (Node node : graph[cur.v]) {
				if(visited[node.v]) continue;
				if(distance[node.v] > distance[cur.v] + node.w) {
					distance[node.v] = distance[cur.v] + node.w;
					q.offer(new Node (node.v, distance[node.v]) );
				}
			}
		}
	}

}