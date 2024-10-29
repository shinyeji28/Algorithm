import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=1;i<dp.length;i++){
            for(int coin: coins){
                if(i-coin>=0 && dp[i-coin]!=Integer.MAX_VALUE) dp[i] = Math.min(dp[i-coin]+1, dp[i]);
            }
        }
        System.out.println(dp[k]==Integer.MAX_VALUE?-1:dp[k]);
    }
}