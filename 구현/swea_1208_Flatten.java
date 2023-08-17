package recursive_230801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 테케 10
 * 가로의 길이는 항상 100
 * @author SSAFY
 *
 */

public class swea_1208_Flatten {
	static int depth;
	static final int size = 100;
	static int[] boxs = new int[size];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0;t<10;t++) {  // 테케 10
			depth = Integer.parseInt(br.readLine());	// 덤프 횟수 저장
			StringTokenizer sb = new StringTokenizer(br.readLine()," ");

			for(int b=0; b<size;b++) {
				boxs[b] = Integer.parseInt(sb.nextToken());
			}													// 여기까지 boxs저장
			
			
			Arrays.sort(boxs);   // boxs 정렬

			recursive(0);   
			System.out.printf("#%d %d\n",t+1,boxs[size-1]-boxs[0]);
		}														
	}
	private static void recursive(int c) {
		if( c == depth) {
			return;
		}
		
		boolean flag = false;
		
		// 가장 높은 것 = 배열의 마지막
		// 배열 마지막 요소 -1
		// n-1 요소와 비교하여 재정렬
		int i = size-1;
		while(i>0 && i<size) {
			if(boxs[i]!=0 && boxs[i]!=boxs[i-1]) {
				boxs[i]--;
				if(boxs[i-1]>boxs[i]) {
					int temp = boxs[i-1];
					boxs[i-1]= boxs[i];
					boxs[i] = temp;
				}
				flag = true;

				break;
			}
			i--;
		}
		
		// 가장 작은 것 = 배열의 첫번째
		// 배열 첫번째 요소 +1
		// 1번째 요소와 비료하여 재정렬
		if(flag) {
			i = 0;
			while(i>=0 && i<size-1) {
				if(boxs[i]!= 0 && boxs[i]!=boxs[i+1]) {
					boxs[i]++;
					if(boxs[i]>boxs[i+1]) {
						int temp = boxs[i+1];
						boxs[i+1] = boxs[i];
						boxs[i] = temp;
					}
					break;
					
				}
				
				i++;
			}
		}
		recursive(c+1);
		
	}
	

}
