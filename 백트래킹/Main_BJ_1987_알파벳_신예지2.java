package Graph230817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 0,0에서 시작 
 * 상하좌우 움직임
 * 같은 알파벳을 2칸이상 지날 수 없음
 * 
 * 입력>
 * 세로 R, 가로 C
 * 알파벳 배열
 * 출력>
 * 말이 지날 수 있는 최대 칸 수
 * 
 * 풀이
 * Set에 알파벳을 넣어 중복 체크
 * 
 * 사방탐색
 * 
 * if 현 위치 인덱스 값이 true면 지나갈 수 없음
 *  현 위치의 알파벳 아스키 코드 값 (= 인덱스)를 true
 *  
 *  
 * @author SSAFY
 *
 */

public class Main_BJ_1987_알파벳_신예지2 {
	static char[][] alph; 
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int _max = 0;
	static boolean[] check = new boolean[26];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		alph = new char[R][C];
		for(int i=0;i<R;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<C;j++) {
				alph[i][j] = temp[j].charAt(0);
			}
		}

		backtracking(0,0,0);
		System.out.println(_max);

	}
	

	private static void backtracking(int r,int c, int depth) {
		// 현재 위치의 값에 진행 할 수 있는 지 확인
		if(r<0 || c<0 || r>=alph.length || c>=alph[0].length) {
			_max = Math.max(depth, _max);
			return;
		}
		if( check[(int)(alph[r][c]-'A')]) {
			_max = Math.max(depth, _max);
			return;
		}
		
		// 진행 가능
		check[(int)(alph[r][c]-'A')] = true;
		
		// 사방 탐색 다음 것을 넘기기
		for(int d=0;d<dx.length;d++) {
			int x = r+dx[d];
			int y = c+dy[d];		
			backtracking(x,y,depth+1);
		}
		check[(int)(alph[r][c]-'A')] = false;

	}

}
