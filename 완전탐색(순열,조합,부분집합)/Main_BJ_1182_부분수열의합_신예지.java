package stack_queue_230804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1182_부분수열의합_신예지 {
	static int S;
	static int cnt=0;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st0 = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st0.nextToken());
		S = Integer.parseInt(st0.nextToken());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		powerSet(0,0);
		if(S==0)cnt--;
		System.out.println(cnt);
	}
	/**
	 * 
	 * @param sum 현재까지 선택된 요소의 총합
	 * @param idx 선택/비선택 결정을 완료한 요소의 개수 or 현재 선택/비선택을 고려할 요소의 인덱스
	 */
	private static void powerSet(int sum, int idx) {
		
		if(idx==arr.length ) {
			
			if(sum==S) cnt++;
			
			return;
		}
		powerSet(sum+arr[idx], idx+1);
		
		powerSet(sum, idx+1);
	}

}
