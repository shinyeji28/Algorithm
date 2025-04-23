import java.util.*;
import java.io.*;
public class Main {
    static final int MOD = 1000000000;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;
        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                if(j-1>=0) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % MOD;
                if(j+1<10)dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % MOD;
            }
        }
        int sum = 0;
        for(int j=0;j<10;j++){
            sum = (sum + dp[n][j]) % MOD;
        }

        System.out.println(sum);
    }
}