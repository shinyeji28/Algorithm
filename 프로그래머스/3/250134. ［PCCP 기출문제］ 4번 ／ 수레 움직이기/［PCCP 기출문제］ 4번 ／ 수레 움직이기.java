/*
각 턴 마다 red, blue 위치를 함께 저장 pq
*/
import java.util.*;
class Solution {
    static int[] size = new int[2];
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static int[] destination = new int[]{3,4};
    static int[][] maze;
    static int[][] permu = new int[2][2];
    static boolean[] arrival = new boolean[2];
    
    static public class Node implements Comparable<Node>{
        int[][] pos;
        int[] mask;  // red, blue 방문 배열 대신 비트 마스킹
        int turn;
        
        public Node(int[][] pos, int[] mask, int turn){
            this.pos = pos;
            this.mask = mask;
            this.turn = turn;
        }
        public int compareTo(Node node){
            return this.turn - node.turn;
        }
    }
    public int solution(int[][] mazee) {
        maze = mazee;        
        size[0] = maze.length;
        size[1] = maze[0].length;        
        int answer = 0;
        int[][] pos = new int[2][2];
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                if(maze[i][j] == 1) {
                    pos[0][0] = i;
                    pos[0][1] = j;
                }
                if(maze[i][j] == 2) {
                    pos[1][0] = i;
                    pos[1][1] = j;
                }
            }
        }
    
        
        pq.offer(new Node(pos, new int[]{1<<indexToNum(pos[0][0],pos[0][1]), 1<<indexToNum(pos[1][0], pos[1][1])}, 0));
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            
            int rx = node.pos[0][0];
            int ry = node.pos[0][1];
            int bx = node.pos[1][0];
            int by = node.pos[1][1];

            if(maze[rx][ry] == destination[0] && maze[bx][by] == destination[1]){
                answer = node.turn;
                break;
            }else if(maze[rx][ry] == destination[0]) arrival[0] = true;
            else if( maze[bx][by] == destination[1]) arrival[1] = true;
            movingPermutation(node, 0);           
            
        }
        
        return answer;
    }
    public static void movingPermutation(Node node, int depth){

        if(depth == 2){
            int rx = permu[0][0];
            int ry = permu[0][1];
            int bx = permu[1][0];
            int by = permu[1][1];
            
            
            pq.offer(new Node(copy(permu), new int[]{node.mask[0] | (1<<indexToNum(rx,ry)), node.mask[1] | (1<<indexToNum(bx,by))}, node.turn+1));
            return;
        }
        int x = node.pos[depth][0];
        int y = node.pos[depth][1];

        if(maze[x][y] == destination[depth]){
            permu[depth][0] = x;
            permu[depth][1] = y;
            movingPermutation(node, depth+1);           
            return;
        }
        for(int d = 0;d < 4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx<0||ny<0||nx>=size[0] || ny>=size[1] || maze[nx][ny]==5)continue;
            if(depth==1 && permu[0][0]==nx && permu[0][1]==ny) continue;  // 동일한 곳 못감
            if(depth==1 && permu[0][0]==x && permu[0][1]==y & nx==node.pos[0][0] && ny == node.pos[0][1] ) continue;// 서로 위치 변경 불가
            if(isVisited(nx, ny, node.mask[depth])) continue;
            if(arrival[(depth+1)%2] && nx == node.pos[(depth+1)%2][0] && ny == node.pos[(depth+1)%2][1])continue;
                
            permu[depth][0] = nx;
            permu[depth][1] = ny;
            movingPermutation(node, depth+1);           
        } 
    }
    public static boolean isVisited(int nx, int ny, int visitedMask){
        int cur = indexToNum(nx,ny);
        if((visitedMask & (1 << cur)) !=0) return true;
        return false;
    }
    public static int indexToNum(int x, int y){
        return x * size[1] + y;
    }
    public static int[][] copy(int[][] arr){
        int[][] newarr = new int[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                newarr[i][j] = arr[i][j];
            }
        }
        return newarr;
    }
}