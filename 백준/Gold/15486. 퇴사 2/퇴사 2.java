/*
* dp[i] : i상담을 진행 했을 n+1~i까지 최대 이익 (뒤에서부터)
*    = Math.max(i 상담 선택, i상담 선택하지 않고 이전 상담 선택)
*    = Math.max((i+Ti) + pi, dp[i+1])
* */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){

            if(arr[i][0] + i > n) {
                dp[i] = dp[i+1];
                continue;
            }
            dp[i] = Math.max(dp[i+arr[i][0]] + arr[i][1], dp[i+1]);
        }
        System.out.println(dp[0]);
    }
}