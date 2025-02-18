/*
    1. 각 덩어리의 크기를 구함, 덩어리 내 구역의 임시 열에 덩어리 크기를 저장 (중복 방지를 위함)
    2. 최종 열 += 임시 열
    3. 최종 열 중 최대 값 출력
*/

import java.util.*;
class Solution {
    static boolean[][] visited;
    static boolean[] isOil;  // 석유가 있는 열 위치에 체크 
    public int solution(int[][] land) {
        
        int result = 0;
        int rSize = land.length;
        int cSize = land[0].length;
        visited = new boolean[rSize][cSize];
        
        int[] countingOil = new int[cSize];
        
        for(int i=0;i<rSize;i++){
            for(int j=0;j<cSize;j++){
                if(land[i][j]==1 && !visited[i][j]){
                    isOil = new boolean[cSize];
                    int sum = detectOil(i,j, land);
                    
                    for(int k=0;k<cSize;k++){
                        if(isOil[k])countingOil[k] += sum;
                    }
                }
            }
        }
        
        for(int i=0;i<cSize;i++){
            result = Math.max(countingOil[i],result);
        }
        return result;
    }
    //bfs
    public static int detectOil(int cx, int cy, int[][] land){
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{cx,cy});
        visited[cx][cy] = true;
        int sum = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            isOil[y] = true;
            sum++;
            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0||ny<0||nx>=land.length||ny>=land[0].length|| visited[nx][ny]||land[nx][ny]==0)continue;
                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
                
            }
        }
        return sum;
    }
}