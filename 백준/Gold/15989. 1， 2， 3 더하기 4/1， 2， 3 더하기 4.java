import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int endTarget = 0;
        for(int t=0;t<T;t++){
            arr[t] = Integer.parseInt(br.readLine());
            endTarget = Math.max(arr[t], endTarget);
        }

        int[] dp = new int[endTarget+1];


        dp[0] = 1;
        for(int i=1;i<=3;i++){
            for(int j=i;j<=endTarget;j++){
                dp[j] += dp[j-i];
            }
        }
        for(int num : arr){
            sb.append(dp[num]).append('\n');
        }
        System.out.println(sb);

    }

}