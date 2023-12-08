/*
    3차원 다이니믹 프로그래밍
    if(alph1[i]==alph2[j]==alph3[k]){
        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
    }else{
        dp[i][j][k] = Math.max( dp[i][j][k-1] , Math.max(dp[i-1][j][k], dp[i][j-1][k]));
    }
*/

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenzier(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();
        
        char[] alph1 = new char[str1.length()];
        char[] alph2 = new char[str2.length()];
        char[] alph3 = new char[str3.length()];
        
        alph1 = str1.toCharArray();
        alph2 = str2.toCharArray();
        alph3 = str3.toCharArray();
        
        int [][][] dp = new int[alph1.length+1][alph2.length+1][alph3.length+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                for(int k=0;k<dp[0][0].length;k++){
                    
                    if(i==0||j==0||k==0)continue;
                    
                    if(alph1[i-1]==alph2[j-1]&&alph2[j-1]==alph3[k-1]){
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    }else{
                        dp[i][j][k] = Math.max( dp[i][j][k-1] , Math.max(dp[i-1][j][k], dp[i][j-1][k]));
                    }
                    
                }
            }   
        }

        System.out.println(dp[dp.length-1][dp[0].length-1][dp[0][0].length-1]);
    }  
}