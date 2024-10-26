import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> genresCnt = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            genresCnt.put(genres[i], genresCnt.getOrDefault(genres[i], 0) + plays[i]);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry<String, Integer> entry : genresCnt.entrySet()){
            pq.offer(entry);
        }
        while(!pq.isEmpty()){
            Map.Entry<String, Integer> popularGenres = pq.poll();
            String key = popularGenres.getKey();
            Integer value = popularGenres.getValue();
            
            PriorityQueue<int[]> playsPQ = new PriorityQueue<>((a,b)->b[0] - a[0]); 
            int sum = 0;
            for(int i=0;i<genres.length;i++){
                if(genres[i].equals(key)){
                    
                    playsPQ.offer(new int[]{plays[i], i});    
                
                    sum += plays[i];
                    if(sum == value) break;
                }
            }
            int cnt = 0;
            while(!playsPQ.isEmpty()){
                answer.add(playsPQ.poll()[1]);
                cnt++;
                if(cnt == 2)break;
            }
        }
        
        
        
        return answer.stream().mapToInt(a->a).toArray();
    }
}