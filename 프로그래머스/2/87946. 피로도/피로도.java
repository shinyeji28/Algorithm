class Solution {
    static boolean[] visited;
    static int n;
    static int[][] d;
    static int maxCnt;
    public int solution(int k, int[][] dungeons) {
        // 순열
        visited = new boolean[dungeons.length];
        n = dungeons.length;
        d = dungeons;
        permutation(k, 0, 0);
        return maxCnt;
    }
    public static void permutation(int enery, int cnt, int depth){
        if(n == depth){
            maxCnt = Math.max(maxCnt, cnt);
        }
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            visited[i] = true;
            if(enery >= d[i][0]){
                permutation(enery - d[i][1], cnt+1 ,depth+1);
            }else{
                permutation(enery, cnt ,depth+1);
            }
            visited[i] = false;
        }
    }
}