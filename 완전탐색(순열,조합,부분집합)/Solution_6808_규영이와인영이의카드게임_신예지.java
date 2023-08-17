package 완전탐색응용230810;

import java.util.*;
import java.io.*;
public class Solution_6808_규영이와인영이의카드게임_신예지 {

	static int winCount;
	static int loseCount;
	static int[] fixArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			winCount = 0;
			loseCount = 0;
			
			fixArr = new int[9];
			int[] usedArr = new int[19];
			int[] arr = new int[9];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				int num = Integer.parseInt(st.nextToken());
				fixArr[i] = num;
				usedArr[num] = 1;
			}
			int idx = 0;
			for(int i=1;i<usedArr.length;i++) {
				if(usedArr[i]==0) {
					arr[idx] = i;
					idx++;
				}
			}
			
			Arrays.sort(arr);
			do {
				
				count(arr);// 이기는 횟수, 지는 횟수 저장
				
			}while(np(arr));
			
			System.out.println("#"+(t+1)+" "+winCount+" "+loseCount);

		}
		
	}
	private static boolean np(int[] arr) {
		
		int N = arr.length;
		int i = N-1;
		
		while(i>0 && arr[i-1]>=arr[i])--i;   // 뒤에서부터 큰 것을 만날 때 까지
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1]>=arr[j])--j;   // i-1보다 더 큰 수를 발견
		
		swap(arr, i-1, j);
		
		int k = N-1;
		while(i<k) {
			swap(arr,i++,k--);
		}
		
		return true;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void count(int[] arr) {
		int win = 0;
		int lose = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] < fixArr[i]) {  // 이긴경우
				win += arr[i] + fixArr[i];
			}else if(arr[i] > fixArr[i]) {
				lose += arr[i] + fixArr[i];
			}
		}
		
		if (win>lose) {
			winCount++;
		}else {
			loseCount++;
		}
	}

}
