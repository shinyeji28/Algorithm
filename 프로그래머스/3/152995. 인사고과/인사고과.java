/*
    1. 임의의 사원보다 두 점수가 모두 낮으면 -1 -> sorting
    2. 인센 받는 사람
        합을 구해 sorting
*/

import java.util.*;
class Solution {
    public static class Node implements Comparable<Node>{
        int idx;
        int[] score;
        public Node(int idx, int[] score){
            this.idx = idx;
            this.score = score;
        }
        public int compareTo(Node node){
            if(this.score[0]==node.score[0]){
                return this.score[1] - node.score[1];
            }
            return node.score[0] - this.score[0];
        }
        
    }
    public int solution(int[][] scores) {
        int answer = 0;
        
        Node[] arr = new Node[scores.length];
        for(int i=0;i<scores.length;i++){
            arr[i] = new Node(i, scores[i]);
        }
        
        Arrays.sort(arr);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(b.score[0]+b.score[1]) - (a.score[0]+a.score[1])); 
        
        int maxValue = 0;
        for(Node node : arr){
            if(node.score[1] < maxValue){
                if(node.idx == 0)return -1;
            }else{
                maxValue = Math.max(maxValue, node.score[1]);
                pq.offer(node);
            }
        }
        
        int idx = 1;
        int rank = 1;
        int prevSum = -1;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(prevSum != node.score[0]+node.score[1]) rank = idx;
            if(node.idx==0) break;
            idx++;
            prevSum = node.score[0]+node.score[1];
        }
        
        return rank;
    }
}
