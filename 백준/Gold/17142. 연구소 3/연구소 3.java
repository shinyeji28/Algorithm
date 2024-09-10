import java.util.*;
import java.io.*;

/*
* 바이러스 뽑기 -> 활성화 바이러스 m
* 바이러스 퍼트리기
* 최소 시간
* */
public class Main {
    static int n, m;
    static List<int[]> virus;
    static int[] pick;
    static int[][] distance;
    static boolean[][] visited;
    static Queue<int[]> q;

    static int result = Integer.MAX_VALUE;
    static int emptycnt = 0;
    static int[][] map;
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        virus = new ArrayList<>();
        pick = new int[m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new int[]{i,j});
                }
                if(map[i][j] != 1) emptycnt++;
            }
        }
        combination(0, 0);
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }
    public static void combination(int depth, int start){
        if(depth == m){
            distance = new int[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(distance[i],Integer.MAX_VALUE);
            }
            visited = new boolean[n][n];
            q = new ArrayDeque<>();
            for(int p : pick){
                int[] cur = virus.get(p);
                int x = cur[0];
                int y = cur[1];
                q.offer(new int[]{x,y});
                distance[x][y] = 0;
                visited[x][y] = true;

            }

            bfs();
            return;
        }
        for(int i=start;i<virus.size();i++){
            pick[depth] = i;
            combination(depth+1, i+1);
        }
    }
    public static void bfs(){
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};

        int visitedCnt = virus.size();
        int cnt = 0;

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < dx.length; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny]==1 || visited[nx][ny]) continue;

                if (distance[nx][ny] > distance[x][y] + 1) {
                    distance[nx][ny] = distance[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    if(map[nx][ny] != 2) {
                        cnt = Math.max(cnt, distance[nx][ny]);
                        visitedCnt++;
                    }

                }
            }

        }

        if(visitedCnt == emptycnt) result = Math.min(result, cnt);
    }
}