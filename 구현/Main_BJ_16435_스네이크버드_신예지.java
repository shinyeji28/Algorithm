package d230811;

/**
 * 과일 1개 먹으면 길이 1만큼 증가
 * i 번째 과일 높이는 hi
 * 자신보다 작거나 같은 높이 과일만 먹을 수 있음
 * 
 * 초기 길이 L일 때 늘릴 수 있는 최대 길이
 * 
 * 입력
 * 과일 개수 N , 초기 길이 L
 * 과일의 높이 들
 * 
 * 문제 해결
 * 1. 오름차순 정렬
 * 2. 나보다 작거나 같은 것 먹은 후 나의 길이 1 증가
 * 
 * @author SSAFY
 *
 */

import java.util.*;
import java.io.*;

public class Main_BJ_16435_스네이크버드_신예지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<N;i++) {
			if(L>=arr[i]) {
				L+=1;
			}
		}
		System.out.println(L);
	}

}
