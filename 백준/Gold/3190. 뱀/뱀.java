import java.awt.dnd.DropTarget;
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] map;
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};

    static ArrayDeque<int[]> deq;

    public static class Node{
        int time;
        char rotation;
        public Node(int time, char rotation){
            this.time = time;
            this.rotation = rotation;
        }
    }

    public static Queue<Node> q;
    static boolean done = false;
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;  // 사과
        }
        int l = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();
        for(int i=0;i<l;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            q.offer(new Node(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        System.out.println(solution()+1);
    }
    public static int solution(){

        int d = 0;
        map[0][0] = 1;
        deq = new ArrayDeque<>();

        deq.offerLast(new int[]{0,0});
        int time = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            time += straight(deq.peekLast()[0], deq.peekLast()[1], d,node.time - time);

            if(done)break;
            switch (node.rotation){
                case 'D':
                    d = (d+1) % 4;
                    break;
                case 'L':
                    d = (d+3) % 4;
                    break;
            }

        }
        if(!done){
            time += straight(deq.peekLast()[0], deq.peekLast()[1], d,n);
        }
        return time;
    }
    public static int straight(int x, int y, int d, int time){

//        int nx = x + (node.time - time) + dx[d];
//        int ny = y + (node.time - time) + dy[d];
//        if(nx<0 || ny<0 || nx>=n || ny>=n || map[nx][ny] == 1 ) {
//
//            time += Math.abs(x - nx) + Math.abs(x - nx);
//            break;
//        }

        int i;
        int nx = x;
        int ny = y;

        for(i=0;i<time;i++){
            nx = nx + dx[d];
            ny = ny + dy[d];
            if(nx<0 || ny<0 || nx>=n || ny>=n || map[nx][ny] == 1){
                done = true;
                break;  // 벽에 닿았을 때, 몸에 부딪혔을 때
            }

            if(map[nx][ny]!=2){
                int[] remove = deq.pollFirst();
                map[remove[0]][remove[1]] = 0;
            }
            map[nx][ny] = 1;
            deq.offerLast(new int[]{nx, ny});

        }
        return i;
    }
}