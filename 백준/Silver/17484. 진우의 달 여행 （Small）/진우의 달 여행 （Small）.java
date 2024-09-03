import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][][] dp = new int[n][m][3];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(i==0){

                    dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = map[i][j];
                    continue;
                }

                dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                    if(j-1 >= 0) dp[i][j][0] = Math.min(dp[i][j][0], Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + map[i][j]);
                    dp[i][j][1] = Math.min(dp[i][j][1], Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j]);
                    if(j+1<m) dp[i][j][2] = Math.min(dp[i][j][2], Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + map[i][j]);
                
            }
        }
        int minValue = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            minValue = Math.min(minValue, dp[n-1][i][0]);
            minValue = Math.min(minValue, dp[n-1][i][1]);
            minValue = Math.min(minValue, dp[n-1][i][2]);
        }

        System.out.println(minValue);

    }
}