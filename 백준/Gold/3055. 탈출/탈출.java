/**
 * . : 빈 곳
 * * : 물이 차있는 지역
 * X : 돌
 * D : 비버의 굴
 * S : 고슴도치 위치
 * 
 * 물이 있는 칸에 인접한 비어있는 곳은 물이 차게 될 예정
 * 물과 고슴도치는 돌을 통과할 수 없음
 * 고슴도치는 물이 있는 곳에 갈 수 없음 (찰 예정인 곳도 갈 수 없음)
 * 물은 비버의 굴로 갈 수 없음
 * 
 * 고슴도치가 비버의 굴로 이동하기 위해 필요한 최소 시간 구하기
 * 굴로 이동 불가 - "KAKTUS"출력
 * 
 * 아이디어 
 * 1. 물이차는 시간을 숫자로 표현 - BFS
 *    - 주의 . 비버의 굴이 있는 곳만 못감
 *    - 더 작은 숫자로 갱신, 
 *    - 이미 물이 차는 시간을 적었을 때, 더 작은 시간으로 업데이트 할 수 있다면 update
 *                             더 작은 시간으로 업데이트 불가면 BFS 종료
 * 2. 최단 거리로 굴까지 이동하기 - BFS
 *      - 돌 피하기
 *      - 물 피하기
 *         - 고슴도치의 이동횟수 :  moveCnt
 *         - if moveCnt < 물이 찬 시간 : 고슴도치가 이동 가능
 *      
 */

import java.util.*;
import java.io.*;

public class Main {
	static int R,C;
	static char[][] map;
	static int[][] water;
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {-1,1,0,0};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		water = new int[R][C];
		visited = new boolean[R][C];
		int[] dochi = new int[2];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='S') {
					dochi[0] = i;
					dochi[1] = j;
				}
				water[i][j] = Integer.MAX_VALUE;
			}
		}

		// 물이차는 시간 표현하기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '*') {
					waterFillingTime(i,j);
					// 방문 배열 초기화
					visited = new boolean[R][C];
				}
			}
		}
		
//		print(water);
		
		// 최단거리로 고슴도치 위치에서 굴까지 이동하기
		int cnt = bfs(dochi[0],dochi[1]);
		if(cnt==-1) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(cnt);
		}
		
	}
	
	private static int bfs(int startX, int startY) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {startX,startY});
		visited[startX][startY] = true;

		int[] cur;
		int nx,ny;
		int moveCnt = 0;
		while(!q.isEmpty()) {
			moveCnt++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				cur = q.poll();

				for (int d = 0; d < dx.length; d++) {
					nx = cur[0] + dx[d];
					ny = cur[1] + dy[d];
					
					if(!scope(nx,ny))continue;
					
					if(map[nx][ny]=='D') {
						return moveCnt;
					}
					
					if(map[nx][ny]=='.' && visited[nx][ny]==false) {

						if(moveCnt < water[nx][ny]) {
							q.offer(new int[] {nx,ny});
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		return -1;
	}

	private static void waterFillingTime(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r,c});
		visited[r][c] = true;
		
		int[] cur;
		int nx,ny;
		int depth = 0;
		while(!q.isEmpty()) {
			depth++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				cur = q.poll();
				for (int d = 0; d < dx.length; d++) {
					nx = cur[0] + dx[d];
					ny = cur[1] + dy[d];
					if(!scope(nx,ny)) continue;
					if(map[nx][ny]=='D'|| map[nx][ny]=='X')continue;
					if(visited[nx][ny] == true)continue;
					// 더 작은 수로 갱신
					if(water[nx][ny]==0 || water[nx][ny]>depth) {
						water[nx][ny] = depth;
						q.offer(new int[] {nx,ny});
						visited[nx][ny] = true;
					}else {
						continue;
					}
				}
			}
			
		}
		
	}
	
	private static boolean scope(int x, int y) {
		if(x<0||y<0||x>=R||y>=C)return false;
		return true;
	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}