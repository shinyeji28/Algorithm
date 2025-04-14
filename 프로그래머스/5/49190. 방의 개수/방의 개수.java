/*
사이클이 존재하면 방이 생긴다.
HashSet으로 좌표와 간선 저장하기
대각선에 의해 생기는 교차점 때문에 2번씩 이동해야함
*/
import java.util.*;
class Solution {

    
    static HashSet<String> visitedNode = new HashSet<>();
    static HashSet<String> visitedEdge = new HashSet<>();
        
    public int solution(int[] arrows) {
        int[] dx = new int[]{-1,-1,0,1,1,1,0,-1};
        int[] dy = new int[]{0,1,1,1,0,-1,-1,-1};
        
        int roomCnt=0;
        int x = 0;
        int y = 0;
        visitedNode.add(makeNode(0,0));

        for(int d : arrows){
            for(int i=0;i<2;i++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                // 새로운 edge면서 방문한 적이 있는 node면 cycle발생
                if(!visitedEdge.contains(makeEdge(x, y, nx, ny))){
                    if(visitedNode.contains(makeNode(nx,ny))) roomCnt++;
                    else visitedNode.add(makeNode(nx,ny));

                    visitedEdge.add(makeEdge(x,y,nx,ny));
                }
                x = nx;
                y = ny;
            }
        }
        
        return roomCnt;
    }
    public static String makeNode(int x, int y){
        return x +" " + y;
    }
    public static String makeEdge(int x, int y, int nx, int ny){
        if(x<nx || (x==nx && y < ny)) return x +" " + y +" " + nx+" "+ny;
        return nx+" "+ny+" "+x +" " + y;
    }
}