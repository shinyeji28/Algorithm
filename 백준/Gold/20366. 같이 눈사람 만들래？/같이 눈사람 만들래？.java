/*
* 1. 조합으로 1번 눈사람 크기 구하기
* 2. 1번 눈사람에 해당하지 않는 눈덩이로 또 다른 조합 구하기 (투포인터로 1번 눈사람의 조합에 해당하지 않는 조합 구하기)
* 3. 두 눈사람의 차의 최소 구하기

n^3
* */

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n;j++){

                int snowman1 = arr[i] + arr[j];

                int l=i+1;
                int r=j-1;
                while(l<r){
                    int snowman2 = arr[l] + arr[r];
                    int diff = Math.abs(snowman1 - snowman2);
                    minDiff = Math.min(minDiff, diff);
                    if(snowman1 > snowman2){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        System.out.println(minDiff);


    }

}