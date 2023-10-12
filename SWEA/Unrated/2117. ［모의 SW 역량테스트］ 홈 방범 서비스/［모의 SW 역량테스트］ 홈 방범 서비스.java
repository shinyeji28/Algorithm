/**
 * 운영 비용 = K * K + (K - 1) * (K - 1)
 * 도시를 벗어난 영역에 서비스를 제공해도 운영 비용은 변경되지 않는다.
 * 도시의 크기 N (5~20)
 * 하나의 집이 지불할 수 있는 비용 M (1~10)
 * 
 * 보안회사의 이익(4) = 서비스 제공받는 집들을 통해 얻는 수익(3*3) - 운영 비용(5)
 * 
 * 출력>
 *  손해를 보지 않으면서 홈방범 서비스를 가장 많은 집들에 제공하는 서비스 영역을 찾고,
 *  그 때의 홈방범 서비스를 제공 받는 집들의 수
 *  
 * 구현방법>
 * 큐에 집의 위치 저장
 * bfs - depth마다 이익을 구함 (= 수익 - 운영비용)
 *     - 영역의 집의 개수와 동일하면 - 최적임으로 return
 *     -
 * 
 */
import java.util.*;
import java.io.*;
public class Solution {
	public static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static List<Node> home;
	static int N,M,result;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			home = new ArrayList<>();
			map = new boolean[N][N];
			result = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					if(input == 1) {
						map[i][j] = true;
						home.add(new Node(i,j));
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					bfs(i,j);					
				}
			}
			System.out.println("#"+t+" "+result);
			
		}
	}
	private static void bfs(int r, int c) {
//		System.out.println("rc: "+r+" "+c);
		Queue<int[]> q = new ArrayDeque<>();
		visited[r][c] = true;
		q.offer(new int[] {r,c});
		int[] cur;
		int x,y;
		int homeCnt=0;
		int benefit = 0;
		// 운영영역 1 일때
		int k = 1;
		if(map[r][c]==true) {
			homeCnt = 1;
			result = Math.max(result, homeCnt);
		}
		while(!q.isEmpty()) {
			int size = q.size();
			k++;
			if(k==N*N)return;
			for (int i = 0; i < size; i++) {
				cur = q.poll();
				for (int d = 0; d < dx.length; d++) {
					x = cur[0] + dx[d];
					y = cur[1] + dy[d];
					if(x<0||y<0||x>=N||y>=N || visited[x][y])continue;
					if(map[x][y])homeCnt++;    // 집이 있다
					q.offer(new int[] {x,y});
					visited[x][y] = true;
				}
			}
			//운영비용 구하기
			benefit = (homeCnt * M) - (k * k + (k - 1) * (k - 1));
			if(benefit>=0) {
				result = Math.max(result, homeCnt);				
			}
			if(homeCnt==home.size())return;

		}
		
	}

}