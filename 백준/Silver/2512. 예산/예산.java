import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] request = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        long maxValue = 0;
        for (int i = 0; i < n; i++) {
            request[i] = Integer.parseInt(st.nextToken());
            sum += request[i];
            maxValue = Math.max(maxValue, request[i]);
        }
        long total = Integer.parseInt(br.readLine());

        if(total>=sum){
            System.out.println(maxValue);
            return;
        }

        Arrays.sort(request);

        long left = 0;
        long right = request[n-1];
        long result = 0;
        while(left<=right){
            long mid = (left + right) / 2;
            sum = 0;
            for(int i=0;i<n;i++){
                sum += Math.min(mid, request[i]);
            }
            if(sum <= total){
                result = mid;
                left = mid+1;
            }
            else {
                right = mid-1;
            }

        }
        System.out.println(result);
    }

}