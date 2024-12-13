/*
* 구간 합 구하기 + 수정
* O(N*Q) = 100,000 * 100,000 = 시간초과
*
* 수정이 있는 구간 합을 가장 빠르게 구하는 법 = 세그먼트 트리 (logN)
* O(Q*log(N))
*
* 1. 구간 합 트리 : 세그먼트 트리 구성 (범위를 분할하여 올라갈 수 록 구간의 합으로 구성)
* 2. 조회 : 범위에 해당하는 값 찾기
* 3. 수정 : 리프노트부터 root까지 parent 수정하기
*
* */

import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static long[] segmentTree;
    static long[] arr;
    static long sum;
    static int[] segIndex;

    public static void main(String[] agrs)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N+1];
        int Q = Integer.parseInt(st.nextToken());
        // N보다 큰 가장 가까운 N의 제곱수 * 2 ; 그냥 4배 곱해버리기
        segmentTree = new long[(N+1)*4];
        segIndex = new int[(N+1) *4];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 구간 합 트리 만들기
        // tree 인덱스는 1부터
        setSegmentTree(1, 1, N);
        for(int q=0;q<Q;q++){  // 턴
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 조회
            sum = 0;
            search(1, 1, N, Math.min(x, y), Math.max(x,y));
            sb.append(sum).append('\n');
            // 수정
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            patch(a,b);

        }
        System.out.println(sb);
    }
    // from을 to로 수정하고 parents도 모두 고치기
    public static void patch(int from, int to){
        long diff = to - arr[from];

        arr[from] = to;
        int idx = segIndex[from];
        segmentTree[idx] = to;
        while(idx > 0){
            idx = idx / 2;
            segmentTree[idx] += diff;
        }
    }
    public static void search(int idx, int start, int end, int rangeStart, int rangeEnd){
        if (rangeStart > end || rangeEnd < start) return; // 범위 밖이면 종료
        // 노드가 범위 안에 있으면
        if(rangeStart <=start && end <= rangeEnd){
            sum += segmentTree[idx];
            return;
        }

        int mid = (start + end) / 2;
        // 범위가 mid보다 작거나 같으면
        search(idx * 2, start, mid, rangeStart, rangeEnd);     // 왼쪽 자식 노드
        // 범위가 mid보다 크면
        search(idx * 2 + 1, mid+1, end, rangeStart, rangeEnd); // 오른쪽 자식 노드

    }
    public static void setSegmentTree(int idx ,int start, int end){
        // 범위가 1이면 tree에 값을 저장하고 return
        if(start == end){
            segmentTree[idx] = arr[start];
            segIndex[start] = idx;    // 수정을 위한 segment tree 인덱스 저장
            return;
        }
        int mid = (start + end) / 2;
        setSegmentTree(idx * 2, start, mid);     // 왼쪽 자식 노드
        setSegmentTree(idx * 2 + 1, mid+1, end); // 오른쪽 자식 노드
        // parent 구간합 구하기
        segmentTree[idx] = segmentTree[idx * 2] + segmentTree[idx * 2 + 1];
    }
}