
    import java.io.*;
    import java.util.*;
    public class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            while(true){
                String input = br.readLine();
                if(input.equals("end"))break;

                boolean isValid = true;
                int x = 0;
                int o = 0;
                for(int i=0;i<input.length();i++){
                    if(input.charAt(i) == 'X') x++;
                    if(input.charAt(i)== 'O') o++;
                }

                char[][] map = new char[3][3];
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        map[i][j] = input.charAt(i*3+j);
                    }
                }



                if(x-1 == o || x==o ){

                    boolean xWin = false;
                    boolean oWin = false;
                    for(int i=0;i<3;i++){
                        if(map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                            if(map[i][0] == 'X')xWin = true;
                            if(map[i][0] == 'O')oWin = true;
                        }
                        if(map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                            if(map[0][i] == 'X')xWin = true;
                            if(map[0][i] == 'O')oWin = true;
                        }
                    }
                    if(map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
                        if(map[0][0] == 'X')xWin = true;
                        if(map[0][0] == 'O')oWin = true;
                    }
                    if(map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
                        if(map[0][2] == 'X')xWin = true;
                        if(map[0][2] == 'O')oWin = true;
                    }
                    if(xWin && oWin) isValid = false;
                    else{
                        if(xWin && x-1!=o) isValid = false;
                        if(oWin && x != o) isValid = false;
                    }
                    if(x+o!=9 && !xWin && !oWin) isValid = false;

                }else{
                    isValid = false;
                }

                if(isValid)sb.append("valid");
                else sb.append("invalid");
                sb.append('\n');
            }
            System.out.println(sb);
        }

    }