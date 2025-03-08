import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = n+1;
        int left = 0;
        int right = 0;
        long sum = 0;
        while(right<n){
            sum += arr[right];
            while(sum >= m){
                len = Math.min(len, right-left+1);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        if(len == n+1)len = 0;
        System.out.println(len);
    }
}