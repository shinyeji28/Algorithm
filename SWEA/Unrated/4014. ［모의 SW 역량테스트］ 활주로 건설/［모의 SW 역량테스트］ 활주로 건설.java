/**
 * 입력>
 * 경사로 길이 : X
 * 
 * 출력>
 * 활주로를 건설할 수 있는 경우의 수를 계산
 * 
 * 조건>
 * 높이가 1차이나고
 * 작은 부분의 지형이 X이상일 때 
 * 
 *
 *
 */
import java.util.*;
import java.io.*;
public class Solution {

    static int[][]rowMap;
    static int[][]colMap;
    static boolean[] visited;
    static int N,X;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            rowMap = new int[N][N];
            colMap = new int[N][N];
            result = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());    
                for (int j = 0; j < N; j++) {
                    rowMap[i][j] = colMap[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int i = 0; i < N; i++) {
				if(check(rowMap[i]))result++;
				if(check(colMap[i]))result++;
			}
            System.out.println("#"+(t+1)+" "+result);
            
        }
        
    }
    private static boolean check(int map[]) {
    	visited = new boolean[N];
    	for (int i = 0; i < N-1; i++) {
			int cur = map[i];
    		int next = map[i+1];
    		int diff = cur - next;
    		
    		if(diff == 0) {  // 같다
    			continue;
    		}else if(diff==-1) {  // 왼쪽이 1 더 작다
    			// 활주로 설치할 수 있는지 확인 (i포함 이전을 확인)
    			for (int j = i; j >= i-(X-1); j--) {
					if(j<0)return false;
					if(visited[j])return false;
					if(map[i]!=map[j])return false;
					visited[j]=true;
				}
    		}else if(diff==1) {  // 오른쪽이 1더 작다
    			// 활주로 설치할 수 있는지 확인 (i포함 이후를 확인)
    			for (int j = i+1; j <= (i+1)+(X-1); j++) {
					if(j>=N)return false;
					if(visited[j])return false;
					if(map[i+1]!=map[j])return false;
					visited[j]=true;
				}
    		}else {
    			return false;
    		}
    		
		}
    	return true;
    }
}