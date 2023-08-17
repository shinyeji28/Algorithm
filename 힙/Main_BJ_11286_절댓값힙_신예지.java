package d230809;

import java.util.*;
import java.io.*;

public class Main_BJ_11286_절댓값힙_신예지 {

	public static void main(String[] args) throws Exception {
		
		PriorityQueue<Integer> min_pq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> max_pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int x;
		
		for(int i=0;i<N;i++) {
			x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(max_pq.size()==0 && min_pq.size()==0) {
					sb.append("0").append('\n');
					
				}else if(max_pq.size()==0){
					sb.append(min_pq.poll()).append('\n');

				}else if(min_pq.size()==0) {
					sb.append(max_pq.poll()).append('\n');

				}else {
					if(Math.abs(max_pq.peek()) <= Math.abs(min_pq.peek())) {
						sb.append(max_pq.poll()).append('\n');
					}else {
						sb.append(min_pq.poll()).append('\n');
					}
				}

			}
			else {
				if(x<0) {
					max_pq.add(x);
				}else {
					min_pq.add(x);
				}
			}

		}
		System.out.println(sb);
		
		

	}

}
