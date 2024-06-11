/*
* 최장증가부분수열
*
* 구현 >
* dp[i] : i번째 까지의 최장 증가 부분 수열의 길이 
* maxLength = 최장 증가 부분 수열의 최대 길이
* dp[i] = 나보다 가장 적은 차이로 작은 수의 dp[j] (역순으로 탐색)
*         나보다 작은 수를 발견하면(j) dp[i] = dp[j]+1
*         i에서 최장증가수열은 maxLength와 dp[i]중 큰 것 
*
* */

import java.util.*;
import java.io.*;
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            sb.append("#"+(i+1)+" "+ lis()).append('\n');
        }
        System.out.println(sb);
    }
    public static int lis()throws IOException{
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[n+1];
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        int maxLength = 1;
        for(int i=1;i<=n;i++){
            array[i] = Integer.parseInt(st.nextToken());
             for(int j=i-1;j>0;j--){
                if(array[j]<array[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }else if(array[j]==array[i]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);

        }
        return maxLength;
    }
}