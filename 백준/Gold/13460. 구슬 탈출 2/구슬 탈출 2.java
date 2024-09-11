import java.util.*;
import java.io.*;

/*
 rx, ry일 때 bx,by가 있기 때문에 4차원 배열 사용
* */
public class Main {
    static class Node{
        int rx,ry,bx,by;
        int distance;
        public Node(){};
        public Node(int rx, int ry,int bx,int by, int distance){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.distance = distance;
        }
        public void rSetter(int rx, int ry){
            this.rx = rx;
            this.ry = ry;

        }
        public void bSetter(int bx,int by){
            this.bx = bx;
            this.by = by;
        }
    }
    static char[][] map;
    static int n,m;
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        Node initPos = new Node();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'R'){
                    initPos.rSetter(i,j);
                    map[i][j] = '.';
                }else if(map[i][j] == 'B'){
                    initPos.bSetter(i,j);
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(initPos));
    }
    public static int bfs(Node initPos){


        Queue<Node> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[n][m][n][m];

        q.offer(initPos);
        visited[initPos.rx][initPos.ry][initPos.bx][initPos.by] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.distance >= 10) return -1;

            for (int d = 0; d < 4; d++) {
                int nextRCnt = moving(node.rx, node.ry, d);
                int nextBCnt = moving(node.bx, node.by, d);

                int rx = node.rx + dx[d] *nextRCnt;
                int ry = node.ry + dy[d] *nextRCnt;
                int bx = node.bx + dx[d] *nextBCnt;
                int by = node.by + dy[d] *nextBCnt;

                if(map[bx][by] == 'O') {
                    continue;
                }
                else if(map[rx][ry]=='O') {
                    return node.distance+1;
                }

                if(rx == bx && ry == by){
                    if(nextRCnt > nextBCnt){
                        rx -= dx[d];
                        ry -= dy[d];
                    }else{
                        bx -= dx[d];
                        by -= dy[d];
                    }
                }

                if(visited[rx][ry][bx][by])continue;
                q.offer(new Node(rx, ry, bx, by, node.distance+1));
                visited[rx][ry][bx][by] = true;
            }
        }
        return -1;
    }
    public static int moving(int x, int y, int d) {
        int nx = x;
        int ny = y;
        int cnt=0;
        while(true){
            nx += dx[d];
            ny += dy[d];
            if(map[nx][ny]=='#')break;
            if(map[nx][ny]=='O'){
                cnt++;
                break;
            }
            cnt++;
        }
        return cnt;
    }
}