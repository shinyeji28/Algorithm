/**
 * 
 * 도둑루피 - 루피 감소
 * [N-1],[N-1]까지 이동 했을 때 최소로 잃는 금액 구하기
 * 
 * 1. 양의 가중치가 있는 최소 비용 구하기 - 다익스트라
 * 
 * 구현
 * 2. bfs  - 0,0에서 각 위치마다의 최소 비용 저장 
 *         
 *
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {-1,1,0,0};
	static int[][] map;
	static int[][] weight;
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
			 weight = new int[N][N];
			 for (int i = 0; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					weight[i][j] = Integer.MAX_VALUE;
				}
			 }
			 bfs();
			 sb.append("Problem "+ (t++) + ": "+ weight[N-1][N-1]).append('\n');
//			 print();
			 
		}
		System.out.println(sb);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(weight[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{0,0,map[0][0]});
		weight[0][0] = map[0][0];
		
		int cur[];
		int nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
//			if(cur[0] == N-1 && cur[1] == N-1) {
//				return;
//			}
			for (int d = 0; d < dx.length; d++) {
				nx = cur[0] + dx[d];
				ny = cur[1] + dy[d];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				
				if(weight[nx][ny] > cur[2]+map[nx][ny]) {
					
					weight[nx][ny] = cur[2]+map[nx][ny];
					q.offer(new int[]{nx,ny,weight[nx][ny]});
					
				}
			}
		}
		
	}
	
	
	
}