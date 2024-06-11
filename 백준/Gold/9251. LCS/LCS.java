/**
 * 방법 >
 * 문자열을 2차원 dp로 풀기
 * 아이디어 : 나를 포함할 것과 나를 포함하지 않는 것중 더 큰 것을 dp에 저장
 * 비교 문자가 같으면 : dp[i][j] = max(dp[i-1][j-1]+1, dp[i-1][j])
 * 비교 문자가 다르면 : dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        char[] alph1 = str.toCharArray();
        st = new StringTokenizer(br.readLine());
        str = st.nextToken();
        char[] alph2 = str.toCharArray();

        int len1 = alph1.length;
        int len2 = alph2.length;
        int[][] dp = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(alph1[i-1]==alph2[j-1]){
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[len1][len2]);
    }
}