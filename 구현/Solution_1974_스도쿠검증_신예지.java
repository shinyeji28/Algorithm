package backtracking_230816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1974_스도쿠검증_신예지 {

	final static int SIZE = 9;
	
	static int[][] sudoku;
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1;t <= T; t++) {
			sudoku = new int[SIZE][SIZE];
			for(int i=0;i<SIZE ;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				flag = new boolean[SIZE+1];

				for(int j=0;j<SIZE ;j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = solution(t);
			sb.append("#"+t+" "+answer).append('\n');


		}
		System.out.println(sb);

	}
	
	static int solution(int t) {
		// 열단위 탐색
		for (int j = 0; j < SIZE; j++) {
			if(!linear(j, false)) return 0;
		}
		
		// 행단위 탐색
		for(int i=0;i<SIZE ;i++) {
			if(!linear(i, true)) return 0;
		}
		
		//블럭 단위 탐색
		for (int i = 0; i < SIZE; i+=3) {
			for (int j = 0; j < SIZE; j+=3) {
				if (!cube(i, j)) return 0;
			}
		}
		
		
		// 스도쿠 완성
		return 1;		
	
	}

	private static boolean linear(int idx, boolean isRow) {
		boolean[] flag = new boolean[SIZE+1];

		for(int k=0;k<SIZE ;k++) {
			if(isRow) {
				if(flag[sudoku[idx][k]] == true) {
					return false;
				}
				flag[sudoku[idx][k]] = true;
				
			}else {
				if(flag[sudoku[k][idx]] == true) {
					return false;
				}
				flag[sudoku[k][idx]] = true;
			}

		}
		return true;
	}
	
	
	static boolean cube(int r, int c) {
		boolean[] flag = new boolean[SIZE+1];
		
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {
				if(flag[sudoku[i][j]]) {
					return false;
				}
				
				flag[sudoku[i][j]] = true;
			}
		}
		
		return true;
	}

}
