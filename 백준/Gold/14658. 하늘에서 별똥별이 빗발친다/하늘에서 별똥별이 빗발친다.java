import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] points = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxValue = 0;

        // 모든 별똥별을 기준으로 트램펄린을 배치할 수 있는 위치를 고려
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int startX = points[i][0];
                int startY = points[j][1];
                int cnt = 0;

                // 트램펄린 내에 포함되는 별똥별의 수를 계산
                for (int p = 0; p < k; p++) {
                    if (startX <= points[p][0] && points[p][0] <= startX + l &&
                        startY <= points[p][1] && points[p][1] <= startY + l) {
                        cnt++;
                    }
                }
                maxValue = Math.max(maxValue, cnt);
            }
        }

        // 지구에 부딪히는 별똥별의 수 = 전체 별똥별 수 - 트램펄린이 포함할 수 있는 최대 별똥별 수
        System.out.println(k - maxValue);
    }
}