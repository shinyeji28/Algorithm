import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        long[] dp = new long[k+1];
        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for(int j=0;j<n;j++){
            for(int i=coin[j];i<=k;i++){
                dp[i] += dp[i - coin[j]];
            }
        }
        System.out.println(dp[k]);
    }
}