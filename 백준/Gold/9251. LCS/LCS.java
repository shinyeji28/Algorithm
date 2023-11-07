import java.util.*;
import java.io.*;
/**
 * 구현 방법>
 * lcs -> 2차원 dp배열
 * 점화식
 *  i==j? i를 부분 수열로 선택한다 -	dp[i][j] = dp[i-1][j-1] +1
 *  else i를 부분 수열로 선택하지 않는다 - Math.max(dp[i-1][j-1], dp[i][j-1])
 *  
 * dp[i]][j] 정의 :문자열2[1] ~ 문자열2[j]과  문자열1[1] ~ 문자열1[i]까지의 최장 공통 부분 수열의 개수  
 */
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str1 = "0" + st.nextToken();
		st = new StringTokenizer(br.readLine());
		String str2 = "0" + st.nextToken();
		
		int dp[][] = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<str1.length();i++) {
			for(int j=0;j<str2.length();j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
					continue;
				}
				if(str1.charAt(i)==str2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}

		}

		System.out.println(dp[str1.length()-1][str2.length()-1]);

	}

}