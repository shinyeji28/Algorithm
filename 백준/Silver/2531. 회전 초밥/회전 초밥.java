import java.util.*;
import java.io.*;
/* 슬라이딩 윈도우 + 쿠폰 체크 == 해당 초밥 포함? 0: +1 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] line = new int[n];

        for(int i=0;i<n;i++){
            line[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = 0;
        int[] susiType = new int[d+1];  // 선택된 초밥
        int cnt = 0; // 연속으로 먹을 수 있는 가지수
        int sameC = 0;
        int result = 0;
        for(right=0;right<k;right = (right+1)%n){
            if(c == line[right]) sameC++;
            if(susiType[line[right]]==0) cnt++;
            susiType[line[right]]++;
        }
        result = Math.max(cnt + (sameC==0?1:0), result);
        right = (right + (n-1) ) %n;
        while(left != n){
            if(c == line[left]) sameC--;
            susiType[line[left]]--;

            if(susiType[line[left]]==0) {
                cnt--;
            }

            left++;
            right = (right + 1) % n;

            if(c == line[right]) sameC++;
            if(susiType[line[right]]==0) cnt++;
            susiType[line[right]]++;

            result = Math.max(cnt + (sameC==0?1:0), result);
        }

        System.out.println(result);
    }
}