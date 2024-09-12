import java.util.*;
import java.io.*;

public class Main {
    static HashMap<Integer, Integer> map;


    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t= 0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b.compareTo(a));
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            map = new HashMap<>();
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                char oper = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if(oper == 'I'){
                    maxHeap.offer(num);
                    minHeap.offer(num);
                    map.put(num, map.getOrDefault(num,0)+1);
                }else{
                    if(num<0){
                        checkRemove(minHeap);
                        if(minHeap.isEmpty())continue;
                        int value = minHeap.poll();
                        map.put(value, map.getOrDefault(value,1)  -1);

                    }else{
                        checkRemove(maxHeap);
                        if(maxHeap.isEmpty())continue;
                        int value = maxHeap.poll();
                        map.put(value, map.getOrDefault(value,1) -1);
                    }
                }

            }
            checkRemove(minHeap);
            checkRemove(maxHeap);

            if(minHeap.isEmpty() || maxHeap.isEmpty()){
                sb.append("EMPTY").append('\n');
            }else{
                sb.append(maxHeap.poll()+" "+minHeap.poll()).append('\n');
            }

        }
        System.out.println(sb);
    }
    public static void checkRemove(PriorityQueue<Integer> heap){
        while(!heap.isEmpty()){
            int peek = heap.peek();
            if(map.get(peek) == null || map.get(peek)==0){
                heap.poll();
            }else{
                break;
            }
        }
    }
}