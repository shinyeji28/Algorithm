import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            int target = arr[i];

            // 투포인터로 target이 되는 두 수 찾기
            int left = 0;
            int right = n-1;
            while(left < right){
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }
                int sum = arr[left] + arr[right];
                if(target == sum){
                    cnt++;
                    break;
                }
                if(target > sum) left++;
                else right--;
            }

        }
        System.out.println(cnt);
    }
}