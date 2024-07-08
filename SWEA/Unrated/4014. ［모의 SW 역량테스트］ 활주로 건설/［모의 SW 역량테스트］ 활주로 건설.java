/*
* 직선으로 탐방하다가 나보다 +1인 수가 나오면 나를 포함하여 뒤로 x만큼 탐색하여 경사로 설치 가능 여부 판별
*                 나보다 -1인 수가 나오면 직진하여 x만큼 설치 가능 여부 판별
* 설치 불가면 return;
* 2이상 차이나면 return;
* 경사로 중복 설치가 불가하여 방문배열로 체크하기
* */
import java.io.*;
import java.util.*;
public class Solution {
    static int n,x;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ableCases = 0;

            for(int i=0;i<n;i++){
                int prev = map[i][0];
                visited = new boolean[n];
                for(int j=1;j<n;j++){
                    if(prev != map[i][j]){
                        if(Math.abs(prev - map[i][j])>1)break;
                        if(prev > map[i][j]){
                            if(checkingGaro(i,j, map[i][j])) {
                                j += (x-1);
                            }else break;
                        }else{
                            if(!checkingGaro(i,j-x, prev))break;
                        }
                    }
                    if(j==n-1){
                        ableCases++;
                    }

                    prev = map[i][j];
                }
            }

            for(int j=0;j<n;j++){
                int prev = map[0][j];
                visited = new boolean[n];
                for(int i=1;i<n;i++){
                    if(prev != map[i][j]){
                        if(Math.abs(prev - map[i][j])>1)break;
                        if(prev > map[i][j]){
                            if(checkingSero(i,j, map[i][j])) {
                                i += (x-1);
                            }else break;
                        }else{

                            if(!checkingSero(i-x,j, prev))break;
                        }
                    }
                    if(i==n-1) {
                        ableCases++;
                    }
                    prev = map[i][j];
                }
            }
            sb.append("#"+(t+1)+" "+ableCases).append('\n');
        }
        System.out.println(sb);
    }
    public static boolean checkingGaro(int cx, int cy, int num){
        for(int i=cy;i<cy+x;i++){
            if(i<0||i>=n || visited[i]) return false;
            if(num!=map[cx][i])return false;
            visited[i] = true;
        }
        return true;
    }
    public static boolean checkingSero(int cx, int cy, int num){
        for(int i=cx;i<cx+x;i++){
            if(i<0||i>=n ||visited[i]) return false;
            if(num!=map[i][cy])return false;
            visited[i] = true;
        }
        return true;
    }
}