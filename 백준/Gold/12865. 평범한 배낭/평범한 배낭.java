/**
 * N개의 물건 중 
 * 무게 W와 가치 V를 가지는데 
 * 최대 K만큼의 무게만 넣을 수 있는 배낭에 최대  V를 넣어라
 * 
 * 구현 방법
 * DP[고려할 물건들 (1~i)][부분 배낭] = 최대 가치
 * 
 * 점화식
 * 무게가 0 && 부분배낭이 담을 수 있는 무게가 0 : 가치 0
 * 부분 배낭에 담을 수 있는 무게 < 현재 고려하는 물건의 무게 : 이전 최적해를 저장
 *                      >         : max(담는다: 현재 고려하는 물건의 가치 + 부분배낭에 담을 수 있는무게 - 현물무
 *                                  ,담지 않는다 : 이전 최적해 저장)
 * 									
 * 
 */

import java.util.*;
import java.io.*;

public class Main {
	public static class Item{
		int w;
		int v;
		public Item (int w,int v) {
			this.w = w;
			this.v = v;
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int finalWeight = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n+1][finalWeight+1];
		
		List<Item> items = new ArrayList<>();
		items.add(new Item(0,0));
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			items.add(new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// dp테이블 만들기
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = dp[0][i] = 0;
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {

				if(j < items.get(i).w) {
					dp[i][j] = dp[i-1][j];
				}else {

					dp[i][j] = Math.max(items.get(i).v + dp[i-1][j - items.get(i).w], dp[i-1][j]);
				}
	
			}
		}
		System.out.println(dp[n][finalWeight]);
		
	}
	
}