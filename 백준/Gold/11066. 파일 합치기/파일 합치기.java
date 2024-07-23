import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K];
            int[][] dp = new int[K][K];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<K;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] sum = new int[K];
            for(int i=0;i<K;i++){
                sum[i] = (i==0?0:sum[i-1]) + arr[i];
            }
            for(int len=K-1;len>0;len--){
                for(int i=0;i<len;i++){
                    int j = i + K-len;
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        int cost = dp[i][k] + dp[k+1][j] + sum[j] - (i==0?0:sum[i-1]);
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }
            sb.append(dp[0][K-1]).append('\n');
        }
        System.out.println(sb);
    }
}
