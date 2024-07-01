/*
*  값을 더해야하는 시작점과 끝점을 가지고 O(N)으로 끝내기
* */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];
        long[] flag = new long[n+2];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            flag[s] += h;
            flag[e+1] -= h;
        }
        long accumulate = 0;
        for(int i=1;i<=n;i++){
            accumulate += flag[i];
            arr[i] += accumulate;
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}