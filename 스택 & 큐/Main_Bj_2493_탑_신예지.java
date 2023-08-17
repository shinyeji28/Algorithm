package linkedList_230807;

import java.io.*;
import java.util.*;

public class Main_Bj_2493_탑_신예지 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<int[]> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {   // peek가 input보다 큰것을 발견할 때 까지 pop()
				
				if(stack.peek()[0]>input) {				// peek가 더 큰것을 발견하면 해당 index를 저장
					sb.append(stack.peek()[1]+" ");
					break;
				}
				
				stack.pop();
			}
			if(stack.isEmpty()) {   // 비었으면 앞에 더 놓은 것이 없음으로 0을 넣음
				sb.append("0 ");
			}
			stack.push(new int[] {input,i+1});
		}
		

		System.out.println(sb);

	}

}
