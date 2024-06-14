import java.util.*;
import java.io.*;

public class Main {
    static int cnt, time;
    static final int MAXSIZE = 100000;
    static int[][] dp = new int[2][MAXSIZE + 1];

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);
        System.out.println(dp[0][k]);
        System.out.println(dp[1][k]);
    }

    public static void bfs(int n, int k) {
        boolean[] visited = new boolean[MAXSIZE + 1];
        Arrays.fill(dp[0], MAXSIZE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;
        dp[0][n] = 0;
        dp[1][n] = 1; // 시작 위치의 방법 수는 1

        while (!q.isEmpty()) {
            int idx = q.poll();
            int currentTime = dp[0][idx];

            int[] next = new int[]{idx - 1, idx + 1, idx * 2};
            for (int i : next) {
                if (i < 0 || i > MAXSIZE) continue;

                if (!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    dp[0][i] = currentTime + 1;
                    dp[1][i] = dp[1][idx]; // 새로운 위치에 처음 도달하는 방법의 수
                } else if (dp[0][i] == currentTime + 1) {
                    dp[1][i] += dp[1][idx]; // 같은 시간에 도달하는 추가적인 방법의 수
                }
            }
        }
    }
}