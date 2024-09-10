import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] number;
    static int[]operation;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;


    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[n];
        operation = new int[4];
        for(int i=0;i<n;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            operation[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0, number[0]);
        System.out.println(maxValue);
        System.out.println(minValue);

    }
    public static void permutation(int depth, int sum){
        if(depth == n-1){
            maxValue = Math.max(sum, maxValue);
            minValue = Math.min(sum, minValue);
        }
        for(int i=0;i<4;i++){
            if(operation[i]==0)continue;
            operation[i]--;
            int tempSum = sum;
            switch(i){
                case 0 : tempSum += number[depth+1]; break;
                case 1 : tempSum -= number[depth+1]; break;
                case 2 : tempSum *= number[depth+1]; break;
                case 3 :
                    if(tempSum < 0){
                        tempSum *= -1;
                        tempSum /= number[depth+1];
                        tempSum *= -1;
                    }
                    else tempSum /= number[depth+1];
                    break;
            }
            permutation(depth+1, tempSum);
            operation[i]++;

        }
    }

}