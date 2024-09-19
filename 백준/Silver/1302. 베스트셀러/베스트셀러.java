import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)->{
            if(a.getValue() == b.getValue()){
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        }); 
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            map.put(title,map.getOrDefault(title,0) +1);
        }

        for(Map.Entry<String,Integer> m : map.entrySet()){
            pq.offer(m);
        }
        System.out.println(pq.poll().getKey());
        

    }

}