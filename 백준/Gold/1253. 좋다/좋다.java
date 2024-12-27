
/*
* N^2
* */
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] agrs)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
        }
        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            int left = 0;
            int right = n-1;
            while(left < right){
                if(i==left)left++;
                if(i==right)right--;
                if(left == right)break;
                int sum = arr[left] + arr[right];
                if(arr[i] == sum){
                    answer++;
                    break;
                }
                if(arr[i] < sum){
                    right--;
                }else{
                    left++;
                }
            }
        }
        System.out.println(answer);
    }
}