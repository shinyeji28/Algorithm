package linkedList_230807;

import java.util.*;
import java.io.*;

public class Main_BJ_11695_구간합구하기4_신예지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sumArr = new int[N+1]; 
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			sb.append(sumArr[j] - sumArr[i-1]).append('\n');	
		}
		
		System.out.println(sb);
	}

}