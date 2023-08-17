package recursive_230801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1210_Ladder1 {

	static final int size=100;
	static StringBuilder sb;
	static int[] dx = {0,0,-1};
	static int[] dy = {-1,1,0};
	static int[][] arr;
	static int T;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for(int t=0;t<10;t++) {
			arr = new int[size][size];
			int[] desti = new int[2];
			T = Integer.parseInt(br.readLine());
			sb.append("#"+T+" ");
			for(int i=0;i<size;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<size;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(arr[i][j]==2) {
						desti[0]=i;         // 도착지 저장
						desti[1]=j;
					}
				}
			}
//			System.out.println("테케:"+t);
			recursive(desti[0],desti[1]);
			
		}
//		System.out.println(sb.toString());

	}
	private static void recursive(int x, int y) {
		if(x==0) {
			
			sb.append(y+'\n');
			System.out.printf("#%d %d%n",T,y);
			return;
		}
		boolean flag = true;
		for(int d=0;d<3;d++){
			if(flag) {
				int next_x=x+dx[d];
				int next_y=y+dy[d];
				if(next_x>=0 && next_y>0 && next_x<size && next_y<size && arr[next_x][next_y]==1) {
					arr[next_x][next_y]=0;
					flag=false;
					recursive(next_x,next_y);
				}
			}
		}

		
	}

}
