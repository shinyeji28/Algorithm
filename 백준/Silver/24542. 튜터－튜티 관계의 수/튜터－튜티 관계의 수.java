
import java.util.*;
import java.io.*;
public class Main{
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long answer = 1;
        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            graph[from].add(to);
            graph[to].add(from);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]) {
                visited[i] = true;
                int cnt = countBelongTo(i);
                answer = (answer * cnt) % 1000000007;
            }
        }
        System.out.println(answer);
    }
    public static int countBelongTo(int from){
        int cnt = 1;
        for(Integer to: graph[from]){
            if(visited[to])continue;
            visited[to] = true;
            cnt += countBelongTo(to);
        }
        return cnt;
    }
}