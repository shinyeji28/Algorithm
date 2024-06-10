/*
*  V(가치)의 최대값 구하기
*
* W(무게) <= K (배낭)
*
* 방법 >
* 무게가 작은 것부터 넣거나 가치가 큰 것부터 넣으면 안됨
*
* 1) 완탐
* 모든 경우를 다 고려해야 함
* 시간 복잡도 : O(N^N) = 100^100 - 시간 초과
* 2) DP
* 아이디어 : 물건 하나를 담을 때, 1~k무게를 담는 가방의 최대 가치
* dp[i] : i라는 무게를 담는 가방에 대한 최대의 가치
* (w,v)의 물건을 가방에 들어갈 경우 k 무게의 가방에 들어갈 가치 = v + dp[k-w]

*
* */

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> goods = new LinkedList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            goods.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int[] dp = new int[k+1];

        // 물건을 하나씩 가방에 넣기
        A : for(int i=0;i<n;i++){
            int[] item = goods.poll();
            int w = item[0];
            int v = item[1];

            for(int j=k;j>=1;j--){   // 임시 가방(무게가 1~k)에 해당 물건을 넣을 때 각 임시 가방의 최대 가치
                if(w>j) continue A;   // 가방의 무게보다 물건이 무거우면 더 이상 탐색할 필요 없음
                dp[j] = Math.max(dp[j], dp[j-w] + v);
            }
        }
        System.out.println(dp[k]);
    }
}