import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, m;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cnt = 0;  // 빙하 칸 개수
        Queue<int[]> icePos = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                icePos.offer(new int[]{i,j});
                if(map[i][j] !=0 )cnt++;
            }
        }

        int year = 0;
        boolean flag = false;
        A :while(!icePos.isEmpty()){
            int[] cur = icePos.poll();
            int i = cur[0];
            int j = cur[1];
            if(map[i][j]!=0){
                if(!bfs(i,j)){
                    flag = true;
                    break A;
                }
                if(map[i][j]!=0){
                    icePos.offer(new int[]{i,j});
                }
                year++;
            }
        }

        System.out.println(flag? year: 0);
    }
    public static boolean bfs(int r, int c){
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(new int[]{r,c});
        visited[r][c] = true;
        int landCnt = 0;
        int prevLandCnt = cnt;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            landCnt++;
            for(int d=0;d<dx.length;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny])continue;
                if(map[nx][ny]==0) {
                    map[x][y]--;
                    if(map[x][y]==0)cnt--;
                    map[x][y] = Math.max(map[x][y], 0);
                }else{
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        if(prevLandCnt!=landCnt) {
            prevLandCnt = landCnt;
            return false;
        }else return true;
    }
}