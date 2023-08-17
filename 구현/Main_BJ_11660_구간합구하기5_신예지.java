package linkedList_230807;

import java.io.*;
import java.util.*;

public class Main_BJ_11660_구간합구하기5_신예지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sumArr = new int[N+1][N+1]; 
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				sumArr[i][j] = sumArr[i-1][j] + Integer.parseInt(st.nextToken());
			}
		}
		
		int[] ij = new int[5]; 
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int j=y1;j<=y2;j++) {
				sum += sumArr[x2][j] - sumArr[x1-1][j];
			}
			sb.append(sum).append('\n');	
		}
		System.out.println(sb);
	}

}
