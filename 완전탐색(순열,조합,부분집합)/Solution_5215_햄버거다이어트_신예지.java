package powerSet_230803;

import java.util.*;
import java.io.*;

/** 
 * arr[n][0]의 합이 가장 큰 조합 
 * arr[n][1]의 합 <= L 이고 
 * 맛점수 ,  칼로리
 * @author SSAFY
 *
 */
public class Solution_5215_햄버거다이어트_신예지 {
	
	static int[][] arr;
	static int N;
	static int L;
	static int maxScore;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			arr = new int[N][2];
			for(int i=0;i<N;i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st1.nextToken());
				arr[i][1] = Integer.parseInt(st1.nextToken());
			}
			//-------------------------
			maxScore = 0;
			powerSet(0,0,0);
			System.out.println("#"+(t+1)+" "+maxScore);
		}
	}
	private static void powerSet(int sumScore, int sumKcal,int depth) {
		if(depth==arr.length && sumKcal<=L) {
			maxScore = Math.max(maxScore, sumScore);
			return;
		}
		if(sumKcal>L) {
			return;
		}
		if((sumKcal+arr[depth][1])<=L) {
			powerSet(sumScore+arr[depth][0], sumKcal+arr[depth][1],depth+1);  // 고른 것
		}
		powerSet(sumScore, sumKcal,depth+1);  // 안고른 것				

	}

}
