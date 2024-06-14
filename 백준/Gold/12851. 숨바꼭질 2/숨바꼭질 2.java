/*
* 시작 점 : 수빈 - N , 동생 - K
* 수빈 이동 : 걷기 (x-1 || x+1) , 순간이동(2*x)
* 목표 > 수빈이가 동생을 만나는 가장 빠른 시간
*       이때 방법은 몇가지인지
*
* 구현 >
* dp[0][i] : i위치에 있을 때 수빈이가 동생을 만나는 최소 시간
* dp[1][i] : i에서 최소시간이 될 수 있는 방법의 수
* 최소 시간 구하기 : BFS로 가장 빨리 i에 도착한 것이 최소 시간임 (방문 배열 사용)
* 방법의 수 : 방법의 수를 계속 누적 시킴 (이전 dp의 방법의 수를 누적 저장)
* 
*
* 100,000까지 범위를 고정해도 되는 이유 : i*2하는 순간 차이가 2배 나버려서 최소 시간에 만족하지 못함 (그래서 100,000이상 넘어가는 것은 최소 시간이 아님)
* 방문체크를 하는 이유 -> 먼저 방문한 것이 최소 시간임을 보장
* */

import java.util.*;
import java.io.*;
public class Main {
    static final int MAXSIZE = 100000;
    static int[][] dp = new int[2][MAXSIZE+1];

    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);
        System.out.println(dp[0][k]);
        System.out.println(dp[1][k]);
    }
    public static void bfs(int n, int k){
        boolean[] visited = new boolean[MAXSIZE+1];
        Arrays.fill(dp[0],MAXSIZE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;
        dp[0][n] = 0;
        dp[1][n] = 1;

        while(!q.isEmpty()){
            int idx = q.poll();
            int curTime = dp[0][idx];
            int curWays = dp[1][idx];
            int[] next = new int[]{idx-1,idx+1,idx*2};
            for(int i : next){
                if(i<0 || i>MAXSIZE)continue;
                if(!visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    dp[0][i] = curTime + 1;
                    dp[1][i] = curWays;
                }else if(dp[0][i] == curTime + 1){
                    dp[1][i] += curWays;
                }
            }
        }
    }
}