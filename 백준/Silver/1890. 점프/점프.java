/*
  * dfs + 최종 지점에 도달 가능한 point의 경우의 수를 기록하여 중복을 제거
  * */
 import java.util.*;
 import java.io.*;
 public class Main {
     static int[][] map;
     static int n;
     static int[] dx = new int[]{0,1};
     static int[] dy = new int[]{1,0};
     static int cnt = 0;
     static long[][] cases;
     public static void main(String[] agrs)throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
         map = new int[n][n];
         cases = new long[n][n];  // 경우의 수 저장
         for(int i=0;i<n;i++){
             StringTokenizer st = new StringTokenizer(br.readLine());
             for(int j=0;j<n;j++){
                 map[i][j] = Integer.parseInt(st.nextToken());
             }
         }
         cases[n-1][n-1] = 1;
         dfs(0,0);
         System.out.println(cases[0][0]);
     }
     public static void dfs(int x, int y){
         if((x == n-1 && y == n-1) || map[x][y] == 0 ||cases[x][y]!=0){
             return;
         }

         for(int d=0;d<2;d++){
             int nx = x + map[x][y] * dx[d];
             int ny = y + map[x][y] * dy[d];
             if(nx<0||ny<0||nx>=n||ny>=n)continue;

             dfs(nx,ny);
             cases[x][y] += cases[nx][ny];
         }
     }
 }