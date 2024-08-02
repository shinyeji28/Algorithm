import java.util.*;
import java.io.*;
public class Main {
    static int[] nums;
    static int k;
    static boolean[] visited;
    static int[] pick;
    static HashSet<String> sh;
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        nums = new int[n];
        visited = new boolean[n];
        pick = new int[k];
        sh = new HashSet<>();
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        permutation(0);
        System.out.println(sh.size());
    }
    public static void permutation(int depth){
        if(depth == k){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<k;i++){
                sb.append(pick[i]+"");
            }
            sh.add(sb.toString());
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i])continue;
            visited[i] = true;
            pick[depth] = nums[i];
            permutation(depth+1);
            visited[i] = false;
        }
    }
}