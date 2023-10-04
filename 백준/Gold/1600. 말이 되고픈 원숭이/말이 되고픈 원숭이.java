/**
 * BFS
 * Node(x,y, k를 사용한 횟수, 움직인 횟수)
 * visited : 3차원 배열 (k = 0, 1 ... k번)
 * 
 * @author SSAFY
 *
 */
import java.util.*;
import java.io.*;
public class Main {
	
	static int K,H,W;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = new int[] {1,-1,0,0};                  // 사방탐색
	static int[] dy = new int[] {0,0,1,-1};
	static int[] horseDx = new int[] {-1,-2,-2,-1,1,2,2,1};  // 말의 이동방법
	static int[] horseDy = new int[] {-2,-1,1,2,-2,-1,1,2};
	
	public static class Node {
		int x;
		int y;
		int k;    // 남은 말의 움직임
		int move;  // 움직인 횟수
		public Node(int x, int y, int k, int move) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.move = move;
		}
		
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W]; 
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(map[0][0] == 1 || map[H-1][W-1]==1) {
			System.out.println("-1");
			return;
		}
		
		visited = new boolean[H][W][K+1];
		
		int move = bfs();
		System.out.println(move);
		
	}


	private static int bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0,0,K,0));
		Node node; 
		int nx = 0, ny = 0;
		while(!q.isEmpty()) {
			node = q.poll();
			
			if(node.x == H-1 && node.y == W-1) {
				return node.move;
			}
			
			
			// 사방탐색
			for (int d = 0; d < dx.length; d++) {
				nx = node.x + dx[d];
				ny = node.y + dy[d];
				if(nx<0||ny<0||nx>=H ||ny>=W || map[nx][ny]==1||visited[nx][ny][node.k]==true)continue;
				q.add(new Node(nx,ny,node.k,node.move+1));
				visited[nx][ny][node.k] = true;
			}
				
			// k가 남은 경우 말처럼 움직임 가능
			if(node.k>0){
				for (int d = 0; d < horseDx.length; d++) {
					nx = node.x + horseDx[d];
					ny = node.y + horseDy[d];
					if(nx<0||ny<0||nx>=H ||ny>=W || map[nx][ny]==1||visited[nx][ny][node.k-1]==true)continue;
					q.add(new Node(nx,ny,node.k-1,node.move+1));
					visited[nx][ny][node.k-1] = true;
				}
			}
		}
		return -1;
	}
}