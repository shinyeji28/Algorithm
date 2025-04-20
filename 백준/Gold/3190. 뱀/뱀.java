
    import java.io.*;
    import java.util.*;

    public class Main{
        static int[] dx = new int[]{0,1,0,-1};
        static int[] dy = new int[]{1,0,-1,0};
        static Queue<int[]> direction;
        static int n;
        static ArrayDeque<int[]> snake = new ArrayDeque<>();
        static int[][] map;
        static int time=0;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            map = new int[n][n];

            for(int i=0;i<k;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken())-1;

                map[r][c] = 1; // 사과
            }
            int l = Integer.parseInt(br.readLine());
            direction = new ArrayDeque<>();
            for(int i=0;i<l;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int t = Integer.parseInt(st.nextToken());
                int d = (st.nextToken().charAt(0) == 'D')? 1 : 3;
                direction.offer(new int[]{t,d});
            }
            move();
            System.out.println(time+1);

        }
        public static void move(){

            snake.offer(new int[]{0,0});
            map[0][0] = 2; // 스네이크
            int dir = 0;

            while(!direction.isEmpty()){
                int[] cur = direction.poll();
                int t = cur[0];
                int d = cur[1];
                while(time < t){
                    // 직진이동
                    if(!goStraight(dir)) return;
                }
                // 방향 회전
                dir = (dir + d) % 4;
            }
            while(true) {
                if(!goStraight(dir)) return;
            }


        }
        public static boolean goStraight(int dir){
            int[] pos = snake.peekFirst();
            int x = pos[0];
            int y = pos[1];

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx<0||ny<0||nx>=n||ny>=n || map[nx][ny] == 2) {
                return false;
            }
            // 사과를 안 먹으면 꼬리 제거
            if(map[nx][ny] != 1){
                int[] cur = snake.pollLast();
                map[cur[0]][cur[1]] = 0;
            }
            snake.offerFirst(new int[]{nx,ny});
            map[nx][ny] = 2;
            time++;

            return true;
        }
    }