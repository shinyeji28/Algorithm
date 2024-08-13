import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> sh = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            if(sh.containsKey(tangerine[i])){
                sh.put(tangerine[i], sh.get(tangerine[i])+1);
            }else{
                sh.put(tangerine[i], 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(Integer v : sh.values()){
            pq.offer(v);
        }
        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
            answer++;
            if(sum>=k){
                break;
            }
        }
        return answer;
    }
}