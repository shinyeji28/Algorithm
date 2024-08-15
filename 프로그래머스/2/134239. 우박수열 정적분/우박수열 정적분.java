import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        // 1. 우박수열 구하기
        List<Integer> ks = new ArrayList<>();
        while(k>1){
            ks.add(k);
            if(k%2==0) k /= 2;
            else k = k*3 +1;
        }
        ks.add(1);
        
        // 2. 꺾이는 지점을 경계로 넓이 구하기
        // 누적합 구하기

        double[] sum = new double[ks.size()];
        for(int i=1;i<ks.size();i++){
            double area = (ks.get(i-1) + ks.get(i)) / 2.0;
            sum[i] = sum[i-1] + area;
        }
        System.out.println(Arrays.toString(sum));
        
        
        // 3. 범위의 적분 구하기
        int idx = 0;
        for(int[] range : ranges){
            int x = range[0];
            int y = ks.size() + range[1];
            if(y > ks.size() || x >= y) {
                answer[idx++] = -1;
                continue;
            }
            answer[idx++] = sum[y-1] - sum[x];
        }
        
        return answer;
    }
}