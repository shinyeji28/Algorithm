package dp_230829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_9095_123더하기_신예지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			System.out.println(dp[n]);
		}

		
	}
}
