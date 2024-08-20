
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int typeNum = 0;
        
        int[] kindOf = new int[10001];
        int[] A = new int[10001];
        
        for(int t: topping) {
            if(kindOf[t] == 0)typeNum++;
            kindOf[t]++;
        }
        
        int cntA = 0;
        int cntB = typeNum;
        
        for(int t:topping){
            if(A[t] == 0)cntA++;
            A[t]++;
            
            if(kindOf[t] - A[t] == 0) cntB--;
            
            // System.out.println(A[t] +" "+(kindOf[t] - A[t])+" "+cntA+" "+cntB);
            
            if(cntA == cntB) {
                // System.out.println("answer "+ cntA+" "+cntB);

                answer++;
            }
        }
    
        return answer;
    }
}