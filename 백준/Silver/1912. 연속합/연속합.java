import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] sums = new int[n+1];

        // i에서 MAX(새로 시작하는 것, 구간합)
        int answer = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sums[i] = Math.max(sums[i-1] + arr[i], arr[i]);
            answer = Math.max(sums[i], answer);
        }

        System.out.println(answer);
    }
}