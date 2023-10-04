/**
 * 다리를 이어주기 위해 DFS를 사용
 * 
 * 1. 섬마다 다른 숫자를 사용하여 다른 영역이란 것을 표시 하기 - 라벨링
 * 2. 그래프 만들기 (간선 리스트)
 *         - 각 노드에서 다른 노드까지의 간선 구하기 
 *         		- 단, 다리가 1일 때는 무시하기
 *  			- 한 섬에서 다른 섬에 도작할 수 없을 때 바로 -1을 출력
 *         - 모든 정점을 연결하는 간선의 가중치 합이 최소가되는 트리 만들기 (mst - 크루스칼 알고리즘)
 * 
 */

import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[] {0,0,-1,1};
    static int[] dy = new int[] {-1,1,0,0};
    static List<Edge> edgeList = new ArrayList<Edge>();
    static int V;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 섬 구분하기
        int islandNo = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    separateIsland(i,j, islandNo++);
                }
            }
        }
        V = islandNo - 2;  // 정점 개수

        // 각 노드에서 다른 노드까지의 최단 거리 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	if(map[i][j]!=0) {
                    findDistance(i,j);
            	}
            }
        }
        // 모든 정점을 이을 수 없는 경우
        if(edgeList.isEmpty()) {
        	System.out.println("-1");
        	return;
        }
        
        // MST - 크루스칼 알고리즘 (모든 정점을 연결하는 간선의 합이 최소인 그래프 만들기)
        
        // 1. 가중치 오름차순으로 정렬
        Collections.sort(edgeList);
        // 2. make-set
        make();
        // 3. union
        int cnt = 0; // 연결한 정점 수
        int mstWeight = 0;  // mst 최소 가중치 합
        for (Edge edge : edgeList) {
			if(union(edge.from-2, edge.to-2)) {
				mstWeight += edge.weight;
				cnt++;
				if(cnt == V-1) {
			        System.out.println(mstWeight);
					return;
				}
			}
		}
        System.out.println("-1");
    }

    private static void make() {
    	parents = new int[V];
    	for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

    
	private static boolean union(int a, int b) {
    	int aRoot = find(a); 
    	int bRoot = find(b);
    	if(aRoot == bRoot) {
        	return false;
    	}
    	parents[aRoot] = bRoot;
    	return true;
	}

	private static int find(int a) { // 대표자 찾기
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static void findDistance(int r,int c) {
    	for (int d = 0; d < dx.length; d++) {
    		int nx = r, ny = c;
    		int distance = 0;
    		while(true) {
				nx += dx[d];
				ny += dy[d];
				distance++;
				if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length || map[nx][ny]==map[r][c])break;
				if(map[nx][ny]!=0) {  // 다른 섬에 도착
					distance--;  // bridge 수만 저장하기 위해 -1을 한다.
					if(distance >= 2) {
						edgeList.add(new Edge(map[r][c],map[nx][ny],distance));    //간선 저장
					}
					break;
				}
			}
		}        
    }



    private static void separateIsland(int c, int r, int islandNo) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {c,r});
        visited[c][r] = true;

        int[] cur;
        int nx = 0, ny = 0;
        while(!q.isEmpty()) {
            cur = q.poll();
            map[cur[0]][cur[1]] = islandNo;
            for (int d = 0; d < dx.length; d++) {
                nx = cur[0] + dx[d];
                ny = cur[1] + dy[d];
                if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length || map[nx][ny]==0 || visited[nx][ny]==true)continue;
                q.offer(new int[] {nx,ny});
                visited[nx][ny] = true;
            }
        }
        
    }
    
    public static class Edge implements Comparable<Edge>{
    	int to;
    	int from;
    	int weight;
		public Edge(int to, int from, int weight) {
			this.to = to;
			this.from = from;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		@Override
		public String toString() {
			return "Edge [to=" + to + ", from=" + from + ", weight=" + weight + "]";
		}
		
    	
    }
}