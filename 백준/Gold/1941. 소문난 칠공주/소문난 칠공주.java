/*
* 소문난 칠공주
* 각 그룹은 7명의 여학생들
* 칠공주는 가로세로 인접
* 이다솜파가 4명이상 존재
*
*
* 방법 >
* 1)
* 1. 인접한 7개 bfs를 통해 확인
* 2. 남은개수 + S가 < 4 탐색 종료
* -> 먼저 인접한 것을 찾으면 방문했던 경우를 또 방문하는 경우가 너무 많아짐
* 2)
* 1. 2차원 행렬을 1차원으로 만들기 (0~24까지를 x=i/5, y=i%5) -> 반대는 (x * size + y)
* 2. 7개를 뽑기
* 3. 인접한지 확인 (백트래킹)
* 4. 남은개수 + S가 < 4 탐색 종료
*
* 시간 복잡도 >
*     O(25C7 *7)
*
*
* */
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    final static int size = 5;
    static char[][] map = new char[size][size];
    static boolean[] selected = new boolean[size*size];
    static int[][] pos = new int[7][2];
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<size;i++){
            String st = br.readLine();                          // readLine() : String으로 받음
            map[i] = st.toCharArray();                          // toCharArray() : String을 Array의 char으로 변경
        }
        combination(0, 0, 0);
        System.out.println(result);
    }
    public static void combination(int start, int depth, int sCount){

        // 'S'>=4이상 될 수 없으면 백트래킹
        if(sCount + (7-depth) < 4)return;
        // 인접한지 체크
        if(depth == 7){
            if(checkAdjacency()) {
                result++;
            }
            return;
        }
        // 7개 뽑기
        for(int i=start;i<size*size;i++){
            int x = i/size;                                        // 2차원 행렬을 1차원으로 변경 x: i / size, y : i % size
            int y = i%size;
            selected[i] = true;
            pos[depth][0] = x;
            pos[depth][1] = y;
            if(map[x][y] == 'S'){
                combination(i+1, depth+1,sCount+1);
            }else{
                combination(i+1, depth+1,sCount);
            }
            selected[i] = false;
        }
    }
    public static boolean checkAdjacency(){
        // bfs로 인접한지 확인
        boolean[][] visited = new boolean[size][size];
        Queue<int[]> q = new ArrayDeque<>();
        int cnt=1;
        q.add(new int[]{pos[0][0],pos[0][1]});
        visited[pos[0][0]][pos[0][1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int d = 0;d < dx.length;d++){
                int nx = x + dx[d], ny = y + dy[d];
                if(nx<0 || ny<0 || nx>=size || ny>=size || visited[nx][ny] || !selected[nx * size + ny])continue;     // x,y로 일차원 번호 얻는 방법은 x * size + y
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }
        return cnt==7;  // 주의 while문 안에서 조건을 체크하면 isEmpty로 조건을 수행할 수 없는 경우가 발생
    }
}