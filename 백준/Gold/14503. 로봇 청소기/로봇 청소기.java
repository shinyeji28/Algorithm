import java.util.*;
import java.io.*;

/*
* 주변 4칸 중 청소되지 않는 빈 칸이 없는 경우 한칸 후진 후 진행 (후진한 칸이 벽이면 멈춤)
*                              있는 경우 반시계 방향으로 90도 회전 후 앞 칸이 청소되지 않은 경우 한 칸 전진
* */

public class Main {
    static int n,m;
    static int[][] map;
    static int[][] dis;

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] robot = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        map = new int[n][m];
        dis = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dis[i][j] = map[i][j];
            }
        }

        System.out.println(simulation(robot[0], robot[1], robot[2]));

    }
    public static int simulation(int r, int c, int dd){
        int cnt = 0;

        int[] dx = new int[]{-1,0,1,0}; //  북 동 남 서
        int[] dy = new int[]{0,1,0,-1};

        boolean[][] visited = new boolean[n][m];
        int x = r;
        int y = c;
        int d = dd;

        while(true){
            // 현재칸 청소
            if(!visited[x][y]){
                cnt++;
                visited[x][y] = true;
                dis[x][y] = cnt;

            }
            int blocking = 0;
            for(int i=3;i>=0;i--){
                int nd = (d + i) % 4;
                int nx = x + dx[nd];
                int ny = y + dy[nd];

                if(nx<0||ny<0||nx>=n||ny>=m || map[nx][ny] ==1|| visited[nx][ny]){
                    blocking++;
                    continue;
                }

                // 회전 후 청소하고 한칸 전진하기
                d = nd;
                x = nx;
                y = ny;

                break;

            }
            if(blocking == 4){  // 청소되지 않은 빈칸이 없는 경우 뒤로한칸, 튀로 한칸이 벽이면 종료
                int nx = x + dx[(d + 2) % 4];
                int ny = y + dy[(d + 2) % 4];
                if(nx<0||ny<0||nx>=n||ny>=m || map[nx][ny] ==1){
                    return cnt;
                }
                x = nx;
                y = ny;
            }
        }

    }

}