import java.util.*;
import java.io.*;
public class Main {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][][] dx = new int[][][]{
            {},
            {{0},{1},{0},{-1}},
            {{0,0},{-1,1}},
            {{-1,0},{0,1},{1,0},{0,-1}},
            {{0,-1,0},{-1,0,1},{0,1,0},{1,0,-1}},
            {{0,-1,0,1}}
    };
    static int[][][] dy = new int[][][]{
            {},
            {{1},{0},{-1},{0}},
            {{-1,1},{0,0}},
            {{0,1},{1,0},{0,-1},{-1,-0}},
            {{-1,0,1},{0,1,0},{1,0,-1},{0,-1,0}},
            {{-1,0,1,0}}
    };
    static int[][] map;
    static List<Node> cctv;
    static boolean[][] visited;
    static int[] rotationIdx;
    static int n,m;
    static int cctvRange;
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cctv = new ArrayList<>();
        int total = n*m;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if(input>=1 && input<=5) cctv.add(new Node(i,j));
                if(input!=0){
                    total--;
                }
            }
        }
        rotationIdx = new int[cctv.size()];
        combination(0);

        System.out.println(total - cctvRange);
    }
    // 회전하기
    public static void combination(int depth){
        if(depth == cctv.size()){
            checkRange();
            return;
        }
        Node node = cctv.get(depth);
        int num = map[node.x][node.y];
        for(int i=0;i<dx[num].length;i++){
            rotationIdx[depth] = i;
            combination(depth+1);
        }
    }
    public static void checkRange() {
        int cnt = 0;
        visited = new boolean[n][m];

        for (int i = 0; i < rotationIdx.length; i++) {
            Node node = cctv.get(i);
            int cx = node.x;
            int cy = node.y;
            int num = map[cx][cy];
            int rotation = rotationIdx[i];

            for (int d = 0; d < dx[num][rotation].length; d++) {

                int nx = cx;
                int ny = cy;
                while (true) {
                    nx = nx + dx[num][rotation][d];
                    ny = ny + dy[num][rotation][d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 6) break;
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 0) cnt++;
                }
            }
            cctvRange = Math.max(cctvRange, cnt);
        }
    }
}