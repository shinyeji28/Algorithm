class Solution {
    public long solution(int k, int d) {
        long answer = d/k+1;
        
        int x = d;
        for(int y=0;y<=d;y+=k){
            while(x!=0){

                if(Math.pow(x,2) + Math.pow(y,2) <= Math.pow(d,2)) {
                    answer += x/k;
                    break;
                }else{
                    x--;
                }

            }
        }
        return answer;
    }
}