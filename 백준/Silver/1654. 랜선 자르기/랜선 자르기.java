import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] myLen = new long[k];
        for(int i=0;i<k;i++){
            myLen[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(myLen);

        long maxLen = 0;
        long left = 1;
        long right = myLen[k-1];
        while(left <= right){
            long mid = (left + right)/2;

            long cnt = 0;
            for(int i=k-1;i>=0;i--){
                cnt += myLen[i] / mid;
                if(cnt >= n){
                    maxLen = Math.max(maxLen, mid);
                    break;
                }
            }

            if(mid <= maxLen){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(maxLen);
    }
}