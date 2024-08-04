import java.util.*;
class Solution {
    public static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x =x;
            this.y =y;
        }
    }
    public int solution(String[] board) {
        int answer = -1;
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        Node start = null;
        A : for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j) == 'R'){
                    start = new Node(i,j);
                    break A;
                }
            }
        }
        
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length()];
        int[][] distance = new int[board.length][board[0].length()];
        for(int i=0;i<distance.length;i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        q.offer(new Node(start.x, start.y));
        visited[start.x][start.y] = true;
        distance[start.x][start.y] = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if(board[x].charAt(y) == 'G'){
                return distance[x][y];
            }
            for(int d=0;d<dx.length;d++){
                int px = cur.x;
                int py = cur.y;
                while(true){
                    int nx = px + dx[d];
                    int ny = py + dy[d];
                    if(nx<0||ny<0||nx>=board.length||ny>=board[0].length() ||board[nx].charAt(ny)=='D')break;        
                    px = nx;
                    py = ny;
                }
                if(distance[px][py] > distance[x][y] + 1){
                    visited[px][py] = true; 
                    distance[px][py] = distance[x][y] + 1;
                    q.offer(new Node(px,py));
   
                }
            }
        }
        
        
        return -1;
    }
}