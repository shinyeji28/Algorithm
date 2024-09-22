import java.util.*;

class Solution {

    static boolean[][] visited;
    static int maxArea = -1;
    public int solution(int[] mats, String[][] park) {
        
        visited = new boolean[park.length][park[0].length];
        
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length;j++){
                if(park[i][j].equals("-1")){
                    maxArea = Math.max(countArea(i, j, park),maxArea);
                }
            }
        }
        
        Arrays.sort(mats);
       
        for(int i=mats.length-1;i>=0;i--){
            if(maxArea >= mats[i]){                
                return mats[i];
            }
        }
        
        return -1;
    }
    
    public static int countArea(int x, int y, String[][] park){
        
        int size = 0;
        
        while(true){
            if(x + size >=park.length || y + size >= park[0].length)break;
            
            for(int i=0;i<=size;i++){
                if(!park[x+size][y+i].equals("-1") || !park[x+i][y+size].equals("-1")){
                    return size;
                }
            }
            for(int i=0;i<=size;i++){
                visited[x+size][y+i] = visited[x+i][y+size] = true;
            }
            size++;

        }
        return size;
    }
}