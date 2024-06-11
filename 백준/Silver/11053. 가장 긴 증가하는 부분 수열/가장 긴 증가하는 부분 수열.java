import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int maxLength = 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }
        System.out.println(maxLength);
    }
}