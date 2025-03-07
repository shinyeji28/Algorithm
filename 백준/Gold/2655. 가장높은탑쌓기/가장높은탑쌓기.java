import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int w;       // 밑면 넓이
        int h;       // 높이
        int weight;  // 무게
        int idx;     // 입력된 순서 (벽돌 번호)

        public Node(int w, int h, int weight, int idx) {
            this.w = w;
            this.h = h;
            this.weight = weight;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.w, node.w); // 밑면 넓이 기준 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(w, h, weight, i + 1);
        }

        // 밑면 넓이를 기준으로 정렬
        Arrays.sort(nodes);

        // DP 배열 및 경로 추적 배열 초기화
        int[] dp = new int[n];      // dp[i]: i번째 벽돌을 꼭 사용했을 때 최대 높이
        int[] path = new int[n];   // path[i]: i번째 벽돌 아래에 놓인 벽돌의 인덱스 (-1이면 없음)

        Arrays.fill(path, -1);     // 초기값: 이전 벽돌 없음

        // DP 점화식 계산
        for (int i = 0; i < n; i++) {
            dp[i] = nodes[i].h; // 기본값: 자기 자신만 사용했을 때의 높이

            for (int j = 0; j < i; j++) {
                if (nodes[j].weight < nodes[i].weight && dp[i] < dp[j] + nodes[i].h) {
                    dp[i] = dp[j] + nodes[i].h;
                    path[i] = j; // 이전 벽돌 저장
                }
            }
        }

        // 최대 높이와 그 인덱스 찾기
        int maxHeight = 0;
        int lastIndex = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxHeight) {
                maxHeight = dp[i];
                lastIndex = i;
            }
        }

        // 경로 추적하여 결과 출력
        List<Integer> result = new ArrayList<>();
        while (lastIndex != -1) {
            result.add(nodes[lastIndex].idx); // 원래 입력된 번호 저장
            lastIndex = path[lastIndex];
        }

        System.out.println(result.size()); // 사용된 벽돌 개수 출력
        for (int i = result.size() - 1; i >= 0; i--) { // 역순으로 출력
            System.out.println(result.get(i));
        }
    }
}
