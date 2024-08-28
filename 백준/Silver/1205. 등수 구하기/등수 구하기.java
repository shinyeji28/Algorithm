
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long taesu = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        Long[] ranking = new Long[n];

        if(n==0){
            if(limit==0)System.out.println(0);
            else System.out.println(1);
        }else {
            st = new StringTokenizer(br.readLine());

            for(int i=0;i<n;i++){
                ranking[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(ranking,(a,b)->b.compareTo(a));

            if(n>=limit && ranking[limit - 1] >= taesu) {
                System.out.println(-1);
            }
            else {

                int result = -1;
                int same = 0;
                int end = n;
                if(n>limit)end = limit;

                for (int i = 0; i < end; i++) {
                    if (ranking[i] < taesu) {
                        result = (i + 1) - same;
                        break;
                    }
                    if (ranking[i] == taesu) {
                        same++;
                    }
                }
                if (result == -1) {
                    if(n<limit) result = n + 1 - same;
                }
                System.out.println(result);
            }
        }
    }

}