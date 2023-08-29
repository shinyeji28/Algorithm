package dp_230829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main_BJ_2579_계단오르기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		for (int i = 0; i <= N; i++) {
			if(i<3) {
				if(i == 0) dp[i] = 0;
				if(i == 1) dp[i] = score[1];
				if(i == 2) dp[i] = score[1] + score[2];
				continue;
			}

			dp[i] = Math.max(dp[i-3] + score[i-1] + score[i], dp[i-2] + score[i]);
			dp[i] = Math.max(dp[i-3] + score[i-2] + score[i], dp[i]);

			
		}
		
		System.out.println(dp[N]);
		
	}

}
