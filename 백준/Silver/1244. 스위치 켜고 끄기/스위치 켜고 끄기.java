import java.util.*;
import java.io.*;
public class Main {
    static boolean[] swtiches;
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        swtiches = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=n;i++){
            swtiches[i] = Integer.parseInt(st.nextToken()) == 1;
        }
        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 1){
                girl(Integer.parseInt(st.nextToken()));
            }else{
                boy(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=1;i<swtiches.length;i++){
            sb.append(swtiches[i]?1:0).append(" ");
            if(i%20==0)sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void girl(int idx){
        for(int i=idx;i<swtiches.length;i+=idx){
            swtiches[i] = !swtiches[i];
        }
    }
    public static void boy(int idx){
        swtiches[idx] = !swtiches[idx];
        int left = idx;
        int right = idx;
        while(true){
            left--;
            right++;
            if(left<1 || right>=swtiches.length|| swtiches[left] != swtiches[right])break;
            swtiches[left] = !swtiches[left];
            swtiches[right] = !swtiches[right];
        }
    }

}