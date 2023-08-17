package stack_queue_230804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_BJ_6603_로또_신예지 {
	
	static int[] s;
	static long flag;
	static boolean[] visited;
	static int[] output;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		int k;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
					
			if(k==0)break;
			s = new int[k];
			visited = new boolean[6];
			output = new int[6];

			for(int i=0;i<k;i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0,0);
			sb.append('\n');

		}
		System.out.println(sb);
		

	}
	private static void combination(int depth, int start) {
		if(depth==6) {
			for(int i=0;i<depth;i++) {
				sb.append(output[i]+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start;i<s.length;i++) {
			if(!visited[depth]) {
				visited[depth]=true;
				
				output[depth] = s[i];
				
				combination(depth+1,i+1);
				visited[depth]=false;
			}

		}
		
	}

}
