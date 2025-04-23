import java.util.*;
import java.io.*;
public class Main {
    static int n,s;
    static int[] arr;
    static int cnt;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());  // 배낭 무게
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        powerSet(0,0);
        if(s == 0) cnt--;
        System.out.println(cnt); 
    }
    public static void powerSet(int sum, int depth){
        if(depth == n){
            if(sum == s)cnt++;
            return;
        }

        powerSet(sum + arr[depth], depth+1);
        powerSet(sum, depth+1);
    }
}