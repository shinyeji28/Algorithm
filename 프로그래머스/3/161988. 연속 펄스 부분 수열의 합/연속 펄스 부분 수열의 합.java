// 카데인 알고리즘 사용
// 최대 부분수열 합 구하기

class Solution {
    public long solution(int[] sequence) {
        int[] pulse1 = new int[sequence.length];
        int[] pulse2 = new int[sequence.length];
        
        for(int i=0;i<sequence.length;i++){
            if(i%2==0){
                pulse1[i] = sequence[i]*(-1);
                pulse2[i] = sequence[i];
            }else{
                pulse1[i] = sequence[i];
                pulse2[i] = sequence[i]*(-1);
            }
        }
        
        long max1 = pulse1[0];
        long max2 = pulse2[0];
        long curSum1 = pulse1[0];
        long curSum2 = pulse2[0];
        for(int i=1;i<pulse1.length;i++){
            curSum1 = Math.max(pulse1[i], curSum1 + pulse1[i]);
            curSum2 = Math.max(pulse2[i], curSum2 + pulse2[i]);
            max1 = Math.max(max1, curSum1);
            max2 = Math.max(max2, curSum2);
        }
        
        return Math.max(max1,max2);
    }
}