package backtracking_230816;

/**
 * 최소 한개의 모듬 (a e i o u) + 두개의 자음
 * 정렬된 알파벳
 * 
 * 입력> 
 * 서로 다른  L개의 알파벳 ,  C개의 문자
 * 
 * 출력>
 * 사전식 출력
 * 
 * 풀이 
 * C개의 문자 중 L개만큼 뽑은 수가 사전식인지 확인 후 출력 
 * 
 * @author SSAFY
 *
 */

import java.util.*;
import java.io.*;

public class Main_BJ_1759_암호만들기_신예지 {

	static int L;
	static int C;
	static char[] arr;
	static char[] output;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		output = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = (st.nextToken()).charAt(0);
		}
		
		Arrays.sort(arr);
		combination(0,0,false,0);  
		System.out.println(sb);
	}
	
	private static void combination(int depth, int start, boolean isVowel, int consonant ) {
		
		if(depth == L) {
			// 최소 한개의 모듬 (a e i o u) + 두개의 자음
			
			if(isVowel && consonant>=2) {
				sb.append(output).append('\n');
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			output[depth] = arr[i];
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' ||arr[i] == 'o' ||arr[i] == 'u') {
				combination(depth+1,i+1,true,consonant);

			}else {
				combination(depth+1,i+1,isVowel,consonant+1);

			}
		}
	}

}
