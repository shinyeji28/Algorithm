import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> maps = new HashMap<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.length() < m) continue;
            maps.put(str, maps.getOrDefault(str, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)->{
            if(a.getValue() == b.getValue()){
                if(a.getKey().length() == b.getKey().length()){
                    return a.getKey().compareTo(b.getKey());
                }
                return b.getKey().length() - a.getKey().length();
            }
            return b.getValue() - a.getValue();
        });

        for(Map.Entry<String, Integer> map : maps.entrySet()){
            pq.offer(map);
        }

        while(!pq.isEmpty()){
            sb.append(pq.poll().getKey()).append('\n');
        }
        System.out.println(sb);


    }

}