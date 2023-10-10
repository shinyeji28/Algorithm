/**
 * 칠공주 조건
 *   7명으로 구성
 *   사방에 인접
 *   '이다솜파'학생이 4명이상 포함
 * 입력>
 * S - 이다솜파
 * Y - 임도연파
 *   
 * 출력>
 * 칠공주를 결성할 수 있는 모든 경우의 수
 * 
 * 구현방법>
 * 1. 7명 뽑기 - 조합 (2차원 배열 -> 1차원으로 만들어 7명 뽑기)
 * 2. 뽑은 7명이 칠공주를 만족하는지 - DFS탐색
 *    - 인접하는가
 *    - 이다솜파가 4명 이상인가
 *    
 *    
 * 
 */

import java.util.*;
import java.io.*;

public class Main  {
	static final int SIZE = 5;
	static char[][] map = new char[SIZE][SIZE];
	static int[][] pick;
	static int result;
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {-1,1,0,0};
	static int adj;
	static boolean[][] visited;
	static boolean isPrincess[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pick = new int[7][2];
		
		isPrincess= new boolean[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		combination(0,0);
		
		System.out.println(result);
	}
	private static void combination(int start, int depth) {
		if(depth==7) {
			

			
			// 인접하면서 이다솜파가 4명 이상인지 확인하기
			int cnt = 0;

			for (int i = 0; i < 7; i++) {
				if(map[pick[i][0]][pick[i][1]] == 'S')cnt++;
				isPrincess[pick[i][0]][pick[i][1]] = true;
				
			}
			
			if(cnt>=4) {
				visited= new boolean[SIZE][SIZE];
				adj = 0;
				check(pick[0][0],pick[0][1]);

				if(adj==7) {
					result++;
				}
			}
			isPrincess = new boolean[SIZE][SIZE];
			return;
		}
		for (int i = start; i < 25; i++) {
			// 뽑기
			pick[depth][0] = i/SIZE;
			pick[depth][1] = i%SIZE;
			combination(i+1,depth+1);
		}
	}
	private static void check(int cx, int cy) {
		adj++;
		visited[cx][cy] = true;

		
		if(adj==7)return;
		
		for (int i = 0; i < dx.length; i++) {
			int nx = dx[i] + cx;
			int ny = dy[i] + cy;
			
			if(nx<0||ny<0||nx>=SIZE||ny>=SIZE)continue;
			if(visited[nx][ny])continue;
			if(!isPrincess[nx][ny])continue;
			
			check(nx,ny);
		}
	}

}