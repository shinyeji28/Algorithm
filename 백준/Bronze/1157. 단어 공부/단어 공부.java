import java.util.*;

public class Main {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();

        int[] alph = new int[26+1];
        for(int i=0;i<str.length();i++){
            int idx = (int)str.charAt(i)-(int)'A';
            alph[idx]++;
        }

        int maxValue = 0;
        int result = 0;
        boolean duple = false;
        for(int i=0;i<alph.length;i++){
            if(maxValue <alph[i]){
                maxValue = alph[i];
                result = i;
                duple = false;
            }else if(maxValue == alph[i]){
                duple = true;
            }
        }
        if(duple)System.out.println("?");
        else System.out.println((char)(result + 'A'));
    }
}