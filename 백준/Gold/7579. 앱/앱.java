import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] m = new int[N];
        int[] c = new int[N];
        StringTokenizer mList = new StringTokenizer(br.readLine());
        StringTokenizer cList = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(mList.nextToken());
            c[i] = Integer.parseInt(cList.nextToken());
        }

        int maxCost = 100 * N; // 최대 비용을 N * 100으로 설정
        int[] dp = new int[maxCost + 1];
        Arrays.fill(dp, 0);

        for (int i = 0; i < N; i++) {
            int mi = m[i];
            int ci = c[i];
            for (int j = maxCost; j >= ci; j--) {
                dp[j] = Math.max(dp[j], dp[j - ci] + mi);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= maxCost; i++) {
            if (dp[i] >= M) {
                result = Math.min(result, i);
            }
        }
        System.out.println(result);
    }
}