/* 선공 O, 후공 X
    실수
        9개를 모두 채웠을 때 선 != 후 +1일 경우
        9개를 못채웠는 데 !(짝수 && 선 == 후 || 홀수 && 선 ==  후+1)일 경우
        서로 연속된 3개가 있을 때  
*/
import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        int first= 0;
        int second = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='O')first++;
                else if(board[i].charAt(j)=='X')second++;
            }
        }
        if(first < second)return 0;
        int total = first+second;
        if(total == 9 && first !=second + 1)return 0;
        if(total != 9){
            if((total%2==0 && first==second) ||(total%2==1 && first == second+1)){}
            else return 0;
            
        }
        
        boolean o = false;
        boolean x = false;
   
        for(int i=0;i<3;i++){
            
            if(board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)){
                if(board[i].charAt(0)=='O')o=true;
                if(board[i].charAt(0)=='X')x=true;
            }
            if(board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i)==board[2].charAt(i)){
                if(board[0].charAt(i)=='O')o=true;
                if(board[0].charAt(i)=='X')x=true;
            }
        }
        
        
        if(board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)){
            if(board[0].charAt(0)=='O')o=true;
            if(board[0].charAt(0)=='X')x=true;
        }
        if(board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2].charAt(0)){
            if(board[0].charAt(2)=='O')o=true;
            if(board[0].charAt(2)=='X')x=true;
        }
        if(o && x) return 0;
        if(o && first!=second+1) return 0;
        if(x && first!=second) return 0;

        return 1;
    }
}