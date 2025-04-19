
    import java.io.*;
    import java.util.*;
    public class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[][] board = new boolean[n][m];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                for(int j=0;j<m;j++){
                    char color = str.charAt(j);
                    if(color == 'W') board[i][j] = true;
                    else board[i][j] = false;
                }
            }

            // 정의에 따른 보드판 만들기
            boolean[][] collectBoard = new boolean[n][m];
            collectBoard[0][0] = true;
            for(int j=1;j<m;j++) {
                collectBoard[0][j] = !collectBoard[0][j-1];
            }
            for(int i=1;i<n;i++){
                for(int j=0;j<m;j++) {
                    collectBoard[i][j] = !collectBoard[i-1][j];
                }
            }

            int minValue = Integer.MAX_VALUE;

            // 다시 칠해야 하는 갯수 찾기
            for(int sx = 0;sx <=n-8;sx++){
                for(int sy =0;sy<=m-8;sy++){

                    int startWhite = 0;
                    int startBlack = 0;
                    for(int i=sx;i<sx + 8;i++) {
                        for (int j = sy; j < sy +8; j++) {
                            if(board[i][j] == collectBoard[i][j]) startWhite++;
                            if(board[i][j] != collectBoard[i][j]) startBlack++;
                        }
                    }
                    minValue = Math.min(minValue , Math.min(startWhite,startBlack));

                }
            }
            System.out.println(minValue);

        }
    }