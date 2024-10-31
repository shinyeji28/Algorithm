import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n;
    static int[][] prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2차원 배열 누적 합
        // y축으로 이전 sum 누적 , x축으로 이전 sum 누적
        prefixSum = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                prefixSum[i][j] = map[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                result = Math.max(result, maxValueForSquare(i,j));
            }
        }
        System.out.println(result);
    }


    // 정사각형 합 구하기
    // x ,y 시작 좌표, k : 넓이 증가를 위함 (x+k, y+k)
    // sum끝점 - sum[x][y-1] - sum[x-1][y] + sum시작점 대각 prev (x-1, y-1)
    public static int maxValueForSquare(int x, int y){
        int maxValue = Integer.MIN_VALUE;
        int end = n-Math.max(x,y);
        for(int i=0;i<=end;i++){
            int square = prefixSum[x+i][y+i] - prefixSum[x-1][y + i] - prefixSum[x + i][y-1] + prefixSum[x-1][y-1];
            maxValue = Math.max(maxValue, square);
        }
        return maxValue;
    }
}
