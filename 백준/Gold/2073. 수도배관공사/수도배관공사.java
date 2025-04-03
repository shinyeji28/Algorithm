import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[][] pipe = new int[P+1][2];
        for(int i=1;i<=P;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pipe[i][0] = l;
            pipe[i][1] = c;
        }

        int[][] dp = new int[P+1][D+1];
        for(int i=0;i<=P;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }


        for(int i=1;i<=P;i++){
            int l = pipe[i][0];
            int c = pipe[i][1];
            for(int j=1;j<=D;j++){
                // 파이프 사용 안하기
                dp[i][j] = dp[i-1][j];

                // 파이프 사용하기
                if(j-l>=0 && dp[i-1][j-l]!=0)dp[i][j] = Math.max(dp[i][j], Math.min(c, dp[i-1][j-l]));

            }
        }
        System.out.println(dp[P][D]);


    }
}