
    import java.io.*;
    import java.util.*;

    public class Main{

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1;j<=i;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    dp[i][j] = Math.max(dp[i-1][j-1] , dp[i-1][j]) + map[i][j];
                }
            }
            int maxValue = 0;
            for(int j=1;j<=n;j++){
                maxValue = Math.max(maxValue, dp[n][j]);
            }
            System.out.println(maxValue);
        }
    }