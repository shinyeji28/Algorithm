import java.io.IOException;

/*
* BFS로 각 지점을 중심으로 계산하기
* */
import java.util.*;
import java.io.*;
public class Solution {
    public static class House{
        int x,y;
        public House(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] map;
    static int n,m, result, finalHouse;

    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new boolean[n][n];
            finalHouse = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    map[i][j] = Integer.parseInt(st.nextToken()) == 1;
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    bfs(i, j);
                }
            }
            System.out.println("#"+(t+1)+" "+finalHouse);
        }
    }

    private static void bfs(int x, int y) {
        Queue<House> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        int cnt = (map[x][y]?1:0);
        int depth = 0;
        q.offer(new House(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            depth++;
            int value = cnt * m - (depth*depth + (depth-1) * (depth-1));
            if(value>=0){
                finalHouse = Math.max(finalHouse, cnt);
            }
            int size = q.size();
            for(int s=0;s<size;s++){
                House pos = q.poll();
                for(int d=0;d<4;d++){
                    int nx = pos.x + dx[d];
                    int ny = pos.y + dy[d];
                    if(nx<0||ny<0||nx>=n||ny>=n||visited[nx][ny])continue;
                    q.offer(new House(nx,ny));
                    visited[nx][ny] = true;
                    if(map[nx][ny]) cnt++;
                }
            }

        }
    }
}