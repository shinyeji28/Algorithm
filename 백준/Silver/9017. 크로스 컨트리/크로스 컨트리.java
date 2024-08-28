import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            int[][] list = new int[n+1][2];
            int[] teamCnt = new int[201];
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> five = new HashMap<>();
            for(int i=1;i<=n;i++){
                int team = Integer.parseInt(st.nextToken());
                list[i][0] = team;
                teamCnt[team]++;
                if(teamCnt[team]==5){
                    five.put(team, i);
                }
            }
            int[] visited = new int[201];
            int[] totalScore = new int[201];
            Arrays.fill(totalScore,Integer.MAX_VALUE);
            int score = 0;
            for(int i=1;i<=n;i++){
               int name = list[i][0];

               if(teamCnt[name] != 6)continue;
               score++;

               list[i][1] = score;

               visited[name]++;
               if(visited[name]>4)continue;

               if(totalScore[name] == Integer.MAX_VALUE) totalScore[name] = 0;
               totalScore[name] +=score;
            }
            score = Integer.MAX_VALUE;
            int win = 0;
            for(int i=1;i<totalScore.length;i++){
                if(totalScore[i] == Integer.MAX_VALUE)continue;
                if(totalScore[i] < score){
                    score = totalScore[i];
                    win = i;
                }else if(totalScore[i] == score){
                    if(list[five.get(i)][1] < list[five.get(win)][1]){
                        win = i;
                    }
                }
            }
            sb.append(win).append('\n');
        }
        System.out.println(sb);
    }

}