/**
 * 
 * 도둑루피 - 루피 감소
 * [N-1],[N-1]까지 이동 했을 때 최소로 잃는 금액 구하기
 * 
 * 
 * 구현
 * 양의 가중치가 있는 최소 비용 구하기 - 다익스트라  
 *         
 *
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {-1,1,0,0};
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true) {
			 st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 if(N==0)break;
			 map = new int[N][N];
			 visited = new boolean[N][N];
			 for (int i = 0; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			 }
			 int distance = bfs_pq();
			 sb.append("Problem "+ (t++) + ": "+ distance).append('\n');
			 
		}
		System.out.println(sb);
	}

	private static int bfs_pq() {
		PriorityQueue<Node> q = new PriorityQueue<>();             // 가장 작은 가중치를 뽑아내기 때문에 목적지에 도착할 때 그 값이 최소 가중치 합이다.
		q.offer(new Node(0,0,map[0][0]));
		visited[0][0] = true;
		
		Node cur;
		int nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(cur.x==N-1 && cur.y==N-1)return cur.d;
			
			for (int d = 0; d < dx.length; d++) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				
				if(visited[nx][ny])continue;
				q.offer(new Node(nx,ny,cur.d+map[nx][ny]));  // pq로 인해 가장 작은 distance란 것이 보장됨
				visited[nx][ny] = true;
			}
		}
		return 0;
		
	}
	
	private static class Node implements Comparable<Node>{
		int x;
		int y;
		int d;
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.d - o.d;
		}

		
	}
	
	
}