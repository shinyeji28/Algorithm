import java.util.*;
class Solution {
    public int solution(int[][] land) {
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        
        int[][] oil = new int[land.length][land[0].length]; 
        HashMap<Integer, Integer> oilCost = new HashMap<>();
        
        // 석유 값 구하기
        boolean[][] visited = new boolean[land.length][land[0].length];
        int idx = 0;

        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j] == 0 || visited[i][j])continue;
                idx+=1;

                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{i,j});
                visited[i][j] = true;
                int cnt = 0;
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    cnt++;
                    oil[x][y] = idx;
                    for(int d=0;d<dx.length;d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if(nx<0||ny<0||nx>=land.length||ny>=land[0].length||visited[nx][ny] || land[nx][ny]==0)continue;
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
                oilCost.put(idx,cnt);
            }
        }

        // 시추관 파기
        int totalMaxCost = 0; // 전체 가장 큰 수
        for(int j=0;j<land[0].length;j++){
            int sum = 0; // 한줄 합
            HashSet<Integer> hs = new HashSet<>();         // 동일한 오일 구역을 시추했는지 확인
            for(int i=0;i<land.length;i++){
                if(oil[i][j] == 0)continue;
                if(!hs.contains(oil[i][j])){
                    sum += oilCost.get(oil[i][j]);
                    hs.add(oil[i][j]);
                }
            }
            totalMaxCost = Math.max(totalMaxCost, sum);
        }
        return totalMaxCost;

    }
}