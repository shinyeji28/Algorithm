package homework;
import java.util.*;
public class Daily3_assignment_3_2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr= new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] =sc.nextInt();
			}
		}
		int[] dx= {0,0,-1,1};      // 사방 탐색을 위한 증감값
		int[] dy= {-1,1,0,0};
		int _max=0;                // 다리의 최대값을 저장할 변수
		for(int i=0;i<arr.length;i++) {     
			for (int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==1) {          // 1 to 1의 최대 값을 구하는 것임으로 1을 만났을 때부터 시작
					for(int d=0;d<4;d++) {  // 사방 탐색
						int x = i,y=j;
						int cnt=0;
						while(true) {  // 한쪽으로 계속 진행하여 배열을 벗어나거나 1을 만날 때까지 카운트하여 다리 건설
							x=x+dx[d];
							y=y+dy[d];
							cnt++;
							if(x<0||y<0||x>=N||y>=N||arr[x][y]==1)break; //1을 만나 다리를 잇거나, 배열 밖으로 나가면 반복문 종료
						}	
						_max = Math.max(cnt,_max);    // 최대값만 저장
					}
				}
			}
		}
		System.out.println(_max);
	}

}
