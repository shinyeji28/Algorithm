import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int oneCol = W / (M+1);
        if(W % (M+1)!=0) oneCol++;

        int oneRow = H / (N+1);
        if(H % (N+1)!=0) oneRow++;

        System.out.println(oneCol * oneRow);

    }
}