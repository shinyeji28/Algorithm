
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static class Node{
		int x,y,dist;
		boolean isWallBreak;
		
		public Node(int x, int y,int d, boolean w) {
			this.x = x;
			this.y = y;
			this.dist = d;
			this.isWallBreak = w;
		}
	}
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		char[][] map = new char[N][M];
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		map[0][0] = 1;
		
		boolean[][][] visited = new boolean[N][M][2];
		Node cur;
		int x,y;
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};	
		Queue<Node>q = new ArrayDeque<Node>();             // [x, y, distance, isWallbreak]
		q.offer(new Node (0,0,0,false));
	
		while(!q.isEmpty()) {
			cur = q.poll();
		
			if(cur.x == N-1 && cur.y == M-1) {
				System.out.println(cur.dist+1);
				return;
			}

			
			for(int d=0;d<dx.length;d++) {
				x = cur.x + dx[d];
				y = cur.y + dy[d];
				if(x<0 || y<0 || x>=N || y>=M) continue;
				if(map[x][y] == '1') {
					if(cur.isWallBreak==false) {
						visited[x][y][1] = true;
						q.offer(new Node (x,y,cur.dist+1,true));
					}
				}else {
					if(cur.isWallBreak==false && visited[x][y][0]==false) { // 현재까지 벽을 부순적 없고 방문하지 않았으면
						 visited[x][y][0] = true;
						 q.offer(new Node (x,y,cur.dist+1,false));
					}
					else if(cur.isWallBreak==true && visited[x][y][1]==false) {  // 벽을 부순적이 있고 방문하지 않았으면 
						visited[x][y][1] = true;
						 q.offer(new Node (x,y,cur.dist+1,true));
					}
					
				}
			}
		}
		
		System.out.println("-1");
		
	}

}
