import java.util.Scanner;

public class Main {
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            // 학생들의 선택 입력
            for (int i = 1; i <= n; i++) {
                students[i] = scanner.nextInt();
            }

            // DFS로 사이클 탐색
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            // 팀에 포함되지 않은 학생 수 출력
            System.out.println(n - count);
        }
        scanner.close();
    }

    // DFS를 이용해 사이클 탐색
    public static void dfs(int student) {
        visited[student] = true;
        int next = students[student];

        // 사이클을 찾은 경우
        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) { // 사이클이 완료되지 않았을 때
            count++;
            for (int i = next; i != student; i = students[i]) {
                count++;
            }
        }

        finished[student] = true; // 탐색 완료 표시
    }
}