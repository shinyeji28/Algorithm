/*
* 섬찾기 문제
* BFS 후
* 오름 차순 정렬
* */

import java.io.*;
import java.util.*;
public class Main {
    static char[][] map;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    static boolean[][] visited;
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            map[i] = str.toCharArray();
        }
        int cnt = 0;
        List<Integer> sorting = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && map[i][j]=='1'){
                    cnt++;
                    sorting.add(bfs(i,j));
                }
            }
        }
        Collections.sort(sorting);
        for(int no : sorting){
            sb.append(no).append('\n');
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
    public static int bfs(int cx, int cy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cx,cy});
        visited[cx][cy] = true;
        int cnt=0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt++;
            int x = cur[0];
            int y = cur[1];
            for(int d=0;d<dx.length;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0||ny<0||nx>=map.length||ny>=map[0].length||visited[nx][ny]||map[nx][ny]=='0')continue;
                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
        return cnt;
    }
}