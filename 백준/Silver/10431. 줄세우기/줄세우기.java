import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T;t++){
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            sb.append(Integer.parseInt(st.nextToken())+" ");
            for(int i=0;i<20;i++){
                int num = Integer.parseInt(st.nextToken());
                int re = Collections.binarySearch(list, num);
                if(re <= list.size()){
                    result += list.size() - (re*(-1)-1);
                }
                list.add((re*(-1)-1), num);
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

}