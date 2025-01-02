/*
* 최대 자리수 : N / 2
* 성냥 합이 N이 되는 수 가장 큰, 작은 수 찾기 (맨 앞 0 제외)
*
* 조합 시간 초과 : 최대 O(100C50)
* 다이나익프로그래밍 : 동전문제 + 중복 사용 가능 O(100 * 10(0~9 수))
*       - 구현방식 > 동전문제 > dp[i] : 성냥이 총 i개 일때, 어떤 수를 최대/최소로 가지는지
* */

import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] usedMatches = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};  // 사용된 성냥 수
        String[] dpMin = new String[101]; // [사용된 성냥 총 수]
        String[] maxArray = new String[101];

        Arrays.fill(dpMin, "1000000000000000000000000000000000000000000000000");

        dpMin[2] = "1";
        dpMin[3] = "7";
        dpMin[4] = "4";
        dpMin[5] = "2";
        dpMin[6] = "6";
        dpMin[7] = "8";
        dpMin[8] = "10";

        for (int i = 9; i <= 100; i++) {
            for (int j = 0; j < usedMatches.length; j++) {
                int c = usedMatches[j];
                // 최소
                String candidate = dpMin[i-c] + j;
                if(j==0 && candidate.length()==1)continue; // 0이 앞에 위치하는 것을 막음
                if(dpMin[i].length() > candidate.length()
                        || (dpMin[i].length()==candidate.length() && candidate.compareTo(dpMin[i])<0)){
                    dpMin[i] = candidate;
                }
            }
        }

        //최대
        for(int i=2;i<=100;i++){
            // 짝수면 몫만큼 1을 반복
            // 홀면서 몫마큼 1을 반복하지만 맨 앞자리는 7로 변경

            StringBuilder repeatSb = new StringBuilder();

            if (i % 2 == 0) repeatSb.append("1");
            else repeatSb.append("7");
            for(int j=0;j<i/2 -1;j++) {
                repeatSb.append("1");
            }
            maxArray[i] = repeatSb.toString();

        }


        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dpMin[n]+" "+maxArray[n]).append('\n');

        }
        System.out.println(sb);


    }

}

