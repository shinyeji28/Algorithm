package 분할과정복230814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 사용자의 전차 하나뿐
 * 
 * 포탄 : 벽돌(벽 파괴 -> 평지가 됨), 강철에 충돌할 때까지 직진
 * 		
 * @author SSAFY
 *
 * 전차의 시작 위치 찾기
 * 
 * 사방 탐색
 *
 *
 */

public class Solution_1873_상호의배틀필드_신예지2 {

	static char[][] map;
	static String[] moving;
	static int x;
	static int y;
	static int d;
	static int shootx;
	static int shooty;
	static int[] dx = {-1,1,0,0}; // U,D,L,R
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int t=0;t<T;t++){
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int H = Integer.parseInt(st.nextToken());
			 int W = Integer.parseInt(st.nextToken());
			 
			 map = new char[H][W];
			 for(int i=0;i<H;i++) {
				String temp[] = br.readLine().split("");
				for(int j=0;j<W;j++) {
					map[i][j] = temp[j].charAt(0);
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<'|| map[i][j] == '>') {
						 x = i;
						 y = j;
						d = direction(map[i][j]);
						map[i][j] = '.';
					}
					
				}
			 }
			 
			 int N = Integer.parseInt(br.readLine());
			 moving = br.readLine().split("");
			
			 for(String m : moving) {
				 if(m.equals("S")) {
					 shooting();
					 System.out.println(m);
				 }else {
					 moving(m);
				 }
			 }
			 
			 switch (d) {
			 case 0:
				 map[x][y] = '^';
				 break;
			 case 1:
				 map[x][y] = 'v';
				 break;
			 case 2:
				 map[x][y] = '<';	
				 break;
			 case 3:
				 map[x][y] = '>';
				 break;
			}
			 
	            sb.append("#"+(t+1)+" ");
	            for(int i=0; i<H; i++) {
	                sb.append(String.valueOf(map[i])).append('\n');
	            }
			 
		 }
		 System.out.println(sb);
	}
	private static void moving(String move) {

		switch (move) {
		case "U":
			d = 0;
			break;
		case "D":
			d = 1;
			break;
		case "L":
			d = 2;
			break;
		case "R":
			d = 3;
			break;
		}
		
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length || map[nx][ny] !='.' ) {
			return;
		}
		
		x = nx;
		y = ny;
	}
	
	private static void shooting() {
		int shootX = x;
		int shootY = y;
		
		while(true) {
			shootX += dx[d];
			shootY += dy[d];
			
			if(shootX<0 || shootY<0 || shootX>=map.length || shootY>=map[0].length || map[shootX][shootY] =='#' ) {
				break;
			}
			else if(map[shootX][shootY] == '*') {
				map[shootX][shootY] = '.';
				break;
			}
		}

	}
	
	private static int direction(char c) {
		switch (c) {
		case '^':
			return 0;
		case 'v':
			return 1;
		case '<':
			return 2;
		case '>':
			return 3;
		}
		return 0;
	}

}
