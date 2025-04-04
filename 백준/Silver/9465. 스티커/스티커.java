
    import java.io.*;
    import java.util.*;

    public class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for(int t=0;t<T;t++){
                int N = Integer.parseInt(br.readLine());
                int[][] map = new int[2][N+1];  // 0 : 안 뽑는다 , 1 : 뽑는다
                int[][][] dp = new int[2][2][N+1];
                for(int i=0;i<2;i++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for(int j=1;j<N+1;j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                // 뽑는다
//                dp[1][0][1] = map[0][1];
//                dp[1][1][0] = map[1][0];

                for(int j=1;j<N+1;j++){
                    // 스티거 0행
                    // 안뽑는다면 모든 경우 가능
                    dp[0][0][j] = Math.max(Math.max(dp[0][0][j-1], dp[0][1][j-1]) , Math.max(dp[1][0][j-1], dp[1][1][j-1]));
                    // 뽑는다면 max(위/아래, 좌 안뽑)
                    dp[1][0][j] = Math.max(dp[0][0][j-1], dp[1][1][j-1]) + map[0][j];

                    // 스티커 1행
                    // 안뽑는다면 모든 경우 가능
                    dp[0][1][j] = Math.max(Math.max(dp[0][0][j], dp[0][1][j-1]) , Math.max(dp[1][0][j], dp[1][1][j-1]));
                    // 뽑는다면 max(위/아래, 좌 안뽑)
                    dp[1][1][j] = Math.max(dp[0][1][j-1] , Math.max(dp[0][0][j-1], dp[1][0][j-1]))  + map[1][j];
                }

                int result = Math.max(Math.max(dp[0][0][N], dp[0][1][N]) , Math.max(dp[1][0][N], dp[1][1][N]));
                System.out.println(result);

            }

        }
    }