import java.util.*;

class Solution {
    static char[][] map;
    static Queue<Integer> toZero = new ArrayDeque<>();
    static Queue<Integer> toOne = new ArrayDeque<>();
    static int m,n;
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        map = new char[storage.length+2][storage[0].length()+2];
        n = map.length;
        m = map[0].length;
        for(int i=0;i<map.length;i++){
            Arrays.fill(map[i],'0');
        }
        for(int i=0;i<storage.length;i++){
            for(int j=0;j<storage[0].length();j++){
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for(String request : requests){
            toZero.clear();
            toOne.clear();
            char r = request.charAt(0);
            boolean crain = false;
                        
            if(request.length()==2){  //모든 target제거
                crain = true;
            }
            
            // '0' : 창고외부와 연결
            // '1' : 비어있지만 창구외부와 연결 안됨
            for(int i=1;i<n-1;i++){
                for(int j=1;j<m-1;j++){
                    if(map[i][j] == r){
                        if(task(i,j))toZero.offer(i*m+j);
                        if(crain)toOne.offer(i*m+j);
                    }                    
                    
                }
            }
            while(!toZero.isEmpty()){
                int idx = toZero.poll();
                int x = idx / m;
                int y = idx % m;
                map[x][y] = '0';
            }
            while(!toOne.isEmpty()){
                int idx = toOne.poll();
                int x = idx / m;
                int y = idx % m;
                map[x][y] = '1';
            }
            bfs();        
        }
        
        for(int i=1;i<map.length-1;i++){
            for(int j=1;j<map[0].length-1;j++){      
                if(!(map[i][j] == '0' || map[i][j] == '1')) answer++;
            }
        }
        return answer;
    }
    public static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0|| ny<0||nx>=n||ny>=m||visited[nx][ny]||!(map[nx][ny]=='0'||map[nx][ny]=='1'))continue;
                visited[nx][ny] = true;
                if(map[nx][ny]=='1')map[nx][ny] = '0';
                q.offer(new int[]{nx,ny});
            }
        }
    }
    public static boolean task(int x,int y){

        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(map[nx][ny] =='0'){
                return true;
            }
        }
        return false;
    }

}