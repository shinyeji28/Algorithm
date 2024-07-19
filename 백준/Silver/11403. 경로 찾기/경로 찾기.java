import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static boolean[][] abj;
    static boolean[] visited;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        n = Integer.parseInt(br.readLine());
        abj = new boolean[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                abj[i][j] = st.nextToken().equals("1")?true:false;
            }
        }
        for(int i=0;i<n;i++){
            visited = new boolean[n];
            dfs(i);
            for(int j=0;j<n;j++){
                if(visited[j])sb.append("1 ");
                else sb.append("0 ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void dfs(int v){
        for(int i=0;i<n;i++){
            if(!abj[v][i] || visited[i]) continue;
            visited[i] = true;
            dfs(i);
        }
    }
}