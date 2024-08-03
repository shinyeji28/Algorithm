import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[100][100];
        for(int z=0;z<n;z++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i=x;i<x+10;i++){
                for(int j=y;j<y+10;j++){
                    map[i][j] = true;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(map[i][j])cnt++;
            }
        }
        System.out.println(cnt);
    }
}