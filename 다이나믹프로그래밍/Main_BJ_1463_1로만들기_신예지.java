package dp_230829;

import java.io.*;
import java.util.*;

public class Main_BJ_1463_1로만들기_신예지 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int[] dp = new int[X+1];
		
		if(X>=2) {
			dp[2] = 1;
			
			for (int i = 3; i <= X; i++) {
				int minNum = Integer.MAX_VALUE;
				int num = i;
	
				if(i%3==0) {
					if(dp[i/3]<minNum) {
						num = i/3;
						minNum = dp[num];
					}
				}if(i%2==0) {
					if(dp[i/2]<minNum) {
						num = i/2;
						minNum = dp[num];
					}			
				}
				if(dp[i-1]<minNum) {
					num = i-1;
					minNum = dp[num];
				}			
				
				dp[i] = dp[num] + 1;
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[X]);
		
	}

}
