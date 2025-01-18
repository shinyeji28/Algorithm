/*
* 1. 더 많이 보이는 방향부터 나열
* 2. 반대 방향 나열
* 3. n개 만큼 2번째 자리에 1을 채우기
*
* 불가능 조건
* 보이는 개수가 n보다 클때
*
* */

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int fromLeft = Integer.parseInt(st.nextToken());
        int fromRight = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        if(n < Math.max(fromLeft, fromRight) || fromLeft + fromRight -1 > n) {
            System.out.println("-1");
            System.exit(0);
        }

        if(fromLeft >= fromRight){
            for(int i=1;i<=fromLeft;i++){
                list.add(i);
            }
            for(int i=fromRight-1;i>=1;i--){
                list.add(i);
            }
        }else{
            for(int i=1;i<=fromLeft-1;i++){
                list.add(i);
            }
            for(int i=fromRight;i>=1;i--){
                list.add(i);
            }
        }

        while(list.size() < n){
            list.add(1,1);
        }

        for(Integer e : list){
            sb.append(e+" ");
        }
        System.out.println(sb);

    }
}