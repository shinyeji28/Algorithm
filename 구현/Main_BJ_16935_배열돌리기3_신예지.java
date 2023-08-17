package treeWithBfs_230808;

import java.util.*;
import java.io.*;

public class Main_BJ_16935_배열돌리기3_신예지 {
	
	static int N;
	static int M;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());

		for(int i=0;i<R;i++) {
			String input = st.nextToken();
			switch (input) {
			case "1":
				reverseUpDown();     // 상하 반전
				break;
			case "2":
				reverseLeftRight();     // 좌우 반전
				break;
			case "3":
				rotaionRight90();     // 오른쪽 90
				break;
			case "4":
				rotaionLeft90();     // 왼쪽 90
				break;
			case "5":
				rotaionRightSeg();     // 4분할 오른쪽 90
				break;
			case "6":
				rotaionLeftSeg();     // 4분할 왼쪽 90
				break;
			default:
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}
	
	private static void reverseUpDown() { 
		int n = arr.length;
		int m = arr[0].length;
		int[][] temp = new int[n][m];
		for(int i=0;i<n/2;i++) {
			temp[i] = arr[n-1-i].clone();
			temp[n-1-i] = arr[i].clone();
		}
		arr = temp;
	}
	private static void reverseLeftRight() { 
		int n = arr.length;
		int m = arr[0].length;
		int[][] temp = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=m/2;j++) {

				temp[i][j] = arr[i][m-1-j];
				if(j == m/2) continue;
				temp[i][m-1-j] = arr[i][j];
			}
		}
		arr = temp;
	}
	private static void rotaionRight90() { 
		int n = arr.length;
		int m = arr[0].length;
		int[][] temp = new int[m][n];

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				temp[j][n-1-i] = arr[i][j];
			}
		}
		arr = temp;
	}
	private static void rotaionLeft90() { 
		int n = arr.length;
		int m = arr[0].length;
		int[][] temp = new int[m][n];

		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				temp[i][j] = arr[j][m-1-i];
			}
		}
		arr = temp;
	}
	private static void rotaionRightSeg() {
		int n = arr.length;
		int m = arr[0].length;
		int[][] temp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i<n/2 && j<m/2) {  //1번영역
					temp[i][j+m/2] = arr[i][j];

				}else if(i<n/2 && j>=m/2) {  //2번영역
					temp[i+n/2][j] = arr[i][j];
				
				}else if(i>=n/2 && j>=m/2) {  //3번영역
					temp[i][j-m/2] = arr[i][j];
				}else {    // 4번영역
					temp[i-n/2][j] = arr[i][j];
				}
			}
		}
		
		arr = temp;
		
	}
	private static void rotaionLeftSeg() {
		int n = arr.length;
		int m = arr[0].length;
		int[][] temp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i<n/2 && j<m/2) {  //1번영역
					temp[i+n/2][j] = arr[i][j];

				}else if(i<n/2 && j>=m/2) {  //2번영역
					temp[i][j-m/2] = arr[i][j];
				
				}else if(i>=n/2 && j>=m/2) {  //3번영역
					temp[i-n/2][j] = arr[i][j];

				}else {    // 4번영역
					temp[i][j+m/2] = arr[i][j];

				}
			}
		}
		
		arr = temp;
		
	}


}
