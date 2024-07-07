/*
* 연산자 순열
* 연산의 중복을 줄이기 위해 + - * / 로만 for문으로 하나씩 선택 (단, 사용하지 않는 연산자를 사용하기)
* 사용한 연산자 개수 감소
* */
import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    static int[] operator;
    static int[] numbers;
    static long minValue;
    static long maxValue;
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            n = Integer.parseInt(br.readLine());
            operator = new int[4]; // '+', '-', '*', '/'
            numbers = new int[n];
            minValue = Long.MAX_VALUE;
            maxValue = Long.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<4;i++){
                operator[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            permutation(0,numbers[0]);
            sb.append("#"+(t+1)+" ").append(maxValue - minValue).append('\n');
        }
        System.out.println(sb);
    }
    public static void permutation(int depth, long result){
        if(depth == n-1){
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
            return;
        }
        for(int i=0;i<4;i++){
            if(operator[i]>0){
                operator[i]--;
                permutation(depth+1, calc(result, numbers[depth+1], i));
                operator[i]++;
            }
        }

    }
    public static long calc(long front, long rear, int operIdx){
        switch(operIdx){
            case 0 : return front + rear;
            case 1 : return front - rear;
            case 2 : return front * rear;
            case 3 : return front / rear;
        }
        return 0;
    }
}