
    import java.io.*;
    import java.util.*;

    public class Main{

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long[] arr = new long[k];

            long left = 1;
            long right = 0;
            for(int i=0;i<k;i++){
                arr[i] = Long.parseLong(br.readLine());
                right = Math.max(right, arr[i]);
            }

            long answer = 0;
            while(left <= right){
                long mid = (left + right) / 2;

                long cnt = 0;
                for(int i=0;i<k;i++){
                    cnt += arr[i] / mid;
                }

                if(cnt >= n){
                    left = mid + 1;
                    answer = Math.max(answer, mid);
                }else {
                    right = mid - 1;
                }
            }
            System.out.println(answer);
        }
    }