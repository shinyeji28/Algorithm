/**
 * 
 * 1초마다 순서대로
 *  - 미세먼지 확산
 *    - 미세먼지 위치를 큐에 저장
 *    - 미세먼지 위치에서 4방으로 1칸 이동
 *  - 바람따라 미세먼지 이동
 * 
 */
import java.util.*;

import java.io.*;

public class Main {
	private static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int[][] newArr;
	static List<Node> cleaner;
	static Queue<Node> q;
	static int R, C, T;
	static boolean flag = false;
	static int[] dx = new int[] { 0, 1, 0, -1 };
	static int[] dy = new int[] { 1, 0, -1, 0 };
	static int[] reDx = new int[] { 0, -1, 0, 1 };
	static int[] reDy = new int[] { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		newArr = new int[R][C];
		cleaner = new ArrayList<Node>();
		q = new ArrayDeque<Node>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					cleaner.add(new Node(i, j));
					newArr[i][j] = -1;
				}
				else if (map[i][j] != 0) {
					q.offer(new Node(i, j));
				}
			}
		}

		solution();
		int dust = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					continue;
				if (map[i][j] != 0)
					dust += map[i][j];
			}
		}
		System.out.println(dust);
	}

	private static void solution() {
		for (int t = 0; t < T; t++) {
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					// 먼지 확산
					if(map[i][j]==0 || map[i][j]==-1)continue;
					int cnt = 0;
					for (int d = 0; d < dx.length; d++) {
						int x = i + dx[d];
						int y = j + dy[d];
						if (x < 0 || y < 0 || x >= map.length || y >= map[0].length)
							continue;
						if (map[x][y] == -1)
							continue;
						newArr[x][y] += map[i][j] / 5;
						cnt++;
					}	
					newArr[i][j] += map[i][j] - (map[i][j] / 5) * cnt;

				}
			}
			copyArr();
			// 공기청정기 바람따라 미세먼지 이동 (배열돌리기)
			wind(cleaner.get(0).x, cleaner.get(0).y, false);
			wind(cleaner.get(1).x, cleaner.get(1).y, true);
		}
		
	}

	private static void copyArr() {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = newArr[i][j];
				newArr[i][j] = 0;
				if(map[i][j]==-1) {
					newArr[i][j] = -1;
				}
			}
		}
	}

	private static void print() {
		System.out.println("=======================");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void wind(int airX, int airY, boolean isReverse) {
		int d = 0;
		int nx;
		int ny;
		int x = airX, y = airY;
		int prev = 0;

		if (!isReverse) {
			while (true) {
				nx = x + reDx[d];
				ny = y + reDy[d];
				if (nx < 0 || ny < 0 || nx > airX || ny >= map[0].length) {
					d++;
					if (d == 4) {
						map[airX][airY] = -1;
						return;
					}
					nx = x;
					ny = y;
					continue;
				}
				int temp = map[nx][ny];
				map[nx][ny] = prev;
				prev = temp;
				x = nx;
				y = ny;
			}
		} else {
			while (true) {
				nx = x + dx[d];
				ny = y + dy[d];
				if (nx < airX || ny < 0 || nx >= map.length || ny >= map[0].length) {
					d++;
					if (d == 4) {
						map[airX][airY] = -1;
						return;
					}
					nx = x;
					ny = y;
					continue;
				}
				int temp = map[nx][ny];
				map[nx][ny] = prev;
				prev = temp;
				x = nx;
				y = ny;
			}
		}
	}
}