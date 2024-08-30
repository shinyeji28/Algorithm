import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int idx;
        int price;
        public Node( int idx, int price){
            this.idx=idx;
            this.price = price;
        }
    }
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.price - b.price);

        int[] doroSum = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++){
            doroSum[i] = Integer.parseInt(st.nextToken());

        }
        for(int i=n-2;i>=0;i--){
            doroSum[i] += doroSum[i+1];
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int oil = Integer.parseInt(st.nextToken());
            pq.offer(new Node(i, oil));
        }

        int idx = n-1;
        int minPrice = 0;
        while(!pq.isEmpty()){
            if(idx == 0)break;
            Node node = pq.poll();
            if(idx < node.idx)continue;
            minPrice += node.price * (doroSum[node.idx] - doroSum[idx]);
            idx = node.idx;
        }

        System.out.println(minPrice);



    }

}