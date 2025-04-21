/*
최소 신장 트리 - 크루스칼 알고리즘 : 가중치 오름차순 정렬, union-find (사이클 발생 탐색)
*/ 
import java.util.*;
class Solution {
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
        }
        
        Arrays.sort(costs, (a,b)->a[2]-b[2]);

        for(int[] cost:costs){
            if(find(cost[0]) == find(cost[1]))continue;
            union(cost[0],cost[1]);
            answer += cost[2];
        }
        
        return answer;
    }
    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa <= fb) parents[fb] = fa;
        else parents[fa] = fb;
    }
    public static int find(int a){
        if(parents[a] == a)return a;
        return parents[a] = find(parents[a]);
    }
}