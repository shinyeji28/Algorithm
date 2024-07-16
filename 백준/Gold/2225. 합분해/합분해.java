/*
 * dp[k][n] : 정수 k개로 만들어 합 n이 되는 최대 경우의 수
 * 중복을 허락
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * k-1개의 정수에 0을 더하면 합n의 k개로 만들 수 있다
 * k개의 정수를 합 n-1로 한 것에 +1을 하면 n이 된다.
 *
 * */
import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[k+1][n+1];
        for(int i=1;i<=k; i++){
            for(int j=0;j<=n;j++){
                if(i==1 || j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) %  1000000000;
            }
        }
        System.out.println(dp[k][n]);
    }
}