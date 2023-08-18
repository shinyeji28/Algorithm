package Graph230817;

/**
 *  배열 값 : 행 합의 최솟값
 *  
 *  1. k개의 순열
 *  2. 구해진 순열 순서로 배열 돌리기
 *  3. 행의 최솟 값 저장
 *  
 *  4. 순열 개수만큼 위의 내용을 반복 후 각 경우의 행의 최솟값 (배열 값) 저장
 *  
 * @author SSAFY
 *
 */
import java.io.*;
import java.util.*;

public class Main_BJ_17406_배열돌리기4_신예지 {
	static int[][] origin;
	static int[][] arr;
	static int N,M;
	static int minRow =Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		origin = new int[N+1][M+1];	// 원본 배열
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] rotationInfo = new int[K][3];	// 회전 정보
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				rotationInfo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//1. kPk - 넥퍼 
		int order[] = new int[K];
		for(int i=0;i<K;i++) {
			order[i] = i;
		}
		do {
			
			// 배열 복사
			arr = new int[N+1][M+1];	// 회전 할 배열
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = origin[i][j];
				}
			}
			// 구해진 순열의 순서로 배열 돌리기

			for(int i : order) {
				rotation(rotationInfo[i][0], rotationInfo[i][1], rotationInfo[i][2]);
			}
			
			// 최소 행 찾기
			rowSum();
		}while(np(order));
		
		System.out.println(minRow);
		

	}
	private static boolean np(int[] arr) {
		
		int N = arr.length;
		int i = N-1;
		while(i>0 && arr[i-1]>=arr[i]) --i;
				
		if(i==0) return false;
		
		int j =N-1;
		while(arr[i-1]>=arr[j]) --j;
		swap(arr, i-1, j);
		
		int k = N-1;
		while(i<k) swap(arr, i++, k--);
		
		return true;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static void rotation(int r, int c, int k) {
		// 배열 돌리기

		for(int i=1;i<=k;i++) {
			int sx = r-i;
			int sy = c-i;
			int ex = r+i;
			int ey = c+i;
			
			oneCycle(sx, sy, ex, ey);
		}
		print();
		

		

	}
	private static void oneCycle(int sx, int sy, int ex, int ey) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int d = 0;
		
		int cycleSize = (ex-sx+1 + ey-sy) *2-2;  // 한 사이클을 돌아야 하는 원소 갯수
	
		int x = sx;
		int y = sy;
		int prev = arr[x][y]; //이전 값 저장
		for(int i=0;i<cycleSize+3;i++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if(nx<sx || nx>ex || ny<sy || ny>ey) {
				d++;
				continue;// 현 위치가 벗어나면 방향을 바꿔줌
			}
			x = nx;
			y = ny;
			int temp = arr[x][y];
			arr[x][y] = prev;
			prev = temp;
			
			
		}


	}
	private static void rowSum() {
		for(int i=1;i<=N;i++) {
			int sum = 0;
			for(int j=1;j<=M;j++) {
				sum += arr[i][j];
			}
			minRow = Math.min(sum,minRow);
		}
	}
	
	private static void print() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}			
		System.out.println();
	}
}
