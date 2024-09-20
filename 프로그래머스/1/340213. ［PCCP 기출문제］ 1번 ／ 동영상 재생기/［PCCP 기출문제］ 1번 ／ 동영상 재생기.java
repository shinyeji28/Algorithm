/*
    prev : -10 or 0
    next : +10 or 마지막
    op_start ≤ 현재 재생 위치 ≤ op_end : 오프닝 끝나는 위치
*/

import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int pm = (pos.charAt(0)-'0') *10 + (pos.charAt(1)-'0');
        int ps = (pos.charAt(3)-'0') *10 + (pos.charAt(4)-'0');
        
        
        int vm = (video_len.charAt(0)-'0') *10 + (video_len.charAt(1)-'0');
        int vs = (video_len.charAt(3)-'0') *10 + (video_len.charAt(4)-'0');
        
        int sm = (op_start.charAt(0)-'0') *10 + (op_start.charAt(1)-'0');
        int ss = (op_start.charAt(3)-'0') *10 + (op_start.charAt(4)-'0');
        
        int om = (op_end.charAt(0)-'0') *10 + (op_end.charAt(1)-'0');
        int os = (op_end.charAt(3)-'0') *10 + (op_end.charAt(4)-'0');
        
        for(String command : commands){
        
            // op_start ≤ 현재 재생 위치 ≤ op_end : 오프닝 끝나는 위치
            if(sm * 100 + ss <= pm * 100 + ps && pm * 100 + ps <= om *100 + os){
                pm = om;
                ps = os;
            }
            
            if(command.equals("next")){
                pm += (ps + 10) / 60;
                ps = (ps + 10) % 60; 
            }else{
                if(ps - 10 < 0){
                    pm--;
                    ps = 60 + ps - 10;
                }else{
                    ps -=10;
                }
            }
            
            if(pm < 0){
                pm = 0;
                ps = 0;
            }else if(pm > vm || (pm == vm &&  ps > vs)){
                pm = vm;
                ps = vs;
            }            
        }
        
        if(sm * 100 + ss <= pm * 100 + ps && pm * 100 + ps <= om *100 + os){
                pm = om;
                ps = os;
        }
        
        if(pm < 10){
            answer = "0"+pm+":";
        }else{
            answer = pm+":";
        }
        if(ps < 10){
            answer +="0"+ps;
        }else{
            answer += ps;
        }
        return answer;
    }
}