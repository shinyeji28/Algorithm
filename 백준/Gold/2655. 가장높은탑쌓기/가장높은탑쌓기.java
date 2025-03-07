    import java.util.*;
    import java.io.*;
    public class Main{
        static class Node implements Comparable<Node>{
            int w;
            int h;
            int weight;
            int idx;
            public Node(int w, int h, int weight, int idx){
                this.w = w;
                this.h = h;
                this.weight = weight;
                this.idx = idx;
            }

            public int compareTo(Node node){
                return Integer.compare(this.w, node.w);
            }
        }
        public static void main(String[] agrs) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[n];
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(w,h,weight,i+1);
            }
            Arrays.sort(nodes);

            int[][] dp = new int[n][2];
            for(int i=0;i<n;i++){
                dp[i][0] = -1;
                dp[i][1] = nodes[i].h;
            }
            dp[0][1] = nodes[0].h;
            for(int i=1;i<n;i++){
                int j=i;
                while(j>=0){
                    if(nodes[i].weight > nodes[j].weight){
                        if(dp[i][1] < dp[j][1] + nodes[i].h){
                            dp[i][0] = j;
                            dp[i][1] = dp[j][1] + nodes[i].h;
                        }
                    }
                    j--;
                }
            }

//            int top = 0;
//            int idx = -1;
//            for(int i=0;i<n;i++){
//                if(dp[i][1] > top){
//                    top = dp[i][1];
//                    idx = i;
//                }
//            }
//
//            StringBuilder sb = new StringBuilder();
//            int prev = idx;
//            int cnt = 0;
//            while(prev != -1){
//                sb.append('\n').append(nodes[prev].idx);
//                prev = dp[prev][0];
//                cnt++;
//            }
//            System.out.println(cnt);
//            System.out.println(sb.reverse());


            // 최대 높이와 그 인덱스 찾기
            int maxHeight = 0;
            int lastIndex = -1;
            for (int i = 0; i < n; i++) {
                if (dp[i][1] > maxHeight) {
                    maxHeight = dp[i][1];
                    lastIndex = i;
                }
            }

            // 경로 추적하여 결과 출력
            List<Integer> result = new ArrayList<>();
            while (lastIndex != -1) {
                result.add(nodes[lastIndex].idx); // 원래 입력된 번호 저장
                lastIndex = dp[lastIndex][0];
            }

            System.out.println(result.size()); // 사용된 벽돌 개수 출력
            for (int i = result.size() - 1; i >= 0; i--) { // 역순으로 출력
                System.out.println(result.get(i));
            }
        }
    }