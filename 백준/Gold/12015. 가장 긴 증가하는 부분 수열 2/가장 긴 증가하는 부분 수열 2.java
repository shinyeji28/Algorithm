import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);

        for(int i=1;i<n;i++){
            int idx = Collections.binarySearch(lis, arr[i]);
            if(idx<0) {
                idx = idx * (-1) -1;
                if(idx == lis.size()){
                    lis.add(arr[i]);
                }else lis.set(idx, arr[i]);
            }

        }
        System.out.println(lis.size());

    }
}