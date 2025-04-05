import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        for(int i=1;i<phone_book.length;i++){
            for(int k=0;k<phone_book[i-1].length();k++){
                if(phone_book[i].startsWith(phone_book[i-1])){
                    return false;
                }
            }
        }
        return true;
    }
}