/*
* 벽을 0or1번 뚫을 수 있을 때, 이때 최단 거리
* dp, 방문 배열에 벽을 뚫었는지 기록
* visited[0][i][j] : 벽을 안뚫은 경우 / visited[1][i][j] : 벽을 뚫은 경우
* 최단거리는 bfs 풀이 (가장 먼저 nn에 도착한 것이 최단거리)
* dp[i][j] = min(벽을 뚫은 경우, 벽을 뚫지 않는 경우)
*
* ** 간선에 비용이 있을 땐 다익스트라(우선순위 큐)를 쓰고 단지 최단거리를 구할 땐 queue만 써야한다
* */

import java.util.*;
import java.io.*;
public class Main {
    static char[][] map;
    static int n,m;
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            map[i] = str.toCharArray();
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{0,0,1,0});
        boolean[][][] visited = new boolean[2][n][m];
        visited[0][0][0] = true;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int c = cur[2];
            int isWall = cur[3];
            if(x == n-1 && y == m-1){
                return c;
            }
            for(int d=0;d<dx.length;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0|| ny<0|| nx>=n||ny>=m)continue;

                if(isWall==1){  // 벽을 부순적이 있음
                    if(!visited[1][nx][ny] && map[nx][ny] == '0'){
                        pq.offer(new int[]{nx,ny,c+1,1});
                        visited[1][nx][ny] = true;
                    }
                }
                else{  // 벽을 부순적이 없음
                    if (map[nx][ny] == '1') {   // 벽을 부숨
                        pq.offer(new int[]{nx, ny, c + 1, 1});
                        visited[1][nx][ny] = true;
                    }else if(!visited[0][nx][ny]){
                        pq.offer(new int[]{nx,ny,c+1,0});
                        visited[0][nx][ny] = true;
                    }
                }

            }
        }
        return -1;
    }
}