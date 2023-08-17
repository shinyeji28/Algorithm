package 분할과정복230814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1992_쿼드트리_신예지 {

	static Boolean[][] arr;
	static int N;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new Boolean[N][N];
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<N;j++) {
				if(str[j].charAt(0)=='0') {
					arr[i][j] = false;
				}else {
					arr[i][j] = true;
				}
			}
		}
		whiteAndBlack(0,0,N);
		System.out.println(sb);

	}
	private static void whiteAndBlack(int x, int y, int size) {
		int cnt = 0;
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(arr[i][j] == false) {   // black 카운팅
					cnt++;
				}
			}
		}
		if(cnt==size*size) {		
			sb.append("0");
		}else if(cnt == 0) {
			sb.append("1");
		}else {
			int half = size/2;
			sb.append("(");
			whiteAndBlack(x,y,half);
			whiteAndBlack(x,y+half,half);
			whiteAndBlack(x+half,y,half);
			whiteAndBlack(x+half,y+half,half);
			sb.append(")");

		}
	}

}
