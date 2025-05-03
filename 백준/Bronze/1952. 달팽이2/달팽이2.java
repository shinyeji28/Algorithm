import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 달팽이 시계방향 (수학)
        int row = n-1;
        int col = m;
        int sum = 0;
        int answer = 0;
        while(sum < n*m){
            sum += col;
            col -= 1;
            answer++;
            if(sum == n*m) break;

            sum += row;
            row -= 1;
            answer++;

        }

        System.out.println(answer-1);
    }
}