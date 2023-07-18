package homework;
/*
 * 입력 : Scanner - char arr[N][],arr[i] = sc.nextLine().toCharArray()  
 * N * N
 * 거미줄을 칠 수 있는 최대 값과 위치 구하기
 * 0: 공백 , 1: 장애물
 * 0일 때 거미줄을 칠 수 있다
 * 8방 탐색
 * 장애물 두칸 이상 연속된 경우 거미줄을 이어서 칠 수 없음
 * 
 * 해결법
 * 1. 2차원 배열에 입력 받기
 * 2. 반복문으로 원소 접근
 * 	0이면 8방탐색
 * 	if block == 2 해당 줄을 탐색하지 않고  종료
 * 
10
0000000000
0101010101
0101010101
0010101010
0001010101
0100010001
0010000010
0100010000
0111111111
0000000000

10
0 0 0 0 0 0 0 0 0 0
0 1 0 1 0 1 0 1 0 1
0 1 0 1 0 1 0 1 0 1
0 0 1 0 1 0 1 0 1 0
0 0 0 1 0 1 0 1 0 1
0 1 0 0 0 1 0 0 0 1
0 0 1 0 0 0 0 0 1 0
0 1 0 0 0 1 0 0 0 0
0 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0 0 0 0 0
 * 
 * */
import java.util.*;

public class Daily3_assignment_3_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int N = Integer.parseInt(sc.nextLine());
//		int arr[][] = new int[N][N];
//		for(int i=0;i<N;i++) {
//			char[] temp = sc.next().toCharArray();
//			for(int j=0;j<N;j++) {
//				arr[i][j] = temp[j]-'0';
//			}
//		}
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(Arrays.deepToString(arr));
		
		int dx[] = {0,0,1,-1,1,-1,1,-1};
		int dy[] = {-1,1,0,0,1,-1,-1,1};
		int _max = Integer.MIN_VALUE;
		int idx[] = new int[2];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (arr[i][j]==0) {
					int cnt=1;
					for(int d=0;d<dx.length;d++) {
						int block=0;
						int x = i;
						int y = j;
						while(true) {
							x+=dx[d];
							y+=dy[d];
							if(x<0 || y<0 || x>=N || y>=N)break;
							if(arr[x][y]==0)cnt++;
							if (arr[x][y]==0)block=0;
							else block++;
							if(block==2) break;
						}
					}
					if(_max<cnt) {
						_max = cnt;
						idx[0]=i;
						idx[1]=j;
					}
				}
			}
		}
		System.out.println(_max);
		System.out.println(idx[0]+","+idx[1]);
	}
}
