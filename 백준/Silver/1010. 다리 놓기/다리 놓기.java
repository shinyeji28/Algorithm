import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * mCn - 조합하면 되는 문제지만 시간초과 날 수 있음으로 dp를 사용
 * 		 조합을 파스칼의 삼각형을 이용하여 풀기
 * 	nCk = n-1Ck-1 + n-1Ck
 * @author SSAFY
 *
 */


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] dp = new int[30+1][30+1];
		//MCN
		dp[0][0] = 1;
		for (int i = 0; i <= 30; i++) {
			for (int j = 0; j <= i; j++) {
				
				if(i==j || j==0) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];

			}
			
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[M][N]);
		}
		
	}

}