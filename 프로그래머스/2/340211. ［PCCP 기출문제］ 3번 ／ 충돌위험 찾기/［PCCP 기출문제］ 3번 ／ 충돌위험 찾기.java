import java.util.*;
class Solution {
    static final int SIZE = 100;
    static List<List<Integer>> history = new ArrayList<>();
    static int maxLen = 0;
    
    public static class Node{
        int x;
        int y;
        List<Integer> path;
        public Node(int x, int y, boolean newArray){
            this.x = x;
            this.y = y;
            this.path = new ArrayList<>();
            if(newArray) this.path.add(SIZE * x + y);
        }
        public Node(List<Integer> prevPath, int x, int y){
            this.x = x;
            this.y = y;
            this.path = new ArrayList<>(prevPath);
            this.path.add(SIZE * x + y);
            
        }
    }
    public int solution(int[][] points, int[][] routes) {
        
        int crush = 0;
        
        for(int[] route: routes){
            boolean newList = true;
            for(int i =0;i<route.length-1;i++){
                int sp = route[i]-1;
                int ep = route[i+1]-1;
                bfs(points[sp][0]-1, points[sp][1]-1, points[ep][0]-1, points[ep][1]-1, newList);
                newList = false;
            }
        }
        
        for(int j=0;j<maxLen;j++){
            int[] check = new int[SIZE*SIZE];
            for(int i=0;i<history.size();i++){
                if(history.get(i).size() <= j) continue;
                                
                int num = history.get(i).get(j);
                if(check[num]==1){
                    crush++;
                }
                check[num]++;
            }
        }
        
        return crush;
    }
    public static void bfs(int sx,int sy,int ex,int ey, boolean newList){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[SIZE][SIZE];
        int[][] distance = new int[SIZE][SIZE];
        
        for(int[] dis : distance){
            Arrays.fill(dis, Integer.MAX_VALUE);
        }
       
        q.offer(new Node(sx, sy, newList));
        
        visited[sx][sy] = true;
        distance[sx][sx] = 0;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if(x == ex && y == ey){
                if(newList){
                    history.add(cur.path);
                }else{
                    history.get(history.size()-1).addAll(cur.path);
                }
                maxLen = Math.max(maxLen, history.get(history.size()-1).size());
                return;
            }
            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0||ny<0||nx>=SIZE||ny>=SIZE||visited[nx][ny])continue;
                if(distance[nx][ny] > distance[x][y] + 1){
                    distance[nx][ny] = distance[x][y] + 1;
                    q.offer(new Node(cur.path, nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
 
}