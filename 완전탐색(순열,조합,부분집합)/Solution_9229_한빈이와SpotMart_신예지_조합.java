package 완전탐색응용230810;

/**
 * N 개의 과자봉지 <=1000
 * 양손 : 2개 뽑기
 * 
 * 배열의 값 : 각 과자의 무게
 * 최대한 무거운 과자 고르기
 * M 이하
 * 
 * 들고 다닐 수 있는 최대 무게의 합 구하기
 * 
 * 문제 풀이
 * 방1. nC2 : N이 1000개 임으로 반복문으로 조합 -> 합 최대 찾기 
 * 		(가지치기 : 값이 제한 값보다 크면 return)
 * 방2. 정렬 후, left, right 인덱스를 양 끝에서 부터 비교 -> 합의 최대값 찾기 
 * @author SSAFY
 *
 */

import java.util.*;
import java.io.*;

public class Solution_9229_한빈이와SpotMart_신예지_조합 {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxWeight = 0;
			for(int i=0;i<N;i++) {
				for(int j=i;j<N;j++) {
					if(j==i)continue;
					int sum = arr[i] + arr[j];
					if(sum <= M) {
						maxWeight = Math.max(maxWeight, sum);
					}
				}
			}
			
			if(maxWeight == 0) {
				sb.append("#"+(t+1)+" -1").append('\n');
			}else {
				sb.append("#"+(t+1)+" "+maxWeight).append('\n');
			}
			
		}
		
		System.out.println(sb);
	}
	
}
