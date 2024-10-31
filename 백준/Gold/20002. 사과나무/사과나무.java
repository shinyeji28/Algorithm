import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n;
    static int[][] prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적 합
        prefixSum = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                prefixSum[i][j] = (j-1>=0?prefixSum[i][j-1] : 0) + map[i][j];
            }
        }

        int result = Integer.MIN_VALUE;;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, saveValue(i, j));
            }
        }
        System.out.println(result);
    }
    public static int saveValue(int x, int y){
        int maxValue = map[x][y];
        int end = n-Math.max(x,y);
        for(int j=0 ;j<end;j++){
            int sum = 0;

            for(int i=0;i<=j;i++){
                sum += (prefixSum[x + i][y + j] - (y-1>=0?prefixSum[x + i][y-1]:0));
            }
            maxValue = Math.max(maxValue, sum);
        }
        return maxValue;
    }
}