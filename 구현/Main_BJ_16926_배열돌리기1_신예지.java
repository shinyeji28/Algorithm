package treeWithBfs_230808;

import java.util.*;
import java.io.*;

public class Main_BJ_16926_배열돌리기1_신예지 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1]; 
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int[] moving = {N,M,N,M};  // 진행 횟수
		
		for(int r =0; r<R;r++) {
			for(int i=1;i<=N/2;i++) {
				int prev = arr[i][i];   
				int x = i;				// 시작위치
				int y = i;
				for(int d=0;d<dx.length;d++) {  // 방향 결정
					for(int k = 0; k<moving[d]-(i-1)*2-1;k++) {  // 이동 횟수
						x = x+dx[d];
						y = y+dy[d];
	
						int temp = arr[x][y];
						arr[x][y] = prev;
						prev = temp;
					}
				}
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
