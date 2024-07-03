import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] map = new char[9];
        int[][] posCompare = new int[][]{
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // 가로
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // 세로
                {0, 4, 8}, {2, 4, 6}             // 대각선
        };

        while (true) {
            String input = br.readLine().trim();
            if (input.equals("end")) break;
            int x = 0, o = 0;
            for (int i = 0; i < 9; i++) {
                map[i] = input.charAt(i);
                if (map[i] == 'X') x++;
                if (map[i] == 'O') o++;
            }

            // 말의 개수 검사
            if (o > x || x > o + 1) {
                sb.append("invalid").append('\n');
                continue;
            }

            boolean xWins = false, oWins = false;
            for (int[] pos : posCompare) {
                if (map[pos[0]] != '.' && map[pos[0]] == map[pos[1]] && map[pos[1]] == map[pos[2]]) {
                    if (map[pos[0]] == 'X') xWins = true;
                    if (map[pos[0]] == 'O') oWins = true;
                }
            }

            // 승리 조건 검사 및 유효한 최종 상태 확인
            if (xWins && oWins) {
                sb.append("invalid").append('\n');
            } else if (xWins && x != o + 1) {
                sb.append("invalid").append('\n');
            } else if (oWins && x != o) {
                sb.append("invalid").append('\n');
            } else if (!xWins && !oWins && x + o != 9) {
                sb.append("invalid").append('\n');
            } else {
                sb.append("valid").append('\n');
            }
        }
        System.out.println(sb);
    }
}