package beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2146_다리만들기 {

	static int[][] map;
	static boolean[][] visited;
	static boolean[][] originVisited;
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static int N;
	static List<Queue<int[]>> queSet = new ArrayList<>();
	static Queue<int[]> edgeQ; 
	static Queue<int[]> q;
	static int minpath = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		originVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					originVisited[i][j] = visited[i][j] = true;

				}
			}
		}
		
		// 섬을 구분짓기, 동시에 섬의 가장자리를 큐에 넣는다
		int marking = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					separateIsland(++marking, i, j);
				}	
			}
		}

		//또 다른 섬까지의 최단 거리 찾기
		int[] pos;
//		print();
		for (int i = 0; i < queSet.size(); i++) {
			for (int j=0 ; j<queSet.get(i).size();j++) {
				pos = queSet.get(i).poll();
				bfs(pos[0], pos[1]);
//				print();
				copyArr();
			}
		}
		System.out.println(minpath);


	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void copyArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = originVisited[i][j];
			}
		}
	}

	private static void bfs(int x, int y) {
		int mark = map[x][y];
		q = new ArrayDeque<>();
		q.offer(new int[] {x,y});
		visited[x][y] = true;
		int depth = 0;
		A : while(!q.isEmpty()) {
			int size = q.size();
			depth++;
			for (int s = 0; s < size; s++) {
				int[] cur = q.poll();
				for (int d = 0; d < dx.length; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if(nx<0 || ny<0 || nx>=N || ny>=N ) continue;
					if(map[nx][ny]!=0 && map[nx][ny] != mark) break A;
					if(visited[nx][ny]) continue;
					q.offer(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}
		}
		minpath = Math.min(minpath, depth-1);	
		
	}

	private static void separateIsland(int marking, int x, int y) {
		edgeQ = new ArrayDeque<>();
		boolean edge = false;
		q = new ArrayDeque<>();
		q.offer(new int[] {x,y});
		map[x][y] = marking;
		
		while(!q.isEmpty()){
			int[] cur = q.poll();
			edge = false;

			for (int d = 0; d < dx.length; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(map[nx][ny]==0) {
					edge = true;
				}
				if(map[nx][ny]!=1) continue;
				q.offer(new int[] {nx, ny});
				map[nx][ny] = marking;
			}
			if(edge) {
				edgeQ.offer(new int[] {cur[0], cur[1]});
			}
		}
		queSet.add(edgeQ);  // 바다와 인접한 섬의 구역을 저장
		
	}

	
}
