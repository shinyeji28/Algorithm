package backtracking_230816;

import java.util.Scanner;


// 놓아지 퀸의 열번호를 기록하는 버전
public class NQueenTest1 {

	static int N, col[], ans;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1]; //1행 부터 사용
		ans = 0;
		
		setQueen(1);
		System.out.println(ans);
		
	}
	// 해당 퀸을 가능한 모든 곳에 놓아보기
	private static void setQueen(int row) {  // row : 퀸을 놓으려는 행
		
		//가지치기 : 직전까지 놓아진 상태로 
		if(!isAvailable(row-1)) return;
		
		//기저조건
		if(row>N) {
			ans++;
			return;
		}
		
		//유도 파트
		for (int c = 1; c <= N; c++) {   // 1열부터 N열까지 시도
			col[row] = c;
			setQueen(row+1);
		}
		
	}
	private static boolean isAvailable(int row) {  // row : 마지막으로 놓아진 퀸의 행
		for (int i = 1; i < row; i++) {
		
			// 행 차이와 열차이가 같으면 대각선
			if(col[i] == col[row] || row-i == Math.abs(col[row]-col[i])) {
				return false;
			}
		}
		return true;
		
	}
}
