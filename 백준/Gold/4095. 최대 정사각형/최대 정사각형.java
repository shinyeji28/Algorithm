import java.util.*;
import java.io.*;
public class Main {
    static final int MOD = 1000000000;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n==0 && m==0)break;

            int[][] map = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dp : i,j까지 가장 큰 정사각형 with 모두 1인
            // 현재가 1이라면 좌, 상, 대각의 min값(정사각형을 만들기 위해) +1
            // 현재가 0이라면 0
            int[][] dp = new int[n+1][m+1];
            int maxSize = 0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(map[i][j] == 1){
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                        maxSize = Math.max(maxSize,dp[i][j]);
                    }
                }
            }
            sb.append(maxSize).append('\n');
        }
        System.out.println(sb);
    }
}