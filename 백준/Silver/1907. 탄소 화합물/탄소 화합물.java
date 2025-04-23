import java.util.*;
import java.io.*;
public class Main {
    static String[] formula;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        formula = new String[3];
        formula = str.split("[+=]");
        for(int x1=1;x1<=10;x1++){
            for(int x2=1;x2<=10;x2++){
                for(int x3=1;x3<=10;x3++){
                    if(isComfortable(x1,x2,x3)){
                        System.out.println(x1+" "+x2+" "+x3);
                        System.exit(0);
                    }
                }
            }
        }
    }
    public static boolean isComfortable(int x1, int x2, int x3){
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        left.put('C',0);
        left.put('H',0);
        left.put('O',0);

        right.put('C',0);
        right.put('H',0);
        right.put('O',0);

        left = count(x1, 0, left);
        left = count(x2, 1, left);
        right = count(x3, 2, right);

        if(left.get('C').equals(right.get('C')) && left.get('H').equals(right.get('H')) && left.get('O').equals(right.get('O')) ){
            return true;
        }
        return false;
    }
    public static HashMap<Character, Integer> count (int x, int idx, HashMap<Character, Integer> cho){
        String f = formula[idx];
        int i=0;
        while(i < f.length()){
            char key = f.charAt(i); i++;
            int num = 1;
            if(i < f.length() && f.charAt(i)-'0' >= 1 &&  f.charAt(i)-'0' <= 10){  // 숫자
                num = f.charAt(i)-'0';
                i++;
            }
            cho.put(key, cho.getOrDefault(key, 0)+(num*x));
        }
        return cho;
    }
}