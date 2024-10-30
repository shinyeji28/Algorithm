import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] days = new int[n][2]; // 0 : 시간 , 1 : 가치
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i][0] = Integer.parseInt(st.nextToken());
            days[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];  // dp[i] i부터 상담을 받을 때 최대 가치
        // i 상담 선택 안함 : dp[i-1]
        // i 상담 선택 함 : 현재 가치 + dp[i + dp[(i + 상담 시 걸리는 날짜)]]
        // dp : 현재 상담을 선택과 비선택 중 큰 가치 저장


        for(int i=n-1;i>=0;i--){
            int t = days[i][0];
            int v = days[i][1];
            dp[i] = Math.max((i+1<n)?dp[i+1]:0, (i+t<=n)?(v + dp[i+t]) : 0);
        }
        System.out.println(dp[0]);
    }
}