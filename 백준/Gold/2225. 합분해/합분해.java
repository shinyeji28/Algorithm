import java.util.Scanner;

public class Main {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[][] dp = new int[K+1][N+1];

        // 초기화: 1개의 숫자로 j를 만드는 방법은 1가지
        for (int j = 0; j <= N; j++) {
            dp[1][j] = 1;
        }

        // DP 점화식 적용
        for (int i = 2; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = (dp[i-1][j] + (j > 0 ? dp[i][j-1] : 0)) % MOD;
            }
        }

        // 결과 출력
        System.out.println(dp[K][N]);
    }
}