package d230811;

import java.util.Scanner;

/**
 * 신기한 소수
 *  : 왼쪽부터 1,2,3,4... 자리가 모두 소수 인것
 * 
 * N자리 숫자 중 신기한 소수 모두 출력
 * 
 * 입력
 * N
 * 
 * 문제 풀이
 * 1. 1 ~ 9까지 소수 구하기 - prev 저장
 * 
 * 재귀
 * 1. 2~9까지각 각 숫자를 prev소수의 뒤에 붙이기
 * 2. 합한 숫자가 소수인지 판별 
 * 3. 소수라면 출력할 수 있게 저장
 * 
 * @author SSAFY
 *
 */

public class Main_BJ_2023_신기한소수_신예지 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	
		recursive(0,0);
		System.out.println(sb);
	}
	
	private static void recursive(int depth, int prev) {
		if(N == depth) {
			sb.append(prev).append('\n');    // 완성된 값을 sb에 저장
			return;
		}
		
		for(int i=1;i<=9;i++) {
			if(prev == 0 && i==1)continue;
			int num = prev * 10 + i; // i를 prev뒤에 붙이기
			if(primeNum(num)){// 소수인지 판별
				recursive(depth+1,num);
			}
		}
	}
	private static boolean primeNum(int num) {   // 소수 판별
		
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}

}
