import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int maxDistance = 0;
        int prev = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int pos = Integer.parseInt(st.nextToken());
            if(i==0) {
                maxDistance = Math.max(maxDistance, pos);
            }else maxDistance = Math.max(maxDistance, (int)Math.ceil((double) (pos - prev) /2));
            prev = pos;
        }
        maxDistance = Math.max(maxDistance, n - prev);

        System.out.println(maxDistance);

    }

}