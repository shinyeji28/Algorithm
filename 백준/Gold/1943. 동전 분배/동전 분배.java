import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<3;t++){
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            int[][] coins = new int[n][2];
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                coins[i][0] = Integer.parseInt(st.nextToken());
                coins[i][1] = Integer.parseInt(st.nextToken());

                sum += ( coins[i][0] *  coins[i][1]);

            }
            if(sum % 2 == 1 ){
                System.out.println(0);
                continue;
            }
            boolean[] dp = new boolean[sum/2+1];

            dp[0] = true;
            for(int i=0;i<n;i++){
                int value = coins[i][0];
                int cnt = coins[i][1];
                for(int j=dp.length-1;j>=0;j--){
                    if(dp[j]){
                        for(int k=1;k<=cnt;k++){
                            if(j + k * value >= dp.length)break;
                            dp[j + k * value] = true;
                        }
                    }

                }

            }
            System.out.println(dp[dp.length-1]?1:0);
//            sb.append(dp[dp.length-1]?1:0).append('\n');
        }
//        System.out.println(sb);

    }

}