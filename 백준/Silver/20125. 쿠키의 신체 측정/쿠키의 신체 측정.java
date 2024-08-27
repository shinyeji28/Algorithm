import java.util.*;
import java.io.*;
public class Main {
    static char[][] map;
    static StringBuilder sb;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        int[] head = new int[]{-1,-1};
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0;j<n;j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == '*' && head[0]==-1){
                    head[0] = i;
                    head[1] = j;
                }
            }
        }
        sb.append(head[0]+2).append(" ").append(head[1]+1).append('\n');

        int waist = counting(head[0]+1,head[1]);
        countingLegs(head[0]+1 + waist,head[1], 1,-1);
        countingLegs(head[0]+1 + waist,head[1], 1,1);

        System.out.println(sb);
    }
    public static int counting(int cx, int cy){
        int[] dx = new int[]{0,0,1};
        int[] dy = new int[]{-1,1,0};
        int cnt = 0;

        for(int d=0;d<3;d++){
            int x = cx;
            int y = cy;
            cnt = 0;
            while(true){
                x = x + dx[d];
                y = y + dy[d];
                if(x<0|| y<0||x>=map.length||y>=map[0].length||map[x][y]=='_')break;
                cnt++;
            }
            sb.append(cnt+" ");
        }
        return cnt;
    }
    public static void countingLegs(int cx, int cy, int dx, int dy){

            int x = cx + dx;
            int y = cy + dy;
            if(x<0|| y<0||x>=map.length||y>=map[0].length||map[x][y]=='_') {
                sb.append(0+" ");
                return;
            }


            int cnt = 1;
            while(true){
                x = x + 1;
                if(x<0|| x>=map.length||map[x][y]=='_')break;
                cnt++;
            }
            sb.append(cnt+" ");


    }

}