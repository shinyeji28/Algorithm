/*
* DFS + 메모이제이션 = dp
* 1,1에서 n,n까지 DFS로 가능한 경우의 수 탐색
* n,n에 도착한 경우의 수를 dp[][]에 저장
* 방문 체크
* 다음 갈 곳이 이미 방문 한 곳이면 dp[][]에 있는 경우의 수를 활용
* dp[i][j]는 i,j부터 시작해서 n,n까지 가는데 걸리는 경우의 수
* */
import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        dp = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[n-1][m-1] = 1;
        dfs(0,0);
        System.out.println(dp[0][0]);
    }
    public static void dfs(int x, int y){
        if(visited[x][y])return;
        visited[x][y] = true;
        if(x==n-1 && y==m-1)return;

        for(int d=0;d<dx.length;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0||ny<0||nx>=n||ny>=m)continue;
            if(map[x][y]<=map[nx][ny])continue;
            dfs(nx,ny);
            dp[x][y] += dp[nx][ny];

        }
    }

}