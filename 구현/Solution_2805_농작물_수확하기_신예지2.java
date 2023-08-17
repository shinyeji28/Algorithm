package combination_230802;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_2805_농작물_수확하기_신예지2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int sum=0;
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				char c[] = br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					arr[i][j] = c[j]-'0';
				}
			}
			int mid = N/2;
			int idx = mid+1;
			int cnt = 0;
			for(int i=0;i<N;i++) {
				if(i>mid) {
					idx++;
					cnt-=2;
				}else {
					idx--;
					cnt+=2;
				}
				for(int j=idx;j<(idx+cnt)-1;j++) {
					sum+=arr[i][j];
				}

			}
			
			
			System.out.printf("#%d %d",t+1,sum);

		}
	}

}
