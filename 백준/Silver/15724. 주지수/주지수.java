import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        sum = new int[N+1][M+1];

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<M+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = map[i][j] + sum[i][j-1];
            }
        }
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            sb.append(getSquareSum(sx,sy,ex,ey)).append('\n');
        }

        System.out.println(sb);


    }
    public static int getSquareSum(int sx,int sy,int ex,int ey){
        int total = 0;
        for(int i=sx;i<=ex;i++){
            total += sum[i][ey] - sum[i][sy] + map[i][sy];
        }
        return total;
    }
}