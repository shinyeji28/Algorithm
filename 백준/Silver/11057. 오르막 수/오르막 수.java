import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][10];  // dp[i][j] : i자리수에서 마지막 자리가 j인 것의 합

        for(int j=0;j<=9;j++){
            dp[1][j] = 1;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                for(int k=0;k<=j;k++){
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
                }
            }
        }
        int sum = 0;
        for(int j=0;j<=9;j++){
            sum = (sum + dp[n][j]) % 10007;
        }
        System.out.println(sum);

    }
}