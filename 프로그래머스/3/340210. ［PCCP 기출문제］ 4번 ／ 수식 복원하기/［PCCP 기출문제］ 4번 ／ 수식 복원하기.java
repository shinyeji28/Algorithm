
import java.util.*;
class Solution {
    static boolean[] ableRadix = new boolean[10];

    public String[] solution(String[] expressions) {
        List<String> answer = new ArrayList<>();
        
        Arrays.fill(ableRadix, true);
        for(int radix = 9;radix>=2;radix--){
            if(!ableRadix[radix]) continue;
            for(String exp : expressions){
                if(!isValidExpression(exp, radix)){
                    ableRadix[radix] = false;
                }
            }
        }
        
        
        // X값 찾기
        for(String exp : expressions){
            if(exp.contains("X")){
                answer.add(findXValue(exp));
            }
        }
        
        return answer.toArray(new String[0]);
    }
    public static String findXValue(String exp){
        
        String value1 = "";
        String[] parts = exp.split(" ");
        for(int r = 2;r<=9;r++){
            if(!ableRadix[r])continue;

            int a = Integer.parseInt(parts[0], r);  
            int b = Integer.parseInt(parts[2], r);

            int value = 0;
            switch(parts[1]){
                case "+" :
                    value = a + b;
                    break;
                case "-" :
                    value = a - b;
                    break;
            }
            if(value1.equals("")){
                value1 = Integer.toString(value,r);
            }
            if(!Integer.toString(value,r).equals(value1)){
                return parts[0]+" "+parts[1]+" "+parts[2]+" = ?";
            }
        }
        
      
        return parts[0]+" "+parts[1]+" "+parts[2]+" = "+value1;
        
        
    }
    public static boolean isValidExpression(String exp, int radix){
        String[] parts = exp.split(" ");
        if(!isValidExpressionForRadix(parts[0], radix)||!isValidExpressionForRadix(parts[2], radix) ) return false;
        int a = Integer.parseInt(parts[0], radix);  // parts[0]이 radix진법에서 10진법으로 변환
        int b = Integer.parseInt(parts[2], radix); 
        if(parts[4].equals("X")){
            return true;
        }
        if(!isValidExpressionForRadix(parts[4],radix))return false;
        int c = Integer.parseInt(parts[4], radix); 
        
        int value = 0;
        switch(parts[1]){
            case "+" :
                value = a + b;
                break;
            case "-" :
                value = a - b;
                break;
        }
        return value == c;
        
    }
    public static boolean isValidExpressionForRadix(String exp, int radix){
        for(char c : exp.toCharArray()){
            if(Character.digit(c, radix) == -1){
                return false;
            }
        }
        return true;
    }

}