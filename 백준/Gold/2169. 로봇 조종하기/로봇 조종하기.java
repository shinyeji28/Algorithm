/*
* dp
* 위에서부터 한 행씩 반복
* 1. 좌 -> 우 최대 값
* 2. 우 -> 좌 최대 값
* 3. 위 -> 아래 최대 값
* */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = map[0][0];
        int[] leftDp = new int[m];
        int[] rightDp = new int[m];

        for(int i=0;i<n;i++){

            Arrays.fill(leftDp, Integer.MIN_VALUE);
            Arrays.fill(rightDp, Integer.MIN_VALUE);
            leftDp[0] = (i==0? map[0][0] : dp[i-1][0] + map[i][0]);
            for(int j=1;j<m;j++){
                leftDp[j] = Math.max(leftDp[j-1], (i==0?Integer.MIN_VALUE : dp[i-1][j])) + map[i][j];
                if(i==0){
                    dp[i][j] = leftDp[j];
                }
            }
            if(i==0)continue;
            rightDp[m-1] = dp[i-1][m-1] + map[i][m-1];

            for(int j=m-2;j>=0;j--){
                rightDp[j] = Math.max(rightDp[j+1], dp[i-1][j]) + map[i][j];
            }

            for(int j=0;j<m;j++){
                dp[i][j] = Math.max(leftDp[j],rightDp[j]);
            }
        }
        System.out.println(dp[n-1][m-1]);

    }

}