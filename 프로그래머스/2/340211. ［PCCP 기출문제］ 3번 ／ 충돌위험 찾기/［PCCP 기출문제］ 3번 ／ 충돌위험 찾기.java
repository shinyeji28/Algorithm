import java.util.*;
class Solution {
    static int[][] points;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int size = 100;
    static List<List<Integer>> paths = new ArrayList<>();
    static public class Node{
        int x;
        int y;
        int d;
        List<Integer> routes;
        public Node(int x, int y, int d, List<Integer> routes){
            this.x = x;
            this.y = y;
            this.d = d;
            this.routes = new ArrayList<>(routes);
            this.routes.add(x*size+y);
        }
    }
    
    public int solution(int[][] point, int[][] routes) {
        int answer = 0;
        points = point;
        
        
        for(int[] r : routes){
            boolean newList = true;
            for(int i=0;i<r.length-1;i++){
               bfs(r[i]-1, r[i+1]-1, newList);
               newList = false;
            }
        }
        
        answer = checkConflict();
        
        return answer;
    }
    public static int checkConflict(){

        int cnt=0;
        // int j=0;
        int maxSize = 0;
        for(int i=0;i<paths.size();i++){
            maxSize = Math.max(maxSize, paths.get(i).size());
        }        
        
//         while(j < maxSize){
//             boolean[] visited = new boolean[size*size];
//             boolean[] flag = new boolean[size*size];
//             int i = 0;
//             while(i < paths.size()){
//                 if(j >= paths.get(i).size()){
//                     i++;
//                     continue;
//                 }
//                 int idx = paths.get(i).get(j);
               
//                 if(!flag[idx] && visited[idx]){
//                     flag[idx] = true;
//                     cnt++;
//                 }
//                 visited[idx] = true;
//                 i++;
//             }
//             j++;
//         }
        for(int j=0;j<maxSize;j++){
            int[] check = new int[size*size];
            for(int i=0;i<paths.size();i++){
                if(paths.get(i).size() <= j) continue;

                int num = paths.get(i).get(j);
                if(check[num]==1){
                    cnt++;
                }
                check[num]++;
            }
        }
        return cnt;

    }
    
    public static void bfs(int sIdx, int eIdx, boolean newList){
        int sx = points[sIdx][0]-1;
        int sy = points[sIdx][1]-1;
        int ex = points[eIdx][0]-1;
        int ey = points[eIdx][1]-1;
        Queue<Node> pq = new ArrayDeque<>();
        
        pq.offer(new Node(sx, sy,0, new ArrayList<>()));
        boolean[][] visited = new boolean[size][size];
        visited[sx][sy] = true;
        
        // int[][] distance = new int[size][size];
        // for(int i=0;i<size;i++){
        //     Arrays.fill(distance[i], Integer.MAX_VALUE);
        // }
        // distance[sx][sy] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(ex == node.x && ey == node.y){
                if(newList) paths.add(node.routes);
                else {
                    node.routes.remove(0);
                    paths.get(paths.size()-1).addAll(node.routes);
                }
                return;
            }
            
            for(int d=0;d<4;d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if(nx<0||ny<0||nx>=size||ny>=size)continue;
                if(visited[nx][ny])continue;
                
                // if(distance[nx][ny] > distance[node.x][node.y] + 1){
                //     distance[nx][ny] = distance[node.x][node.y] + 1;
                    visited[nx][ny] = true;
                    pq.offer(new Node(nx, ny, node.d+1, node.routes));
                // }

            }
        }
        
    }
    
}

