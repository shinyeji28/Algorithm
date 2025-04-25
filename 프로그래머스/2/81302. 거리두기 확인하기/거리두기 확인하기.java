import java.util.*;
// 거리 2 : 대각에 사람 있다면 거리 1인 곳 2개 모두 파티션 있어야 함
//          상하좌우에 사람 있다면 거리 1인 곳 1개에 파티션 있어야함
// 거리 1 : 불가

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0, 0};
        int[] dx1 = new int[]{1,-1,1,-1};
        int[] dy1 = new int[]{1,-1,-1, 1};
        for(int t=0;t<5;t++){
            String[] place = places[t];
            int result = 1;
            
            // 사람 위치 찾기
            Queue<int[]> people = new ArrayDeque<>();
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(place[i].charAt(j)=='P'){
                        people.offer(new int[]{i,j});
                        
                    }

                }
            }
            
            A: for(int[] person : people){
                int x = person[0];
                int y = person[1];
                for(int d=0;d<4;d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(nx<0||ny<0||nx>=5||ny>=5)continue;
                    if(place[nx].charAt(ny) == 'P') {
                        result = 0;
                        System.out.println(nx+" "+ny);
                        break A;
                    }
                }
                for(int d=0;d<4;d++){
                    int nx = x + dx[d]*2;
                    int ny = y + dy[d]*2;
                    if(nx<0||ny<0||nx>=5||ny>=5)continue;
                    if(place[nx].charAt(ny) == 'P') {
            
                        if(place[x + dx[d]].charAt(y + dy[d]) !='X' ){
                            result = 0;
                            break A;
                        }
                    }
                }
                // 대각
                for(int d=0;d<4;d++){
                    int nx = x + dx1[d];
                    int ny = y + dy1[d];
                    if(nx<0||ny<0||nx>=5||ny>=5)continue;
                    if(place[nx].charAt(ny) == 'P') {
                
                        if(place[x + dx1[d]].charAt(y) !='X'||place[x].charAt(y+dy1[d])!='X' ){
                            result = 0;
                            break A;
                        }
                    }
                }              
                
            }
            
            answer[t] = result;
        }
        
        return answer;
    }
}