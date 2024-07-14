
import java.io.*;
import java.util.*;
class Solution
{
	static int[][] arr;
	static int[] startEnd = new int[4];
	static int shortest;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			visited = new boolean[N];
			shortest  = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<startEnd.length;j++) {
				startEnd[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				arr[i][0]=Integer.parseInt(st.nextToken());
				arr[i][1]=Integer.parseInt(st.nextToken());
			}
			
			// ------------------
			recursive(-1, startEnd[0], startEnd[1], 0, 0);
			System.out.println("#"+(t+1)+" "+shortest);
		}
	}
	private static void recursive(int prevIdx, int x, int y, int cnt, int distance) {  // cnt : 방문한 개수
		if(shortest<distance)return;
		if(arr.length==cnt) {
			distance += Math.abs(arr[prevIdx][0]- startEnd[2]) + Math.abs(arr[prevIdx][1]- startEnd[3]); // 현재 지점부터 집까지의 거리 더하기
			shortest = Math.min(shortest,distance);
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(!visited[i] ) {
				int temp = distance;
				if(prevIdx == -1) {
					temp += Math.abs(startEnd[0]-arr[i][0]) + Math.abs(startEnd[1]-arr[i][1]);
				}else {
					temp += Math.abs(arr[prevIdx][0]- arr[i][0]) + Math.abs(arr[prevIdx][1]- arr[i][1]);
				}
				visited[i] = true;
				recursive(i,arr[i][0],arr[i][1],cnt+1, temp);
				visited[i] = false;
			}
		}
	}

}