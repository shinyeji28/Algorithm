package treeWithBfs_230808;

import java.util.*;
import java.io.*;
public class Main_BJ_2563_색종이_신예지 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		int cnt = 0;
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i=y;i<y+10;i++) {
				for(int j=x;j<x+10;j++) {
					arr[i][j] = 1;

				}
			}
		}
		for(int i=1;i<101;i++) {
			for(int j=1;j<101;j++) {
				if(arr[i][j]==1)cnt++;
			}
		}
		System.out.println(cnt);
	}

}
