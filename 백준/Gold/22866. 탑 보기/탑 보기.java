/*
* 현재 i보다 왼쪽을 볼 때 큰 빌딩 구하는 법 : array반복문을 오른쪽으로 순차 진행하면서 stack에 큰 빌딩부터 내림차순으로 정렬되게 함
*   - stack의 현 size가 왼쪽을 바라봤을 때 보이는 빌딩의 수
* 반대로 한번 더
* */
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] agrs)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] buildings = new int[n];
        for(int i=0;i<n;i++){
            int input = Integer.parseInt(st.nextToken());
            buildings[i] = input;
        }
        Stack<Integer> stack = new Stack<>();
        int[][] memories = new int[2][n]; // 0 : 빌딩 개수, 1 : 가장 가까운 건물 인덱스
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()){
                if(buildings[stack.peek()] <= buildings[i]){
                    stack.pop();
                }else break;
            }

            int cnt = stack.size();
            memories[0][i] = cnt;
            if(cnt >0) memories[1][i] = stack.peek();
            stack.push(i);

        }
        stack = new Stack<>();
        for(int i=0;i<n;i++){

            while(!stack.isEmpty()){
                if(buildings[stack.peek()] <= buildings[i]){
                    stack.pop();
                }else break;
            }

            int cnt = stack.size();
            memories[0][i] += cnt;
            // 거리가 가장 가까운 건물, 인덱스가 더 작은 건물
            if(cnt > 0) {
                if(Math.abs(i - memories[1][i]) > Math.abs(i - stack.peek())){
                    memories[1][i] = stack.peek();
                }else if(Math.abs(i - memories[1][i]) == Math.abs(i - stack.peek())) {
                    memories[1][i] = Math.min(memories[1][i], stack.peek());
                }
            }

            sb.append(memories[0][i]);
            if(memories[0][i]!=0){
                sb.append(" "+(memories[1][i]+1));
            }
            sb.append('\n');

            stack.push(i);

        }
        System.out.println(sb);

    }

}