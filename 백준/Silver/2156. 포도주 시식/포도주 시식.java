/*
    연속으로 3잔을 마실 수 없다
    1~n의 번호를 가진 포도주
    각 포도주의 양이 주어짐
  
    출력>
    최대로 마실 수 있는 포도주의 양

    
    구현>
    
    dp[i] = max(
        i 마신다 -> xoo -> dp[i-3] +  w[i-1] + w[i]
                    oxo -> dp[i-2] + w[i]
        i 안마신다 -> dp[i-1]
    )
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] w = new int[n+3]; 
        for(int i=3;i<n+3;i++){
            w[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[n+3];
        for(int i=3;i<n+3;i++){
            dp[i] = Math.max(dp[i-3] +  w[i-1] + w[i], dp[i-2] + w[i]);
            dp[i] = Math.max(dp[i-1], dp[i]);
        }
        System.out.println(dp[dp.length-1]);
    }
}
