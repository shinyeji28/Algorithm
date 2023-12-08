/*
    1. 시작 시간을 기준으로 오름차순으로 정렬된 s_pq - 강의실 배전 전 강의
    2. 끝 시간을 기준으로 오름차순으로 정렬된 e_pq - 강의실이 배정된 강의
    s_pq - pop() 한 것과 e_pq - pop()한 것을 비교하여 e_pq의 end값 <= s_pq의 start값 이면 
                    같은 강의실 배정임으로 s_pq Node를 e_pq에 넣는다.
    그게 아니면 새로운 강의실 추가
                
*/
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      PriorityQueue<Node> s_pq = new PriorityQueue<>((n1, n2)-> Long.compare(n1.start, n2.start));
      PriorityQueue<Node> e_pq = new PriorityQueue<>((n1, n2)-> Long.compare(n1.end, n2.end));
      
      StringTokenizer st;
      for(int i=0;i<N;i++){
        st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());
        
        s_pq.offer(new Node(start,end));
      }
      
      // 가장 빠른 start time의 강의 처리
      e_pq.offer(s_pq.poll());
      long classRoom = 1;  // 강의실 수

      A: while(!s_pq.isEmpty()){
          if(e_pq.isEmpty()) {
              classRoom += s_pq.size();
              break;
          }
          Node stdStart = s_pq.poll();
          Node stdEnd = e_pq.peek();
          
          if(stdEnd.end <= stdStart.start){ // 기존의 존재하는 강의실로 배정
              e_pq.poll();
              e_pq.offer(stdStart);         
              continue A;
          }else{
              e_pq.offer(stdStart);         
              // 강의실을 추가해야 함
              classRoom++;
          }
      }
      System.out.println(classRoom);
    }
    
    public static class Node{
        long start;
        long end;
        public Node(long s,long e){
            this.start = s;
            this.end = e;
        }
    }
    
}