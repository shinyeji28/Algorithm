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
        int[] lis = new int[n];
        lis[0] = arr[0];
        int lisIdx = 0;

        for(int i=1;i<n;i++){
            int idx = Arrays.binarySearch(lis,0, lisIdx+1, arr[i]);
            if(idx<0) {
                idx = idx * (-1) -1;
                if(idx == lisIdx+1){
                    lisIdx++;
                    lis[lisIdx] = arr[i];
                }else lis[idx] = arr[i];
            }
        }
        System.out.println(lisIdx+1);

    }
}