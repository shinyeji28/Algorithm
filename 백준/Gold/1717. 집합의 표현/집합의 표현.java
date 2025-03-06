import java.util.*;
import java.io.*;
public class Main{
    static int[] uf;
    public static void main(String[] agrs) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        uf = new int[n+1];

        //초기화
        for(int i=0;i<=n;i++){
            uf[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(flag == 0) union(a,b);
            else {
                if(isConnected(a,b))sb.append("YES").append('\n');
                else sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);

    }
    public static void union(int a, int b){
        int f1 = find(a);
        int f2 = find(b);
//        if(f1 < f2){
//            uf[f2] = f1;
//        }else{
//            uf[f1] = f2;
//        }
        if(f1!=f2) uf[f1] = f2;  
    }
    public static int find(int a){
        if(uf[a] != a) {
            uf[a] = find(uf[a]);
        }
        return uf[a];
    }
    public static boolean isConnected(int a,int b){
        return find(a) == find(b);
    }
}