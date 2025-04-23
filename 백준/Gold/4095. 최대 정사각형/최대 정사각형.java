import java.util.*;
import java.io.*;
public class Main {
    static final int MOD = 1000000000;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n==0 && m==0)break;

            int[][] map = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 누적합
            int[][] sums = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + map[i][j];
                }
            }

            int maxSize = 0;
            // 정사각형으로 탐색
            for (int sx = 1; sx <= n; sx++) {
                for (int sy = 1; sy <= m; sy++) {
                    for (int k = 0; k + sx <= n && k + sy <=m; k++) { // 대각 끝 좌표
                        int ex = sx + k;
                        int ey = sy + k;
                        int size = ex - sx + 1;

                        // 1로 채워진 정사각형인지 확인
                        int partSum = sums[ex][ey] - sums[sx - 1][ey] - sums[ex][sy - 1] + sums[sx - 1][sy - 1];
                        if (partSum == size * size) {
                            // 가장 큰 size 업데이트
                            maxSize = Math.max(maxSize, size);
                        }else{
                            break;
                        }
                    }
                }
            }
            sb.append(maxSize).append('\n');
        }
        System.out.println(sb);
    }
}