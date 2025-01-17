/*
* O(n^2)
* 건물 A와 Bi의 기울기를 갱신하면서 겹치는지 확인
* 1,2 사분면 : 기울기가 더 크면 보임
* 3,4 사분면 : 기울기가 더 작으면 보임
* (단, A건물보다 큰 건물B가 있다면 B보다 작은 뒤쪽 건물은 보이지 않음)
* */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] yArr = new int[n+1];
        int[] sights = new int[n+1];

        for(int x=1;x<=n;x++){
            yArr[x] = Integer.parseInt(st.nextToken());
        }

        for(int x=1;x<=n;x++){
            int rx = x+1;
            int lx = x-1;
            double dr1 = -1;   // 양수 기울기가 더 커야함
            double dr4 = Long.MAX_VALUE;   // 음수 기울기가 더 작아야함
            double dl2 = -1;   // 음수 기울기가 더 커야함
            double dl3 = Long.MAX_VALUE;   // 양수 기울기가 더 작아야함
            long height = 0; // A보다 높다면 이 값 뒤에 건물을 보이지 않음
            while(rx<=n){
                double g = (double)(yArr[x] - yArr[rx])/(x - rx);
                double absG = Math.abs(g);
                if(g >= 0){
                    if(dr1 < absG && height < yArr[rx]){
                        sights[x]++;
                        dr1 = absG;
                        height = yArr[rx];
                    }
                }else{
                    if(dr4 > absG && height < yArr[rx]){
                        sights[x]++;
                        dr4 = absG;
                    }
                }
                rx++;
            }
            height = 0;
            while(lx>0){
                double g = (double)(yArr[x] - yArr[lx])/(x - lx);
                double absG = Math.abs(g);
                if(g >= 0){
                    if(dl3 > absG && height < yArr[lx]){
                        sights[x]++;
                        dl3 = absG;
                    }
                }else{
                    if(dl2 < absG && height < yArr[lx]){
                        sights[x]++;
                        dl2 = absG;
                        height = yArr[lx];
                    }
                }
                lx--;
            }
        }

        int answer = 0;
        for(int x=1;x<=n;x++){
            answer = Math.max(sights[x], answer);
        }
        System.out.println(answer);

    }
}