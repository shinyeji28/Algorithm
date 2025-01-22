/*
 * 규칙 (역순)
 * 하 우 상 좌
 * 숫자나 map을 이탈하면 방향 변경
 * */

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};

        int[][] table = new int[n][n];
        int[] targetPos = new int[2];
        int num = n*n;
        int x = 0;
        int y = 0;
        int d = 0;
        table[0][0] = num--;
        while(num >= 1){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0 || ny<0 || nx>=n||ny>=n || table[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            table[nx][ny] = num;
            if(target == num){
                targetPos[0] = nx;
                targetPos[1] = ny;
            }
            num--;
            x = nx;
            y = ny;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(table[i][j]+" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
        System.out.println((targetPos[0]+1)+" "+(targetPos[1]+1));
    }
}