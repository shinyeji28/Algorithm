import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] promotion = new int[M][2];
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            promotion[i][0] = cost;
            promotion[i][1] = cnt;
        }
        int[] dp = new int[C+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=C;i++){
            for(int[] p : promotion){
                int cost = p[0];
                int cnt = p[1];

                if(i-cnt>=0)dp[i] = Math.min(dp[i], cost + dp[i-cnt]);
                if(cnt > i)dp[i] = Math.min(dp[i], cost);
            }
        }
        System.out.println(dp[C]);


    }
}