import java.util.*;
import java.io.*;
public class Main{
    static int parents[];
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
        }
        int answer = 0;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            if(isCycle(to, from)) {
                answer = i+1;
                break;
            }
            union(to, from);

        }
        System.out.println(answer);
    }
    public static void union(int a, int b){
        int f1 = find(a);
        int f2 = find(b);
        if(f1 <= f2){
            parents[f2] = f1;
        }else parents[f1] = f2;
    }
    public static int find(int a){
        if(a == parents[a]) return a;
        parents[a] = find(parents[a]);
        return parents[a];
    }
    public static boolean isCycle(int a, int b){
        if(find(a) == find(b)) return true;
        return false;
    }
}