import java.util.*;
import java.io.*;
public class Main {
    static int[][] map;
    static int n,m;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map =  new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0;j<m;j++){
                map[i][j] = (str.charAt(j))=='W'? 1:0;
            }
        }

        int result = Integer.MAX_VALUE;

        for(int i=0;i<=n-8;i++){
            for(int j=0;j<=m-8;j++){

                result = Math.min(result, bfs(i,j, 0));
                result = Math.min(result, bfs(i,j, 1));
            }
        }
        System.out.println(result);
    }
    public static int bfs(int x, int y, int first){

        int[] dx = new int[]{0,1};
        int[] dy = new int[]{1,0};

        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(new int[]{x,y, first});
        visited[x][y] = true;
        if(first != map[x][y])cnt++;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int value = cur[2];
            for(int d=0;d<dx.length;d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if(nx<0||ny<0||nx>=x + 8||ny>=y + 8||visited[nx][ny])continue;
                int nextValue = value==0?1:0;
                q.offer(new int[]{nx,ny,nextValue});
                visited[nx][ny] = true;
                if(map[nx][ny]!= nextValue) cnt++;
            }
        }

        return cnt;
    }
}