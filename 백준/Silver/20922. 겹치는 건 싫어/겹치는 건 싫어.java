/*
* 슬라이드 윈도우 문제
* left idx = 최장 연속 부분 수열의 시작 pointer
* right idx = 최장 연속 부분 수열의 종료 pointer
* */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        int[] counting = new int[100001];
        int left = 0,right = 0;
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        int maxValue = 1;
        while(right<n){
            int num = array[right];
            if(counting[num] >= k){
                for(int j=left;j<=right;j++){
                    if(array[j] == num){
                        counting[array[left]]--;
                        left++;
                        break;
                    }
                    counting[array[left]]--;
                    left++;
                }
            }
            maxValue = Math.max(maxValue, right - left +1);
            counting[num]++;
            right++;
        }
        System.out.println(maxValue);
    }
}