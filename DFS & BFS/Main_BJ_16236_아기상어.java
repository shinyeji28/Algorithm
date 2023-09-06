package D230904;

import java.util.*;
import java.io.*;


public class Main_BJ_16236_아기상어 {

	static int[] dx = new int [] {-1,0,0,1};
	static int[] dy = new int [] {0,-1,1,0};
	
	static int[] shark = new int[2]; 
	static int sharkWeight = 2;
	static int[][] map;
	static List<Node> fishes;

	public static class Node implements Comparable<Node>{
		int x;
		int y;
		int weight;
		
		public Node(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		fishes = new ArrayList<Node>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 9) {
					shark[0] = i;
					shark[1] = j;
				}else {
					map[i][j] = input;
				}
				if(input>=1 && input<=6){
					fishes.add(new Node(i,j,map[i][j]));   // 물고기 저장
				}
			}
		}
		Collections.sort(fishes);  // 물고기를 오름차순으로 정렬
		
		boolean flag = true;
		for (int i = 0; i < fishes.size(); i++) {
			if(flag) {
				flag = bfs(i);
			}else {
				break;
			}
		}
		
	}
	private static boolean bfs(int sIdx) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for (int i = sIdx; i < fishes.size(); i++) {    
			if(fishes.get(i).weight < sharkWeight) {    // 먹을 수 있는 물고기를 pq에 넣기
				pq.add(fishes.get(i));
				
			}else {  // 더이상 먹을 수 있는 물고기가 없으면 엄마 상에게 도움 (종료)
				return false;
			}
		}
		return true;

		
	}

}
