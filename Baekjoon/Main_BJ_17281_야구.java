package beakJoon;

/**
 * 매 이닝마다 주자 초기화
안타: 1
2루타: 2
3루타: 3
홈런: 4   - 모든 주자 홈에 들어옴 , 점수 +1
아웃: 0   - 아웃 +1
 * 
 * 한 이닝에서 3아웃 - 다음 이닝으로 이동 + 다음타자가 진행
 * 이닝 끝까지 3아웃이 없으면 1번타자부터 계속 진행
 * 홈에 들어오면 +1점
 * 
 * 입력>
 * 이닝 횟수
 * 각 선수가 이닝에서 얻는 결과
 * 
 * 출력>
 * 얻는 최대 점수
 * 
 * 1. 타자 순 - 순열 (1번선수가 4번타자로 고정) 
 * 2. 순열 별로 획득하는 점수 저장
 * 3. 최대 점수 출력
 */
import java.util.*;
import java.io.*;
public class Main_BJ_17281_야구_신예지2 {
    static int[][] results;
    static boolean[] isSelected = new boolean[10];
    static int[] pick = new int[9];
    static int N, maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        N = Integer.parseInt(br.readLine()); //이닝 N번
        
        results = new int[N][9];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                results[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        permutation(0);
      	System.out.println(maxScore);

        
    }
    
    private static void permutation(int depth) {  // depth는 타순
    	if(depth == 9) {
    		game();   // 선수 배치 완료하면 N번 이닝 시작
    		return;
    	}
    	if(depth  == 3 ) {      //4번 타자는 1번 선수
    		pick[depth] = 1; 
        	permutation(depth+1);
    	}else {
            for (int i = 2; i <= 9; i++) {  // 선수번호
    			if(!isSelected[i]) {
    	        	isSelected[i] = true;
    	        	
    	        	pick[depth] = i;
    	        	permutation(depth+1);
    	        	
    	        	isSelected[i] = false;
    			}
    		}
    	}
    }

	private static void game() {
		
		int cPlayerIdx = 0;   // 현재 선수의 idx 선수 결과 -> results[cPlayerIdx] 
		int basePos = 0;  // 비트 마스킹,  홈, 3루, 2루, 1루, 타석(사용하는 비트 00011110)
		int score = 0;
		int inning = 0;
		int outCnt = 0;
			// 1번 타자부터 9번 타자까지 진행
			// 각 타자의 결과대로 점수 저장
		while(inning<N) {
			switch (results[inning][pick[cPlayerIdx]-1]) {
			case 1:
				basePos |= 1;
				basePos = basePos<<1;
				break;
			case 2:
				basePos |= 1;
				basePos = basePos<<2;
				break;
			case 3:
				basePos |= 1;
				basePos = basePos<<3;
				break;
			case 4:
				basePos |= 1;
				basePos = basePos<<4;
				break;
			case 0:
				outCnt++;
				cPlayerIdx = (cPlayerIdx+1)%9;
				if(outCnt == 3) { //outCnt == 3 이닝 종료 - break, 다음 주자 전달
					inning++;
					outCnt = 0;
					basePos = 0;
				}
				continue;
			}

			// 11110000 의 비트를 확인하면 획득한 점수를 알 수 있음
			for (int i = 4; i <= 7; i++) {
				if((basePos & 1<<i) != 0) score++;
			}
			basePos &= 15;          // 0으로 초기화

			cPlayerIdx = (cPlayerIdx+1)%9;
		}
			
		
		maxScore = Math.max(maxScore, score);
	}

}
