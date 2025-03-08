import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int closeZero = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while(left < right){
            int sum = arr[left] + arr[right];
            if(closeZero > Math.abs(sum)){
                closeZero = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }
            if(sum == 0)break;
            if(sum < 0) left++;
            else right--;
        }
        System.out.println(answer[0] + " "+ answer[1]);
    }
}