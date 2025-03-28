import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int[][] maxDp = new int[arr.length/2+1][arr.length/2+1];
        int[][] minDp = new int[arr.length/2+1][arr.length/2+1];
        for(int i=0;i<maxDp.length;i++){
            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }
        //초기화
        for(int i=0;i<maxDp.length;i++){
            maxDp[i][i] = Integer.parseInt(arr[i*2]);
            minDp[i][i] = Integer.parseInt(arr[i*2]);
        }
        
        // idx i~j까지 갈호를 씌웠을 때 그 구간의 최대 최소 저장
        // + 기호 : max(0~k) + max(k+1~n)
        // - 기호 : max(0~k) - min(k+1~n)
        for(int cnt=1;cnt<maxDp.length;cnt++){
            for(int i=0;i<maxDp.length-cnt;i++){
                int j = cnt + i;
                for(int k=i;k<j;k++){
                    
                    if(arr[k*2+1].equals("+")){
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k+1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k+1][j]);
                    }else{
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] - minDp[k+1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k+1][j]);
                    }
                }
            }
        }

        
        
        return maxDp[0][arr.length/2];
    }
}