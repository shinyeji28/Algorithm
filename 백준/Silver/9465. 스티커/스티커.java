
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
                    // 뽑는다면 0,j-1은 안뽑아야 하고 1,j-1은 뽑는경우(안뽑는 경우를 고려하면 0,j-1을 뽑는 경우가 생김)만 고려
                    dp[1][0][j] = Math.max(dp[0][0][j-1], dp[1][1][j-1]) + map[0][j];

                    // 스티커 1행
                    // 안뽑는다면 모든 경우 가능
                    dp[0][1][j] = Math.max(Math.max(dp[0][0][j], dp[0][1][j-1]) , Math.max(dp[1][0][j], dp[1][1][j-1]));
                    // 뽑는다면 1,j-1은 안뽑아야 하고, 대각은 모든 경우 고려(0,j를 고려하지 않아야함) 
                    dp[1][1][j] = Math.max(dp[0][1][j-1] , Math.max(dp[0][0][j-1], dp[1][0][j-1]))  + map[1][j];
                }

                int result = Math.max(Math.max(dp[0][0][N], dp[0][1][N]) , Math.max(dp[1][0][N], dp[1][1][N]));
                System.out.println(result);

            }

        }
    }