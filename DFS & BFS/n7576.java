package beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
6 4
1 -1 0 0 0 0
0 -1 0 0 0 0
0 0 0 0 -1 0
0 0 0 0 -1 1
0: 익지않은
1: 익은
-1: 없음
 * */
public class n7576 {
    static int[][] arr;
    static int size_x;
    static int size_y;
    static boolean effect = false;
    static int[][] visited; 
	static Queue<int[]> q = new LinkedList<>();

    public static void detection() {
    	int[] dx = {0,0,-1,1};
    	int[] dy = {1,-1,0,0};
    	while(!q.isEmpty()){
        	int[] v = q.poll();
        	int curX = v[0];
        	int curY = v[1];
        	for(int d=0;d<dx.length;d++) {
        		int x = curX + dx[d];
        		int y = curY + dy[d];
        		if(x>=0 && y>=0 && x<size_x && y<size_y && arr[x][y]!=1 && arr[x][y]!=-1) {
        			//최소 일로 갱신
        			if(arr[x][y]==0 || arr[x][y]>arr[curX][curY]+1) {
        				arr[x][y]=arr[curX][curY]+1;
            			q.offer(new int[] {x,y});

        			}
        		}
        	}
    	}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        size_y = Integer.parseInt(str[0]);
        size_x = Integer.parseInt(str[1]);
        arr = new int[size_x][size_y];

        for(int i=0;i<size_x;i++) {
        	String[] _str = bf.readLine().split(" ");
        	for(int j=0;j<size_y;j++) {
        		arr[i][j] = Integer.parseInt(_str[j]);
        	}
        }

        boolean flag = false;
        int result = 0;

        for(int i=0;i<size_x;i++) {
            for(int j=0;j<size_y;j++) {
            	if(arr[i][j]==1) {
                	q.offer(new int[] {i,j});
            	}
            }
        }
		detection();	// 익은 사과를 만날 때마다 bfs탐색
        for(int i=0;i<size_x;i++) {
            for(int j=0;j<size_y;j++) {
            	if(arr[i][j]==0) {
            		result = 0;
            		flag = true;
            		break;
            	}
            	result=Math.max(result,arr[i][j]);
            }
            if(flag)break;
        }
        
        System.out.println(result-1);
    }    

}

