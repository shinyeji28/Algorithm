package beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * N*N
 * M : 가로로 연속된 꿀을 채취할 수 있는 벌통의 수
 * 2명이 서로 겹치지 않는 M개의 벌통을 선택
 * 최대 C : 각각 채취할 수 있은 꿀 양
 * 수익 : 꿀통의 제곱의 합
 * 목표>
 * 많은 꿀을 채취해 최대한 많은 수익
 * 
 * 구현>
 * 1. M만큼의 집합의 최대 값구하기 - 부분집합의 최대 이익 (sum <= C인것만)
 * 2. 열: 0~N-M-1까지에서 2개 고르기 (조합, 다음 고르기는 cur + M)
 * 	  (일차원 배열의 원소 0 ~ N*N-1) 
 */


public class Solution_2115_벌꿀채취_신예지 {
	static StringBuilder sb = new StringBuilder();
	static int N,M,C;
	static int[][] map;
	static int maxRevenue;
	static int[][] maxHoneySet;
	static int setSize;
	static int[][] pickStartIdx;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
						
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxRevenue = 0;
			setSize = N-M+1;
			maxHoneySet = new int[N][setSize];
			pickStartIdx = new int[2][2];

			for (int i = 0; i < N; i++) {
				st= new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < setSize; j++) {
					harvestHoney(i,j,0,0,0);
				}
			}

			combination(0, 0);
			sb.append("#"+t+" "+maxRevenue).append('\n');
		}
		System.out.println(sb);
	}
	
	private static void combination(int start, int depth) {
		if(depth == 2) {
			int sum = maxHoneySet[pickStartIdx[0][0]][pickStartIdx[0][1]] + maxHoneySet[pickStartIdx[1][0]][pickStartIdx[1][1]]; 
			maxRevenue = Math.max(maxRevenue, sum);
			return;
		}
		for (int i = start; i <N*N; i++) {
			
			int x = i/N;
			int y = i%N;
			if(N-M < y) continue;
			
			pickStartIdx[depth][0] = x;
			pickStartIdx[depth][1] = y;
			combination(i+M, depth+1);

		}
		
	}

	private static void harvestHoney(int x,int y, int depth, int sum, int localRevenue) {
		if(sum>C) return;
		if(depth == M) {
			if(sum<=C) {
				maxHoneySet[x][y] = Math.max(maxHoneySet[x][y], localRevenue);
			}
			return;
		}
		
		int curhoney = map[x][y+depth];
		harvestHoney(x, y, depth+1, sum+curhoney, localRevenue + curhoney*curhoney );
		
		harvestHoney(x, y, depth+1, sum, localRevenue);
		
	}

}

