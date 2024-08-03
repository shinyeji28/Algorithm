/*
* 순열을 구하면 메모리 초과가 나니까, 슬라이딩 윈도우로 s 문자열에 윈도우 범위까지 w의 char가 한번씩 쓰였는지만 확인
* */

import java.util.*;
import java.io.*;
public class Main {
    static char[] w;
    static char[] s;
    static HashMap<Character, Integer> sh;
    static int n;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        w = st.nextToken().toCharArray();
        st = new StringTokenizer(br.readLine());
        s = st.nextToken().toCharArray();
        sh = new HashMap<>();

        int[] wAlph = new int[(int)'z'+1];
        int[] sAlph = new int[(int)'z'+1];
        int result = 0;

        for(int i=0;i<n;i++){
            wAlph[(int) w[i]]++;
            sAlph[(int) s[i]]++;
        }
        if(Arrays.equals(wAlph,sAlph)) result++;

        int left = 0;
        int right = n-1;
        while(right<m-1){
            sAlph[s[left]]--;
            left++;
            right++;
            sAlph[s[right]]++;

            if(Arrays.equals(wAlph,sAlph)) result++;

        }
        System.out.println(result);
    }
}