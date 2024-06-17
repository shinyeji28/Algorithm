/*
* 다익스트라 PQ, BFS
* 시간 복잡도 O(N)
* */
import java.util.*;
import java.io.*;
public class Main {
    static final int SIZE = 100001;
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n,k));
    }
    public static int bfs(int n, int k){
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[SIZE];
        int[] dp = new int[SIZE];
        q.add(n);
        visited[n] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            int time = dp[x];
            if(x == k){
                return dp[k];
            }
            int[] calc = new int[]{x*2, x-1, x+1};
            int[] increase = new int[]{0,1,1};
            for(int i=0;i<3;i++){
                int nx = calc[i];
                if(nx<0 || nx>=dp.length || visited[nx])continue;
                visited[nx] = true;
                dp[nx] = time + increase[i];
                if(increase[i] == 0) q.addFirst(nx);
                else q.add(nx);

            }
        }
        return 0;
    }
}