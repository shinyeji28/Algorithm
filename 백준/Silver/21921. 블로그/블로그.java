import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] history = new int[n];
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            history[i] =  Integer.parseInt(st.nextToken());
            if(i>=x)continue;
            sum += history[i];
        }
        
        long maxSum = sum;

        int left = 0;
        int right = x-1;
        int cnt = 1;
        while(right+1<n){
            sum -= history[left];
            left++;
            right++;
            sum += history[right];
            if(sum > maxSum){
                cnt = 1;
                maxSum = sum;
            }else if(sum == maxSum){
                cnt++;
            }
        }
        if(maxSum == 0) System.out.println("SAD");
        else {
            System.out.println(maxSum);
            System.out.println(cnt);
        }



    }

}