import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (a,b)->{
            if(a[col-1] - b[col-1]==0){
                return b[0] - a[0];
            }
            return a[col-1] - b[col-1];
        });

        List<Integer> list = new ArrayList<>();

        for(int i=row_begin-1;i<=row_end-1;i++){
            int sum = 0;
            for(int j=0;j<data[i].length;j++){
                sum += data[i][j] % (i+1);
            }
            list.add(sum);
        }
        
        for(int i=0;i<list.size();i++){
            if(i==0)answer = list.get(i);
            else answer ^= list.get(i);
        }
        return answer;
    }
}