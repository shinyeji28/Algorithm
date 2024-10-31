import java.io.*;
import java.util.*;

public class Main {
    static int[] graph;
    static boolean[] visited;
    static boolean[] finished;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());

            graph = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                int to = Integer.parseInt(st.nextToken());
                graph[i]= to;
            }
            int sum = 0;
            for(int i=1;i<n+1;i++){
                if(visited[i])continue;
                findCycle(i);
            }
            sb.append(n-count).append('\n');

        }
        System.out.println(sb);
    }
    public static void findCycle(int from){

        if(visited[from])return;
        visited[from] = true;

        int next = graph[from];
        findCycle(next);

        if(!finished[next]){
            count++;
            for(int i=next;i!=from;i=graph[i]){
                count++;
            }
        }

        finished[from] = true;
    }

}