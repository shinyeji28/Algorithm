package homework;
import java.util.Arrays;
/*
5
11111
11122
11121
19111
11111
*/
import java.util.Scanner;

public class Daily3_problem_3_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N][N];
		for(int i=0;i<N;i++) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<N;j++) {
				arr[i][j] = temp[j];
			}
		}
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		int _max=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int cnt=0;
				cnt+=arr[i][j]-'0';;
				for(int d=0;d<4;d++) {
					int x=i+dx[d];
					int y=j+dy[d];
					if(x>0 && y>0 && x<N && y<N) {
						cnt+=arr[x][y]-'0';

					}
				}
				_max=Math.max(_max, cnt);
			}
		}
		System.out.println(_max);
		
	}

}
