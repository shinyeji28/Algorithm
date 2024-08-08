/*
    1. start -> 레버 까지 최단 구하기
    2. 레버 -> exit 까지 최단 구하기
    
    BFS
*/

import java.util.*;
class Solution {

    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2];
        int[] exit = new int[2];
        int[] lever = new int[2];
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                if(maps[i].charAt(j) == 'S' ) {
                    start[0]=i;
                    start[1]=j;
                }else if(maps[i].charAt(j) == 'E' ) {
                    exit[0]=i;
                    exit[1]=j;
                }else if(maps[i].charAt(j) == 'L' ) {
                    lever[0]=i;
                    lever[1]=j;
                }
            }
        }
        int re = bfs(start, lever, maps);
        if(re==-1)return -1;
        answer += re;
        re = bfs(lever, exit, maps);
        if(re<=-1)return -1;
        answer += re;
        return answer;
    }
    public static int bfs(int[] start, int[] exit,String[] maps){
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[][] distance = new int[maps.length][maps[0].length()];
        
        for(int i=0;i<distance.length;i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        
        q.offer(new int[] {start[0], start[1]});
        visited[start[0]][start[1]] = true;
        distance[start[0]][start[1]] = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(exit[0] == x && exit[1] == y){
                return distance[x][y];
            }
            for(int d = 0;d<dx.length;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length()||visited[nx][ny]|| maps[nx].charAt(ny)=='X')continue;
                if(distance[nx][ny] > distance[x][y] + 1){
                    distance[nx][ny] = distance[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}