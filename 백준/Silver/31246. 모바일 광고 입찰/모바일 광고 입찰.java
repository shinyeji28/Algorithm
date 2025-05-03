import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] prices = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            prices[i][0] = a;
            prices[i][1] = b;
        }

        int x = Integer.MAX_VALUE;
        int left = 0;
        int right = 1000000000;
        while(left <= right){
            int mid = (left + right)/2;

            int cnt = k;
            for(int i=0;i<n;i++){
                if(prices[i][0] + mid >= prices[i][1]){
                    cnt--;
                    if(cnt == 0)break;
                }
            }
            if(cnt == 0){
                right = mid - 1;
                x = Math.min(x, mid);
            }else{
                left = mid + 1;
            }
        }
        if(x == Integer.MAX_VALUE) x = 0;
        System.out.println(x);
    }
}