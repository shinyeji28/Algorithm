import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int bagWeight = Integer.parseInt(st.nextToken());

        int[][] goods = new int[n+1][2];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            goods[i][0] = w;
            goods[i][1] = v;
        }


        int[] dp = new int[bagWeight+1];
        // 현재 물건을 넣기 : 현재 물건의 가치 + dp[i-현재 물건의 w] : v + dp[i-1][j-w]
        // 현재 물건 안 넣기 : dp[이전 물건까지의 가치]             : dp[i-1][j];
        // 이 중 가장 큰 것
        for(int i=1;i<=n;i++){
            int w = goods[i][0];
            int v = goods[i][1];
            for(int j=bagWeight;j>=w;j--){
                if(j-w>=0) dp[j] = Math.max(v + dp[j-w], dp[j]);
            }
        }
        System.out.println(dp[bagWeight]);
    }
}