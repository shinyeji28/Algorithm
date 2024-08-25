import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int[] arr = new int[3];
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if(arr[0]==0 && arr[1]==0 && arr[2]==0)break;

            Arrays.sort(arr);
            if(arr[0]+arr[1] <= arr[2]) {
                sb.append("Invalid").append('\n');
                continue;
            }

            int sameCnt = 0;
            int prev = arr[0];
            for(int i=0;i<arr.length;i++){
                if(arr[i]==prev) sameCnt++;
                prev = arr[i];
            }
            switch(sameCnt){
                case 3 : sb.append("Equilateral");
                break;
                case 2 : sb.append("Isosceles");
                break;
                default : sb.append("Scalene");
                break;
            }
            sb.append('\n');

        }
        System.out.println(sb);
    }
}