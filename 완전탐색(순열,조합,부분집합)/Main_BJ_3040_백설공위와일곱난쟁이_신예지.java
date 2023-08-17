package 완전탐색응용230810;

import java.util.Scanner;

/**
 * 
 * 모든 숫자는 서로 다름
 * 항상 답이 유일한 경우만 입력으로 주어짐
 * 
 * 9 난쟁이 중 7명 찾기
 * 각 난쟁이 1~99
 * 7 난쟁이 합 : 100
 * 
 * 난쟁이의 수 출력
 * 
 * 해결방법
 * 1. 조합을 사용해서 100이 되는 수
 * 		- 9C7
 *      - 총 원소의 합 - 9C2 
 */

public class Main_BJ_3040_백설공위와일곱난쟁이_신예지 {

	static int[] arr;
	static int r = 7;
	static int[] result = new int[7];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		arr = new int[9];
		
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
		}
		
		combination(0,0,0);
		
		
	}
	
	private static void combination(int start, int depth, int sum) {
		
		if(depth == r) {
			if(sum == 100) {
				for(int i=0;i<7;i++) {
					System.out.println(result[i]);
				}
			}
			return;
		}
		for(int i=start;i<arr.length;i++) {
			int tempSum = sum + arr[i];
			result[depth] = arr[i]; 
			combination(i+1,depth+1,tempSum);
		}
		
	}
}
