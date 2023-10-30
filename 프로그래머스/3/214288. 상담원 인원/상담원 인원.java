/*
    n : 상담원 수
    k : 유형 개수
    
    출력> 
    참가자들이 상담을 받기까지 기다린 시간을 모두 합한 값의 최솟값
    
    구현 방법>
    1. 재귀를 사용해 k에 n을 채울 수 있는 경우 구하기
        depth = 최대 k, for(1 ~ (n-k+1)) 
            - 백트래킹
              depth != k && sum = n :   각 유형별로 멘토 인원이 적어도 한 명 이상을 불만족 시킬 때
    2. 각 경우마다 기다린 시간 측정
        재귀의 기저조건
        : 배열(k) 안의 리스트(배치된 상담인원만큼) - 종료시간만 저장 = 기다린 시간(시작시간 - 해당 유형을 탐색하면서 종료시간이 작은 것) + 시작 + 상담   -> pq를 활용
            if 기다린 시간이 음수면 0으로 set
            reqs의 순서대로 상담 시작   
    3. 기단린 시간의 최소 값을 저장 후 출력
    
   
    
*/
import java.util.*;
import java.io.*;
class Solution {
    static int K;
    static int N;
    static int[] people;
    static int[][] reqs;
    static PriorityQueue<Integer>[] graph;
    static int sumWaitTime;
    public int solution(int k, int n, int[][] req) {
        K = k;
        N = n;
        reqs = req;
        
        people = new int[k];
        graph = new PriorityQueue[k];
        sumWaitTime = Integer.MAX_VALUE;
        
        recursive(0, 0);

        
        return sumWaitTime;
    }
    private static void recursive(int depth, int sum){
        
        if(depth == K){  
            if(sum == N){ // 상담원 배치 완료
                // 상담원 물리적 배치
                System.out.println(Arrays.toString(people));
                for(int i=0;i<K;i++){
                    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                    graph[i] = pq;
                }
                solution();
                
            }
            return;
        }
        if(sum == N) return; // 적어도 한 명 이상을 불만족 시킬 때

        
        for(int i=1;i<= N-K+1 ;i++){
            people[depth] = i;
            recursive(depth+1,sum+i);
        }
    }
    
    private static void solution(){
        int total = 0;
        for(int i=0;i<reqs.length;i++){
            //종료시간만 저장 = 기다린 시간(시작시간 - 해당 유형을 탐색하면서 종료시간이 작은 것) + 시작 + 상담 
            int k = reqs[i][2]-1;  // 유형
            int time = 0;
            if(graph[k].isEmpty() || graph[k].size() < people[k]){      // 배치된 상담 인원 사이즈만큼 큐 활용 
                time = reqs[i][0] + reqs[i][1];
            }else{
                int temp = graph[k].poll();
                int remain = temp - reqs[i][0];
                if(remain<0) remain = 0;
                time = reqs[i][0] + reqs[i][1] + remain;
                total += remain;
            }
            if(sumWaitTime<=total)return;
            graph[k].offer(time);
        }
        sumWaitTime = Math.min(sumWaitTime,total);
    }
}