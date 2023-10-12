/**
 * 숫자 N
 * 연산자 N-1 : 모두 사용해야함
 * 입력>
 * '+', '-', '*', '/' -> 0 1 2 3
 * 
 * 출력> 
 * 최대가 되는 수식, 최소가 되는 수식, 두값의 차이
 * 
 * 구현>
 * 순열 
 *  
 *  
 */

import java.util.*;
import java.io.*;
public class Solution {
	static int N;
	static List<Integer> operators;
	static int[] numbers;
	static int[] permuResult;
	static boolean[] visited;
	static int min, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		char[] charOper = new char[] {'+', '-', '*', '/'};
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			operators = new ArrayList<>();
			numbers = new int[N];
			// 연산자
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				int cnt = Integer.parseInt(st.nextToken());
				for (int j = 0; j < cnt; j++) {
					operators.add(i);
				}
			}
			// 숫자
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			permuResult = new int[N-1];
			visited = new boolean[N-1];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			permutaion(0);
			sb.append("#"+t+" "+(max-min)).append('\n');
		}
		System.out.println(sb);
	}

	private static void permutaion(int depth) {
		if(depth==N-1) {
			// 연산하기
			int result = numbers[0];
			for (int i = 0; i < N-1; i++) {
				int oper = permuResult[i];
				switch (oper) {
				case 0:   
					result += numbers[i+1];
					break;
				case 1:
					result -= numbers[i+1];
					break;
				case 2:{
					result *= numbers[i+1];

					break;}
				case 3:
					result /= numbers[i+1];
					break;
				}
			}
			// 최대, 최소 갱신
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		boolean[] dupl = new boolean[4];  //같은 위치 연산자는 탐색 안함

		for (int i = 0; i < operators.size(); i++) {
			if(dupl[operators.get(i)] == true)continue;
			if(visited[i]) continue;
			visited[i] = true;
			dupl[operators.get(i)] = true;
			permuResult[depth] = operators.get(i);
			permutaion(depth+1);
			visited[i] = false;
		}
	}

}