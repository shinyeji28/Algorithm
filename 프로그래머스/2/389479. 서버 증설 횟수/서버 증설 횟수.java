class Solution {

    public int solution(int[] players, int m, int k) {
        int[] endCnt = new int[players.length];
        
        int total = 0;
        int curCnt = 0;
        for(int i=0;i<players.length;i++){
            curCnt -= endCnt[i];
            int pCnt = players[i];
            if(pCnt!=0){
                int n = pCnt/m;
                if(n > curCnt){
                    int additaion = n - curCnt;
                    total += additaion;
                    curCnt += additaion;
                    if(i+k < players.length)endCnt[i+k] += additaion;
                }
            }            
        }
        return total;
    }
}