import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 현재 고도가 이전 고도보다 낮아지면 스택에서 제거
            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
            }

            // 현재 고도가 이전 고도와 다르면 스택에 추가
            if (stack.isEmpty() || stack.peek() < y) {
                stack.push(y);
                if (y != 0) { // 높이가 0이 아닌 경우에만 건물로 카운트
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}