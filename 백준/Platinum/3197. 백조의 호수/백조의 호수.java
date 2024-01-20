/*
* 백조가 만나면 종료
* 백조가 만나는지 탐색 - BFS
* 1. 얼음이 있는 공간 저장
* 2. 얼음이 있는 공간부터 BFS탐색하여 (얼음과 닿지 않는 물이면 방문처리 후 pop)
*   3. 물과 만나면 얼음공간을 저장 후 표시
* 4. 저장된 얼음 공간을 물로 바꾸기
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int c,r;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> water = new ArrayDeque<>();
    static int day;
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static Queue<int[]> dontGo = new ArrayDeque<>();
    static List<int[]> toWater = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0;j<c;j++){
                map[i][j]  = str.charAt(j);
                if(map[i][j]!='X'){
                    water.offer(new int[]{i,j});  // 물 저장
                }
                if(map[i][j] == 'L'){
                    dontGo.offer(new int[]{i,j});
                }
            }
        }
        visited = new boolean[r][c];
        dontGo.poll();
        A:while(true){
            int size1 = dontGo.size();
            for(int a=0;a<size1;a++){
                int[] swan = dontGo.poll();
                if(able_meet(swan[0],swan[1])) break A;
            }
            day++;
            int size = water.size();
            int x,y,nx,ny;
            for(int i=0;i<size;i++){
                int[] pos = water.poll();
                x = pos[0];
                y = pos[1];
                for(int d=0;d<4;d++) {
                    nx = x + dx[d];
                    ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || map[nx][ny]=='V') continue;
                    if (map[nx][ny] == 'X') {
                        toWater.add(new int[]{nx ,ny});
                        map[nx][ny] = 'V';
                    }
                }

            }

            // for water 물로 바꾸기
            for(int i=0;i<toWater.size();i++){
                int cx = toWater.get(i)[0];
                int cy = toWater.get(i)[1];
                map[cx][cy] = '.';
                water.offer(new int[]{cx,cy});
            }
            toWater = new ArrayList<>();
        }

        System.out.println(day);

    }

    public static boolean able_meet(int cx, int cy){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{cx,cy});
        visited[cx][cy] = true;
        int x,y,nx,ny;

        while(!q.isEmpty()){
            int[] pos = q.poll();
            x = pos[0];
            y = pos[1];
            for(int d=0;d<4;d++){
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length || visited[nx][ny] )continue;
                if(map[nx][ny]=='L')return true;
                    // 막힌 부분 저장
                if(map[nx][ny]=='X' ){
                    dontGo.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    continue;
                }

                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
        return false;
    }



}