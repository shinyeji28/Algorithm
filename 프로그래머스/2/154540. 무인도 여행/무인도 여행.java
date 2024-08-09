import java.util.*;
import java.io.*;
class Solution {
    static boolean[][] visited;
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)!='X' && !visited[i][j]){
                   int sum = bfs(i,j, maps);
                    pq.add(sum);
                }
            }
        }
        if(pq.size()==0)return new int[]{-1};
        int[] answer = new int[pq.size()];
        for(int i=0;i<answer.length;i++){
        
            answer[i] = pq.poll();
        }
        return answer;
    }
    public static int bfs(int cx,int cy, String[] maps){
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        q.offer(new int[]{cx,cy});
        visited[cx][cy] = true;
        int sum = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(maps[x].charAt(y)=='X')continue;
            sum += Integer.parseInt(maps[x].charAt(y)+"");
            for(int d=0;d<dx.length;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length()||visited[nx][ny]||maps[nx].charAt(ny)=='X')continue;
                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
        return sum;
    }
}