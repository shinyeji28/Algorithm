/*
* 투포인터
* 1개 뽑기 + 연속된 2개 이상 뽑기 = N + twoPoint
*
* twoPoint로 계산하기
* 기본적으로 R++이지만, 같은 숫자가 나오지 않을때까지 l++
* picked 배열을 갱신하면서 L ~ R 사이 뽑은 숫자 체크
* R이 배열을 벗어나면 종료
* */
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] picked = new int[100001];
        int l=0;
        int r=0;
        long sum = 0;  // int를 넘을 가능성이 있음
        picked[arr[l]]++;
        while(r<n){

            r++;
            if(r>=n)break;
            picked[arr[r]]++;

            while(picked[arr[r]] > 1){ // 같은 숫자 뽑지 않을 때까지
                picked[arr[l]]--;
                l++;
            }

            sum += r-l;

        }
        System.out.println(n+sum);

    }

}

