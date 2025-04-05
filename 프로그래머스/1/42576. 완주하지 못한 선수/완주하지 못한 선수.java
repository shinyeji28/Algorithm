import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = ""; 
        
        // 이름 정렬 후 선형탐색으로 이름이 다른다면 완주하기 못한 선수임 (완주 못한 선수는 1명이기 때문)
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        answer = participant[participant.length-1];

        for(int i=0;i<completion.length;i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        } 
        return answer;
    }
}