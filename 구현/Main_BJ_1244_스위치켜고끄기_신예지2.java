package combination_230802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 남학생 1 : 배수면  스위치 toggle
 * 여학생 2 : 같은 인덱스 중심으로 대칭인 것 모두 toggle
 * 스위치 마지막 상태 출력
 * @author SSAFY
 *
 */
public class Main_BJ_1244_스위치켜고끄기_신예지2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] swit = new int[N+1];
		for(int i=1;i<=N;i++) {
			swit[i] = Integer.parseInt(st.nextToken());
		}
		
		int nums = Integer.parseInt(br.readLine());
		
		int[][] stus = new int[nums][2];
		for(int i=0;i<nums;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<2;j++) {
				stus[i][j]=Integer.parseInt(st1.nextToken());
			}
		}

		for(int i=0;i<stus.length;i++) {
			if(stus[i][0]==1) {  // 남학생
				int idx = stus[i][1];
				int d = stus[i][1];
				int mul = 1;
				while(d <= N) {
					if(swit[d]==1) {
						swit[d]=0;
					}else {
						swit[d]=1;
					}
					mul++;
					d = idx * mul;

				}
			}else {              // 여학생
				int mid = stus[i][1];
				int increase = 1;
				
				if (swit[mid]==1)swit[mid]=0;
				else swit[mid]=1;
				
	
				while(true) {
					int right = mid + increase;
					int left = mid - increase;
					if(right<=N && left>=1 ) {

						if(swit[left]==swit[right]) {
							if(swit[left]==1) {
								swit[left]=0;
								swit[right]=0;
							}else {
								swit[left]=1;
								swit[right]=1;
							}
						}else {
							break;
						}

						increase++;
					}
					else {
						break;
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			sb.append(swit[i]+" ");
			
			if(i%20==0) {
				sb.append('\n');
			}
		}			
		
		System.out.println(sb);
	
	}

}
