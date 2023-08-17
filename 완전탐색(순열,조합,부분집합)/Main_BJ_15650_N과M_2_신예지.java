package combination_230802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_BJ_15650_N과M_2_신예지 {
	static int[] arr;
	static boolean[] visited;
	static int M;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// 조합, 중복 X
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		sb = new StringBuilder();
		int N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		arr = new int[N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		combination(0,0, new ArrayList<Integer>());
		System.out.println(sb.toString());
	}
	private static void combination(int depth, int start, List<Integer> result) {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				sb.append(result.get(i)+" ");
			}
			sb.append('\n');
			return;
		}
		for(int i=start;i<arr.length;i++) {
			List<Integer>temp = new ArrayList<Integer>();
			temp.addAll(result);
			temp.add(arr[i]);
			combination(depth+1,i+1,temp);
		}
	}

}
