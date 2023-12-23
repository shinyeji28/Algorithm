/*
* N+1일째 되는 날 퇴사
* 하루에 하나씩 서로 다른 사람의 상담 잡기
* N일 동안 최대 수익을 구하라
*
* 구현>
* n >= 15 - 2^15 - 백트래킹으로 가능
* 방 1) 백트래킹
*   i번째를 상담시작한다면 i+T[i]번째부터 상담으로 이동
*   i번째를 상담하지 않는다면 i+1로 이동
*   백트래킹 조건 - 남은 일수가 > n 이면 return
* 방 2) 백트래킹 일반화 - dp점화식
*   Top-down
*   dp[i] = i번째까지 상담을 진행했을 때 최대의 이익
*   dp[i] = max(P[i] + dp[i+T[i]] , dp[i+1])
*   남은일수 > n이면 dp[i] = dp[i+1]
*
* */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Node[] days = new Node[N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            days[i] = new Node(p,t);
        }
        int[] dp = new int[N+2];
        for(int i=N;i>=1;i--){
            if(i + days[i].t -1 >N){
                dp[i] = dp[i+1];
            }else{
               dp[i] = Math.max(days[i].p + dp[i+days[i].t] , dp[i+1]);
            }
        }
        System.out.println(dp[1]);
    }
    public static class Node{
        int p;
        int t;
        public Node(int p, int t){
            this.p = p;
            this.t = t;
        }
    }
}