import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int bagWeight = Integer.parseInt(st.nextToken());

        int[][] goods = new int[n+1][3];
        int[] dp = new int[bagWeight+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            goods[i][0] = w;
            goods[i][1] = v;
            goods[i][2] = c;

        }

        for(int i=1;i<=n;i++) {
            int w = goods[i][0];
            int v = goods[i][1];
            int c = goods[i][2];


            for (int k = 1; c>0 ;k <<= 1){

                int count = Math.min(k,c);
                c -= count;

                for (int j = bagWeight; j >= w*count; j--) {
                    dp[j] = Math.max(v * count + dp[j - w * count], dp[j]);
                }
            }
        }
        System.out.println(dp[bagWeight]);
    }
}