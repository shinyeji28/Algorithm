/*
    아이디어>
        1) 별똥별이 떨어질 지점이 L*L정사각형의 모서리로 여김 -> 4가지 영역에 속하는지 판단(1,2,3,4분면)
            별똥별 point를 (0,0)으로 하여 1,2,3,4분면에 속하는 Max값 찾기
            O(k*4*k);

            --> 이 아이디어는 틀린답; 트랜펄린의 모서리가 아닌 변에만 별동별이 있을 때 구할 수 없는 아이디어
        2) 별동별 point를 기준으로 하나의 x ~ x + l에 대해 y ~ y + l로 모든 각 별동별에 대한 모든 경우의 수를 구한다.

*/

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] point = new int[2][k];
        int maxValue = 0;
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point[0][i] = x;
            point[1][i] = y;
        }
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                int startX = point[0][i];
                int startY = point[1][j];

                int cnt=0;
                for(int z = 0;z <k ;z++){
                    if(startX <= point[0][z] && point[0][z] <= startX +l && startY <=point[1][z] && point[1][z] <= startY+l) cnt++;
                }
                maxValue = Math.max(maxValue, cnt);

            }
        }
        System.out.println(k-maxValue);
    }
}