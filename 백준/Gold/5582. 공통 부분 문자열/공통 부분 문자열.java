/*
* 방법 >
* 문자를 하나씩 넣어보면서 2차원 dp배열구하기
* 문자가 서로 같을 때 : (i-1,j-1)에서 이전 문자인지 체크 (연속됨을 확인하여 연속되면 dp[i-1][j-1] +1
* 다를 때 : max(dp[i-1][j],dp[i][j-1])
* */

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        char[] alph1 = str.toCharArray();
        st = new StringTokenizer(br.readLine());
        str = st.nextToken();
        char[] alph2 = str.toCharArray();

        int[][] dp = new int[alph1.length+1][alph2.length+1];
        int maxValue = 0;
        for(int i=1;i<=alph1.length;i++){
            for(int j=1;j<=alph2.length;j++){
                if(alph1[i-1] == alph2[j-1]){
                    if(i!=1 && j!=1 && alph1[i-2]==alph2[j-2]) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j-1], 1);

                    maxValue = Math.max(maxValue, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }

            }
        }
        System.out.println(maxValue);
    }
}