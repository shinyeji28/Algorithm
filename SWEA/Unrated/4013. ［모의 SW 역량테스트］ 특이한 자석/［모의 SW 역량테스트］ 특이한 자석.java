/*
* dfs
* pointer 이동 전에 다음 depth에 마주보는 n,s를 넘겨주기
* 시계 방향 회전 : pointer 왼쪽으로 이동
* 반시계 방향 회전 : pointer 오른쪽으로 이동
* */
import java.io.*;
import java.util.*;
public class Solution {
    public static class Rotation{
        int num;
        boolean isRight;
        public Rotation(int num, boolean isRight){
            this.num = num;
            this.isRight = isRight;
        }
    }
    static boolean[][] wheels;
    static Queue<Rotation> q = new ArrayDeque<>();
    static int[] pointers;
    static final int N = 8;
    static boolean[] visited;

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int k = Integer.parseInt(br.readLine());
            wheels = new boolean[4][N];
            pointers = new int[4];
            visited = new boolean[4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    wheels[i][j] = Integer.parseInt(st.nextToken()) == 1;
                }
            }
            for(int i=0;i<k;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken())-1;
                boolean isRight = Integer.parseInt(st.nextToken()) == 1;  // 1: 시계방향
                q.offer(new Rotation(num,isRight));
            }
            while(!q.isEmpty()){
                Rotation cur = q.poll();
                visited = new boolean[4];
                dfs(cur.num, cur.isRight);
            }
            int result = 0;
            for(int i=0;i<4;i++){
                if(wheels[i][pointers[i]]){
                    result += (1<<i);
                }
            }
            sb.append("#"+t+" "+result).append('\n');
        }
        System.out.println(sb);
    }
    // isRight : 회전 방향
    public static void dfs(int idx, boolean isRight){
        visited[idx] =true;
        boolean right = wheels[idx][(pointers[idx]+2)%N];
        boolean left = wheels[idx][(pointers[idx]+6)%N];

        if(isRight) pointers[idx] = (pointers[idx]+7)%N;
        else pointers[idx] = (pointers[idx]+1)%N;

        if((idx+1)<4 && !visited[idx+1] && right != wheels[idx+1][(pointers[idx+1]+6)%N]){
            dfs(idx+1, !isRight);

        }
        if((idx-1)>=0 && !visited[idx-1] && left != wheels[idx-1][(pointers[idx-1]+2)%N]){
            dfs(idx-1, !isRight);
        }


    }
}