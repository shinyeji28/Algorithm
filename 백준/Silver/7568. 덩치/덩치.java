import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] info = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            info[i][0] = weight;
            info[i][1] = height;
        }

        for(int i=0;i<n;i++){
            int cnt=1;
            for(int j=0;j<n;j++){
                if(i!=j && (info[i][0] < info[j][0]) && (info[i][1] < info[j][1])) cnt++;
            }
            sb.append(cnt+" ");
        }
        System.out.println(sb);
    }

}