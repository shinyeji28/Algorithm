/*
* 최종 상태 가능
*  - 다 채워짐 (X = 5, O = 4)
*  - X혹은 O가 가로, 세로, 대각선으로 빙고
*
* 불가능
* - 입력에서 거르기 (O > X)
*
* 판단
* i<3까지 돌면서
* - 가로 : if(i == i+1 == i+2)
* - 세로 : if(i*3 == i*3+1 == i*3+2)
*
* - 대각(좌상-우하) : if(0 == 4 == 8)
* - 대각 (우상- 좌하) : if(2 == 4 == 6)
* */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        char[] map = new char[9];
        int x = 0;
        int o = 0;
        int[][] posCompare = new int[][]{
                {0,3,6}, {1,4,7}, {2,5,8},   // 세로
                {0,1,2}, {3,4,5}, {6,7,8},   // 가로
                {0,4,8}, {2,4,6}             // 대각선
        };

        A : while(true) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if (input.equals("end")) break;
            x = 0;
            o = 0;
            for (int i = 0; i < 9; i++) {
                map[i] = input.charAt(i);
                if (map[i] == 'X') x++;
                if (map[i] == 'O') o++;
            }
            if (o > x || x > o+1) {
                sb.append("invalid").append('\n');
                continue;
            }
            boolean oFlag = false, xFlag = false;
            for (int[] pos : posCompare) {
                if (map[pos[0]] != '.' && map[pos[0]] == map[pos[1]] && map[pos[1]] == map[pos[2]]) {
                    if (map[pos[0]] == 'O') oFlag = true;
                    else if(map[pos[0]]=='X') xFlag = true;
                }
            }
            if (oFlag && xFlag) sb.append("invalid").append('\n');
            else if (oFlag && o==x) sb.append("valid").append('\n');
            else if (xFlag && o+1==x) sb.append("valid").append('\n');
            else if(!oFlag && !xFlag && x == 5 && o ==4) sb.append("valid").append('\n');
            else sb.append("invalid").append('\n');
        }
        System.out.println(sb);
    }
}