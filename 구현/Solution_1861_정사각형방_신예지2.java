package d230809;

/**
 * N*N 배열의 방
 * 각 원소는 1~N^2
 * 상하좌우 이동 가능
 * 현재 위치 보다 +1인 곳만 이동 가능
 * 
 * 이동할 수 있는 방 개수가 최대인 것이 여러개면 가장 작은 위치 출력
 * 
 * 출발해야 하는 방 번호와 최대 몇 개의 방을 이동할 수 있는지 출력
 * 
 * @author SSAFY
 *
 */

import java.util.*;
import java.io.*;

public class Solution_1861_정사각형방_신예지2 {

	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N;
	static int[][] arr;
	static int cnt = 0;
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxCnt = Integer.MIN_VALUE;
			int position = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					cnt = 0;
					goToRoom(i,j);
					if(cnt!=0) {
						if (maxCnt<cnt) {
							maxCnt = cnt;
							position = arr[i][j];
						}
						if(maxCnt == cnt) {
							if(position>arr[i][j]) {
								position = arr[i][j];
							}
						}
					}
					
				}
			}
			sb.append("#"+(t+1)+" "+position+" "+(maxCnt+1)).append('\n');
			
		}
		System.out.println(sb);
		
	}
	
	private static void goToRoom(int x, int y) {

		for(int d=0;d<dx.length;d++) {
			int nextX = x + dx[d];
			int nextY = y + dy[d];
			if(nextX<0 || nextY<0 || nextX>=N || nextY>=N)continue;
			if(arr[nextX][nextY] - arr[x][y] == 1) {
				cnt++;

				goToRoom(nextX,nextY);
			}
		}
			
		
		
	}

}
