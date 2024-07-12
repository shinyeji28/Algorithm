import java.io.*;
import java.util.*;
public class Solution {
    static int[] pick;
    static int[] kuyoung;
    static List<Integer> inyoung;
    static boolean[] visited;
    static int win, lose;
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            kuyoung = new int[9];
            pick = new int[9];
            visited = new boolean[9];
            inyoung = new ArrayList<>();
            win = 0;
            lose = 0;
            for(int i=1;i<=18;i++){
                inyoung.add(i);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<9;i++){
                int input = Integer.parseInt(st.nextToken());
                kuyoung[i] = input;
                inyoung.remove(Integer.valueOf(input));
            }

            permutation(0);
            sb.append("#"+t+" "+win+" "+lose).append('\n');
        }
        System.out.println(sb);
    }
    public static void permutation(int depth){
        if(depth == 9){

            int kuyoungSum = 0;
            int inyoungSum = 0;
            for(int i=0;i<9;i++){
                if(kuyoung[i]<pick[i]){
                    inyoungSum += kuyoung[i]+pick[i];
                }else{
                    kuyoungSum += kuyoung[i]+pick[i];

                }
            }
            if(kuyoungSum>inyoungSum)win++;
            else lose++;
            return;
        }
        for(int i=0;i<9;i++){
            if(visited[i])continue;
            visited[i] = true;
            pick[depth] = inyoung.get(i);
            permutation(depth+1);
            visited[i] = false;
        }
    }
}