package powerSet_230803;

import java.util.*;
import java.io.*;
/**
 * 1. 조합과 반복문으로 팀 분배
 * 2. 두 음식 간의 맛 차이가 최소
 * 		2-1. nP2(반복문) 차이 최소 경우
 * @author SSAFY
 *
 *
 * 시간복잡도 - 교수님 코드
 * N C (N/2)(조합) X N^2(시너지 배열 탐색)
 * 16 C 8 x 16^2
 * 
 * 30 C 15 약 1억
 */

public class Solution_4012_요리사_신예지 {
	static int [][] arr;
	static List<int[]> teams;
	static int N;
	static int[] foods;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			foods = new int[N];
			teams = new ArrayList<int[]>();
			int _min =Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				foods[i] = i+1;
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//-------------------
			
			// A팀 조합
			combination(0,0, new int[N/2]); 
			
			
			for(int c=0;c<teams.size();c++) {
				int[] teamA = teams.get(c);
				int[] teamB = new int[N/2];
				int idx1 = 0;
				int idx2 = 0;
				for(int i=0;i<N;i++) {		// B팀 결정
					if(idx2==N/2)break;
					if(idx1==N/2) {
						teamB[idx2]=i+1;
						idx2++;
						continue;
					}
					if(i+1<teamA[idx1]) {
						teamB[idx2] = i+1;
						idx2++;
					}
					if(i+1==teamA[idx1]) {
						idx1++;
					}
						
				}
				
				
				int sumA=0;
				int sumB=0;
				for(int i=0;i<N/2;i++) {
					for(int j=0;j<N/2;j++) {
						if(i!=j) {
							sumA += arr[teamA[i]-1][teamA[j]-1];
							sumB += arr[teamB[i]-1][teamB[j]-1];
						}
					}
				}

				_min = Math.min(Math.abs(sumA-sumB), _min);

			}
			sb.append("#"+(t+1)+" "+_min).append('\n');
		}
		System.out.println(sb);
		
	}
	private static void combination(int depth, int start, int[] _foods) {
		if(depth==N/2) {
			teams.add(_foods);
			return;
		}
		for(int i=start;i<N;i++) {
			int[] temp = new int[N];
			temp=_foods.clone();
			temp[depth]=foods[i];
			combination(depth+1, i+1, temp);
		}
		
	}
	

}
