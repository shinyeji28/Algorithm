package d230811;

/**
 * N kg 배달해야 할 때
 * 
 * 3kg , 5kg 봉지
 * 
 * 배달하는 최소 봉지의 개수 출력
 * N kg를 만들 수 없으면 -1 출력
 * 
 * 문제 해결 
 * dp[i] = n; // 무게i를 담는데 필요한 최소 봉지의 개수가 n이다 
 * dp 배열 생성
 * 		-5 -3 의 인덱스의 값 +1;
 * 		단, -5의 위치와 -3의 위치 중 작은 것으로 저장 (최소 봉지의 개수를 구해야 함으로)
 * 	 	
 * 
 * @author SSAFY
 *
 */

import java.io.*;
import java.util.*;

public class Main_BJ_2839_설탕배달_신예지 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		
		for(int i=3;i<=N;i++) {  // dp 배열 생성
			
			if(i == 3 || i == 5) {
				dp[i] = 1;
				continue;
			}
			int save1 = Integer.MAX_VALUE;
			int save2 = Integer.MAX_VALUE;
			if(i-3 >= 0 && dp[i-3]!=0) {
				 save1 = dp[i-3]+1;
			}
			if(i-5 >= 0 && dp[i-5]!=0) {
				save2 = dp[i-5]+1;
			}

			if(save1 == Integer.MAX_VALUE && save2 == Integer.MAX_VALUE) continue; 
			dp[i] = Math.min(save1, save2);
		}
		if(dp[N]==0) dp[N] = -1;
		System.out.println(dp[N]);
		
		
	}

}
