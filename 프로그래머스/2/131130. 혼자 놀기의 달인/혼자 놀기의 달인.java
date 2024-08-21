import java.util.*;
class Solution {
    public int solution(int[] cards) {
        
        List<Integer> counts = new ArrayList<>();
        boolean[] visited = new boolean[cards.length];

        for(int c: cards){
            if(visited[c-1]) continue;
            int pick = c-1;
            int cnt = 0;
            while(!visited[pick]){
                cnt++;
                visited[pick] = true;
                pick = cards[pick]-1;
            }
            counts.add(cnt);
        }
        
        if(counts.size()==1)return 0;
        
        Collections.sort(counts,(a,b)->b-a);

        return (counts.get(0) * counts.get(1));
    }
}