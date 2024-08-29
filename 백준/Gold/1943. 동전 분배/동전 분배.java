import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 0; t < 3; t++) {  // 3개의 입력
            int n = Integer.parseInt(br.readLine());  // 동전 종류의 수
            int sum = 0;
            int[] value = new int[n];
            int[] count = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                value[i] = Integer.parseInt(st.nextToken());
                count[i] = Integer.parseInt(st.nextToken());
                sum += value[i] * count[i];
            }

            if (sum % 2 == 1) {  // 총합이 홀수이면 두 부분으로 나눌 수 없다.
                System.out.println(0);
                continue;
            }

            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            for (int i = 0; i < n; i++) {
                int coinValue = value[i];
                int coinCount = count[i];

                for (int j = target; j >= 0; j--) {
                    if (dp[j]) {
                        for (int k = 1; k <= coinCount; k++) {
                            if (j + k * coinValue > target) break;
                            dp[j + k * coinValue] = true;
                        }
                    }
                }
            }

            System.out.println(dp[target] ? 1 : 0);
        }
    }
}