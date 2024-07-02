/*
* 보석 하나만 가방에 넣을 수 있다
* 그리디 + 우선순위 큐
*
* 보석을 무게 기준으로 정렬한 후 가방에 담을 수 있는 보석이면 우선순위 큐에 넣고 가장 가치가 높은 것을 저장한다.
* */
import java.io.*;
import java.util.*;
public class Main {
    public static class Item implements Comparable<Item>{
        int w,v;
        public Item(int w, int v){
            this.w = w;
            this.v = v;
        }
        public int compareTo(Item item){
            return Integer.compare(this.w, item.w);
        }
    }
    public static void main(String[] agrs) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(Integer.compare(a,b)*(-1)));
        Item[] item = new Item[n];
        long[] bag = new long[k];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            item[i] = new Item(w,v);
        }
        for(int i=0;i<k;i++){
            bag[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(bag);
        Arrays.sort(item);
        long result = 0;
        int idx = 0;
        for(int i=0;i<k;i++){
            while(idx<n && bag[i]>=item[idx].w){
                pq.offer(item[idx].v);
                idx++;
            }
            if(!pq.isEmpty()) result += pq.poll();
        }
        System.out.println(result);
    }
}