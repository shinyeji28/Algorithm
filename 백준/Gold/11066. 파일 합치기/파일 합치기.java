import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 수

        while (T-- > 0) {
            int K = scanner.nextInt(); // 장의 수
            int[] files = new int[K];
            for (int i = 0; i < K; i++) {
                files[i] = scanner.nextInt();
            }

            System.out.println(minCostToMergeFiles(K, files));
        }
    }

    private static int minCostToMergeFiles(int K, int[] files) {
        int[][] dp = new int[K][K];
        int[] sum = new int[K];

        sum[0] = files[0];
        for (int i = 1; i < K; i++) {
            sum[i] = sum[i - 1] + files[i];
        }

        // 구간 길이에 따른 반복문 (길이 2부터 시작)
        for (int length = 2; length <= K; length++) {
            // 구간의 시작 위치에 따른 반복문
            for (int i = 0; i + length - 1 < K; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // 구간 내 분할 지점에 따른 반복문
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + sum[j] - (i == 0 ? 0 : sum[i - 1]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][K - 1];
    }
}