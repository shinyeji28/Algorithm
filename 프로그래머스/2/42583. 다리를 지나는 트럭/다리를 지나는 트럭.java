import java.util.*;
class Solution {
    static class Truck{
        int w;
        int end;
        public Truck(int w, int end){
            this.w = w;
            this.end = end;  // 다리를 지난 시점
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truckQueue = new ArrayDeque<>();
        Queue<Truck> bridgeQueue = new ArrayDeque<>();
        for(int t : truck_weights){
            truckQueue.offer(t);
        }
        int time = 0;
        int totalWeight = 0;
        while(!truckQueue.isEmpty() || !bridgeQueue.isEmpty()){
            time++;
            if(!bridgeQueue.isEmpty() && bridgeQueue.peek().end == time){
                totalWeight -= bridgeQueue.poll().w;

            }
            if(!truckQueue.isEmpty() && truckQueue.peek() + totalWeight <= weight && bridgeQueue.size() < bridge_length){
                int w = truckQueue.poll();
                bridgeQueue.offer(new Truck(w, time + bridge_length));
                totalWeight += w;
            }
        }
        return time;
    }
}