import java.util.*;
import java.io.*;

public class Main {
    static final int SIZE = 100001;
    static List<Integer> linking = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sb.append(bfs(n, k)).append('\n');
        for (int i = linking.size() - 1; i >= 0; i--) {
            sb.append(linking.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    public static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[SIZE];
        int[] prev = new int[SIZE];
        Arrays.fill(prev, -1);  // 초기값 설정
        
        q.offer(n);
        visited[n] = true;
        
        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == k) {
                int idx = x;
                while (idx != -1) {
                    linking.add(idx);
                    idx = prev[idx];
                }
                return linking.size() - 1;
            }
            int[] next = new int[] { x - 1, x + 1, x * 2 };
            for (int nx : next) {
                if (nx >= 0 && nx < SIZE && !visited[nx]) {
                    q.offer(nx);
                    visited[nx] = true;
                    prev[nx] = x;
                }
            }
        }
        return 0;
    }
}