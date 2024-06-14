import java.util.*;

public class Main {
    static final int MAX = 100000; // 문제에서 주어진 최대 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dist = new int[MAX + 1]; // 각 위치까지의 최단 시간 저장
        int[] ways = new int[MAX + 1]; // 각 위치까지의 최단 시간으로 도달하는 방법의 수 저장
        boolean[] visited = new boolean[MAX + 1]; // 방문 여부 체크
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);
        visited[N] = true;
        dist[N] = 0;
        ways[N] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 현재 위치에서 가능한 다음 위치들을 탐색
            int[] nextPositions = { cur - 1, cur + 1, cur * 2 };
            for (int next : nextPositions) {
                if (next < 0 || next > MAX) continue; // 범위를 벗어나면 건너뜀

                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    ways[next] = ways[cur];
                    queue.offer(next);
                } else if (dist[next] == dist[cur] + 1) {
                    // 이미 방문한 경우에 최단 시간과 같으면 경로의 수를 더해준다
                    ways[next] += ways[cur];
                }
            }
        }

        // 결과 출력
        System.out.println(dist[K]);
        System.out.println(ways[K]);
    }
}