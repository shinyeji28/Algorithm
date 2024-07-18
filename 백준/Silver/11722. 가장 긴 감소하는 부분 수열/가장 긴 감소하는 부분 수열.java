import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Integer[] dp = new Integer[n];
        Arrays.fill(dp,1);
        for(int i=1;i<dp.length;i++){
            int maxValue = 1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]<arr[j]){
                     maxValue = Math.max(maxValue, dp[j]+1);
                }else if(arr[i]==arr[j]){
                    maxValue = Math.max(maxValue, dp[j]);
                }
                dp[i] = maxValue;
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}