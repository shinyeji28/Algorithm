import java.util.*;
import java.io.*;


// 최장 증가 부분 수열 찾고, 전체 - lis가 이동해야 하는 아이들의 수
// lis : 나 이전 수열에서 나보다 작은 것을 찾아 dp +1
public class Main {
    static int n;
    static int[] numbers;
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1;i<n;i++) {

            for(int j=i-1;j>=0;j--){
                if(numbers[j] > numbers[i]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
          }
        }
        int lis = 0;

        for(int i=0;i<n;i++){
            lis = Math.max(dp[i], lis);
        }
        System.out.println(n-lis);
    }
}