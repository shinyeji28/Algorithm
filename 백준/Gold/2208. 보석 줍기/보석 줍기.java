
    import java.io.*;
    import java.util.*;

    public class Main{

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] sums = new int[n+1]; // 0 은 안 주웠을 경우
            int[] minValue = new int[n+1];
            Arrays.fill(minValue,Integer.MAX_VALUE);
            minValue[0] = 0;

            for(int i=1;i<=n;i++){
                int num = Integer.parseInt(br.readLine());
                sums[i] += num;
                if(i == 0){
                    minValue[0] = num;
                }
                if(i!=0) {
                    sums[i] += sums[i - 1];
                    minValue[i] = Math.min(minValue[i - 1], sums[i]);
                }
            }
            int maxValue = 0;
            for(int i=m;i<=n;i++){
                maxValue = Math.max(maxValue, sums[i] - minValue[i-m]);
            }
            System.out.println(maxValue);

        }
    }