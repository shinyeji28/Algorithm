/**
 * R*C
 *  '.'는 빈 칸이고, 'x'는 건물
 * 파이프라인 : 첫째 열 - 마지막 열
 * 오른쪽, 오른쪽 위, 오른쪽 아래 대각선 
 * 각 칸을 지나는 파이프는 하나
 * 
 * 출력>
 * 가스관과 빵집을 연결하는 파이프라인의 최대 개수
 * 
 * 구현방법>
 * dfs : 파이프를 설치할 수 있다면 넘기기
 * 오른쪽 위 - 오른쪽 - 오른쪽 아래 대각선 순서로 탐색
 *  
 * 
 */
import java.util.*;
import java.io.*;
public class Main {
	static int[] dx = new int[]{-1,0,1};
	static int[] dy = new int[] {1,1,1};
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			if(map[i][0]=='x')continue;
			if(dfs(i,0))sum++;;  // 첫번째 열에서 시작
		}
		System.out.println(sum);
	}
	/**
	 * 다음 좌표가 설치 가능 하면 재귀 보내기
	 * 기저조건 : 마지막 열이면 true;
	 *         
	 * 현재 좌표 기준으로 3방향으로 가기
	 * 		 map 영역을 벗어나거나 
	 *         벽이거나 
	 *         이미 설치한 파이프가 있으면 
	 *         
	 * @param r 확인해야할 x좌표
	 * @param c 확인해야할 y좌료
	 * @return
	 */
	private static boolean dfs(int r, int c) {
		if(c==C-1) {
			return true;
		}

		visited[r][c] = true;
		for (int d = 0; d < dx.length; d++) {
			int nx = r + dx[d];
			int ny = c + dy[d];
			
			if(nx<0||ny<0||nx>=R||ny>=C)continue;
			if(map[nx][ny]=='x')continue;
			if(visited[nx][ny])continue;
			
			if(dfs(nx, ny)) return true;
			
		}
//		visited[r][c] = false;
		return false;
	}
}