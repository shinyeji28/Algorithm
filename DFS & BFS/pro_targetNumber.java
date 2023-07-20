class Solution {
    static int cnt=0;
    public void dfs(int target, int sum,int[] numbers,int idx){
        if(idx == numbers.length){
           if(target == sum ) cnt++;
            return;
        }
        dfs(target,sum-numbers[idx],numbers,idx+1);
        dfs(target,sum+numbers[idx],numbers,idx+1);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(target,0,numbers,0);
        return cnt;
    }
}