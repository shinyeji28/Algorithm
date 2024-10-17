import java.util.*;
import java.io.*;

// 비트마스킹
public class Main {

    static int K,P;
    static String x;

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 1~N층까지 이용 가능
        K = Integer.parseInt(st.nextToken());  // 자리수
        P = Integer.parseInt(st.nextToken());  // 최대 반전 수
        int X = Integer.parseInt(st.nextToken());  // 현재 층

        x = String.format("%0"+K+"d", X);


        int cnt = 0;
        // 1~N층까지 X와 비교하기 (XOR연산으로 차이 확인)
        for(int i=1;i<=N;i++){
            if(X == i)continue;
            // 차리수 채우고 각 자리마다 비교
            if(compareNumber(String.format("%0"+K+"d", i))) cnt++;
        }
        System.out.println(cnt);

    }
    public static boolean compareNumber(String str){

        int total = 0;

        for(int i=0;i<K;i++){
            total += ledDiff(str.charAt(i)-'0', x.charAt(i)-'0');
            if(total > P) return false;
        }
        return true;

    }
    public static int ledDiff(int a, int b){
        int[] segment = new int[]{
            0b1110111,
            0b0010010,
            0b1011101,
            0b1011011,
            0b0111010,
            0b1101011,
            0b1101111,
            0b1010010,
            0b1111111,
            0b1111011
        };

        int diff = segment[a] ^ segment[b];
        return Integer.bitCount(diff);
    }
}