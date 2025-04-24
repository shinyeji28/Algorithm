import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int[] arr = new int[n+1];
        long[] sums = new long[n+1];  // 누적합


        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sums[i] = arr[i] + sums[i-1];

        }

        // 이전에 현재누적합 - k가 이전에 몇번 나왔는지 , 그만큼 k를 만족하는 부분합이다
        long answer = 0;
        HashMap<Long, Long> dp = new HashMap<>();
        dp.put(0L,1L);
        for(int i=1;i<=n;i++){
            answer += dp.getOrDefault(sums[i] - k, 0L);
            dp.put(sums[i], dp.getOrDefault(sums[i], 0L)+1L);
        }
        System.out.println(answer);



    }
}