import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 달팽이 시계방향
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};

        boolean[] visited = new boolean[n*m];
        int end = n*m;
        int x = 0;
        int y = 0;
        int d = 0;
        int answer = 0;
        visited[0] = true;
        end--;
        while(end > 0){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0||ny<0||nx>=n||ny>=m||visited[nx * m + ny]){
                d = (d+1)%4;
                answer++;
                continue;
            }
            visited[nx * m + ny] = true;
            x = nx;
            y = ny;
            end--;
        }
        System.out.println(answer);
    }
}