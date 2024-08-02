import java.util.*;
import java.io.*;
public class Main {
    static boolean[] visited;
    static List<Integer>[] tree;
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            tree = new ArrayList[N+1];
            visited = new boolean[N+1];
            for(int i=1;i<=N;i++){
                tree[i] = new ArrayList<>();
            }
            for(int i=0;i<N-1;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                tree[c].add(p);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            dfs(Integer.parseInt(st.nextToken()));
            sb.append(findCommonParents(Integer.parseInt(st.nextToken()))).append('\n');

        }
        System.out.println(sb);
    }
    public static void dfs(int n){
        if(visited[n]) return;
        visited[n] = true;
        for(Integer node : tree[n]){
            dfs(node);
        }
    }
    public static int findCommonParents(int n){
        if(visited[n]) return n;
        for(Integer node : tree[n]){
            return findCommonParents(node);
        }
        return 0;
    }
}