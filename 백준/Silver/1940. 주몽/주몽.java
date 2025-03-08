import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for(int i=0;i<n-1;i++){
            if(arr[i] >= m) break;
            int target = m - arr[i];
            if(target > arr[i]) {
                // 이진탐색으로 target 찾기
                int idx = Arrays.binarySearch(arr, i+1, n, target);
                if(idx >= 0) cnt++;
            }
        }
        System.out.println(cnt);
    }
}