//import java.util.*;
//import java.io.*;
//
///*
//* 서로가 영향을 받을 수 있기 때문에 최단 거리를 별로도 구하면 안됨
//* 같이 이동하되 distance를 별도로 저장 distance[][]; visited[][];
//* */
//public class Main {
//    static class Node{
//        int rx,ry,bx,by;
//        public Node(){};
//        public Node(int rx, int ry,int bx,int by){
//            this.rx = rx;
//            this.ry = ry;
//            this.bx = bx;
//            this.by = by;
//        }
//        public void rSetter(int rx, int ry){
//            this.rx = rx;
//            this.ry = ry;
//
//        }
//        public void bSetter(int bx,int by){
//            this.bx = bx;
//            this.by = by;
//        }
//    }
//    static char[][] map;
//    static int n,m;
//    static int[] dx = new int[]{0,0,1,-1};
//    static int[] dy = new int[]{1,-1,0,0};
//
//    public static void main(String[] agrs) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        map = new char[n][m];
//        Node initPos = new Node();
//        for(int i=0;i<n;i++){
//            st = new StringTokenizer(br.readLine());
//            String str = st.nextToken();
//            for(int j=0;j<m;j++){
//                map[i][j] = str.charAt(j);
//
//                if(map[i][j] == 'R'){
//                    initPos.rSetter(i,j);
//                    map[i][j] = '.';
//                }else if(map[i][j] == 'B'){
//                    initPos.bSetter(i,j);
//                    map[i][j] = '.';
//                }
//            }
//        }
//
//        System.out.println(bfs(initPos));
//    }
//    public static int bfs(Node initPos){
//
//
//        int result = 0;
//        int cnt = 0;
//        Queue<Node> q = new ArrayDeque<>();
//        boolean[][][] visited = new boolean[2][n][m]; // 0 r, 1 b
//        int[][][] distance = new int[2][n][m];
//
//        for(int i=0;i<n;i++) {
//            Arrays.fill(distance[0][i],Integer.MAX_VALUE);
//            Arrays.fill(distance[1][i],Integer.MAX_VALUE);
//        }
//        q.offer(initPos);
//        distance[0][initPos.rx][initPos.ry] = distance[1][initPos.bx][initPos.by] = 0;
//        visited[0][initPos.rx][initPos.ry] = visited[1][initPos.bx][initPos.by] = true;
//
//        while(!q.isEmpty()){
//            int size = q.size();
//            cnt++;
//            if(cnt >= 11) {
//                result = -1;
//                return result;
//            }
//            for(int s =0;s<size;s++) {
//                Node node = q.poll();
//                for (int d = 0; d < 4; d++) {
//                    int[] dis = moving(node.rx, node.ry, node.bx, node.by, d);
//
//                    int rx = node.rx + dx[d] * dis[0];
//                    int ry = node.ry + dy[d] * dis[0];
//                    int bx = node.bx + dx[d] * dis[1];
//                    int by = node.by + dy[d] * dis[1];
//                    if(dis[2] == -1) return -1;
//                    else if(dis[2] == 1) return distance[0][node.rx][node.ry]+1;
//
//                    if(dis[0]==0 && dis[1]==0) continue;
//
//
//                    if(visited[0][rx][ry] && visited[1][bx][by])continue;
//                    distance[0][rx][ry] = distance[0][node.rx][node.ry] + 1;
//                    distance[1][bx][by] = distance[1][node.bx][node.by] + 1;
//                    q.offer(new Node(rx, ry, bx, by));
//                    visited[0][rx][ry] = true;
//                    visited[1][bx][by] = true;
//
//
//                }
//            }
//
//        }
//        return result;
//    }
//    public static int[] moving(int rx, int ry, int bx, int by, int d){
//
//        int rCnt = 0;
//        int bCnt = 0;
//        boolean rStop = false;
//        boolean bStop = false;
//        boolean rhole = false;
//        boolean bhole = false;
//        int hole = 0;
//
//        while(!rStop || !bStop){
//            if(!rStop){
//                rx = rx + dx[d];
//                ry = ry + dy[d];
//            }
//            if(!bStop){
//                bx = bx + dx[d];
//                by = by + dy[d];
//            }
//            if(map[rx][ry] == 'O'){
//                rhole = true;
//                rStop = true;
//                hole = 1;
//            }
//            if(map[bx][by] == 'O'){
//                bhole = true;
//                bStop = true;
//            }
//
//            if(map[rx][ry] == '.') rCnt++;
//            else rStop = true;
//            if(map[bx][by] == '.') bCnt++;
//            else bStop = true;
//        }
//        if(bhole){
//            hole = -1;
//        }
//        if(rx == bx && ry == by){
//            if(rCnt > bCnt){
//                rCnt--;
//            }else{
//                bCnt--;
//            }
//        }
//        return new int[]{rCnt, bCnt, hole};
//    }
//}

import java.util.*;
import java.io.*;

public class Main{
    static class Node{
        int rx,ry,bx,by;
        int dis;
        public Node(){};
        public Node(int rx, int ry,int bx,int by, int dis){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.dis = dis;
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
    static int n, m;
    static int[] dx = {0, 0, 1, -1}; // 상, 하, 좌, 우
    static int[] dy = {1, -1, 0, 0};

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
        int[][][][] distance = new int[n][m][n][m];

        q.offer(initPos);
        visited[initPos.rx][initPos.ry][initPos.bx][initPos.by] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            // 10번 이상 움직이면 실패
            if(node.dis >= 10) return -1;

            for(int d = 0; d < 4; d++){
                int[] nextRed = move(node.rx, node.ry, d);
                int[] nextBlue = move(node.bx, node.by, d);

                int nrx = nextRed[0];
                int nry = nextRed[1];
                int nbx = nextBlue[0];
                int nby = nextBlue[1];

                // 파란 구슬이 구멍에 빠지면 실패
                if(map[nbx][nby] == 'O') continue;

                // 빨간 구슬이 구멍에 빠지면 성공
                if(map[nrx][nry] == 'O') return node.dis + 1;

                // 두 구슬이 같은 위치에 있으면
                if(nrx == nbx && nry == nby){
                    if(nextRed[2] > nextBlue[2]){
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else {
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }

                // 새로운 상태가 방문된 적이 없으면 큐에 삽입
                if(!visited[nrx][nry][nbx][nby]){
                    visited[nrx][nry][nbx][nby] = true;
                    q.offer(new Node(nrx, nry, nbx, nby, node.dis + 1));
                }
            }
        }

        return -1; // 10번 이내에 성공하지 못한 경우
    }

    // 구슬을 한 방향으로 움직이는 함수
    public static int[] move(int x, int y, int d){
        int dist = 0;
        while(map[x + dx[d]][y + dy[d]] != '#' && map[x][y] != 'O'){
            x += dx[d];
            y += dy[d];
            dist++;
        }
        return new int[]{x, y, dist};
    }
}