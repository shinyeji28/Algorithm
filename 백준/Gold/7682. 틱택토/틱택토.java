import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String input = br.readLine();
            if(input.equals("end"))break;

            char[] map = input.toCharArray();

            int xCnt = 0;
            int oCnt = 0;
            for(int i=0;i<map.length;i++){
                if(map[i] == 'X') xCnt++;
                else if(map[i] == 'O') oCnt++;
            }

            // !(x - 1 = o || x = o) -> invalid
            if(!(xCnt - 1 == oCnt || xCnt == oCnt)) {
                sb.append("invalid").append('\n');
                continue;
            }

            boolean[] winInfo = isWinSomeOne(map);

            // 둘다 빙고
            if(winInfo[0] && winInfo[1]){
                sb.append("invalid").append('\n');
                continue;
            }

            // 게임이 끝나지 않음
            if((9-(xCnt + oCnt)) != 0 && !winInfo[0] && !winInfo[1]){
                sb.append("invalid").append('\n');
                continue;
            }

            // (9 -(x+o))==0 && x - 1 != o   -> invalid
            if(((9-(xCnt + oCnt)) == 0) && xCnt - 1 != oCnt){
                sb.append("invalid").append('\n');
                continue;
            }
            // (3X && x - 1 != 0) || (3O && x != o) -> invalid
            if((winInfo[0] && xCnt - 1 !=oCnt) || (winInfo[1] && xCnt!=oCnt) ){
                sb.append("invalid").append('\n');
                continue;
            }
            sb.append("valid").append('\n');
        }
        System.out.println(sb);
    }
    public static boolean[] isWinSomeOne(char[] map){

        boolean x = false;
        boolean o = false;

        for(int i=0;i<3;i++){
            // 행으로 win
            char prev = '0';
            int cnt = 0;
            for(int j=i;j<9;j+=3){
                if(j==i) prev = map[j];
                if(map[j] != prev) break;
                else{
                    cnt++;
                    if(cnt == 3){
                        if(map[j] == 'X') x = true;
                        if(map[j] == 'O') o = true;
                    }
                }
            }

            // 열로 win
            cnt = 0;
            for(int j=i*3;j<9;j++){
                if(j==i*3) prev = map[j];
                if(map[j] != prev) break;
                else{
                    cnt++;
                    if(cnt == 3){
                        if(map[j] == 'X') x = true;
                        if(map[j] == 'O') o = true;
                    }
                }
            }
        }

        if(map[0]==map[4] && map[4]==map[8]){
            if(map[0] == 'X') x = true;
            if(map[0] == 'O') o = true;
        }
        if(map[2]==map[4] && map[4]==map[6]){
            if(map[2] == 'X') x = true;
            if(map[2] == 'O') o = true;
        }


        return new boolean[]{x,o};
    }
}