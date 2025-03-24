import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] sums = new int[n+1];
        for(int i=1;i<=n;i++){
            int e = Integer.parseInt(st.nextToken());
            if(e % 2 == 1) sums[i] = 1;
            if(i > 0) sums[i] += sums[i-1];
        }
        int l=0;
        int len = 0;
        for(int r=1;r<=n;r++){
            while(l<n && sums[r] - sums[l] > k){
                l++;
            }
            len = Math.max(r-l-(sums[r] - sums[l]), len);
        }
        System.out.println(len);
    }
}