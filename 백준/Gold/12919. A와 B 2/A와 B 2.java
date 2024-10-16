import java.util.*;
import java.io.*;

public class Main {
    static String s1;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String str2 = st.nextToken();

        System.out.println(findFromStr2ToStr1(str2,false)?1 : 0);  // 뒤집기 true
    }

    public static boolean findFromStr2ToStr1(String s2, boolean o2){
        // s1이 s2보다 크거나 같으면 종료

        // 서로 같은 지 확인
        if(s1.length() == s2.length()){
            if(o2){
                for(int i=s1.length()-1,j=0;i>=0;i--,j++){
                    if(s2.charAt(i) != s1.charAt(j))return false;
                }
            }else if(!s1.equals(s2)) return false;
            return true;
        }
        else if (s1.length() > s2.length())return false;

        //A 빼기
        if(o2){
            if(s2.charAt(0)=='A'){
                if(findFromStr2ToStr1(s2.substring(1), o2))return true;
            }
            if(s2.charAt(s2.length()-1)=='B'){
                if(findFromStr2ToStr1(s2.substring(0,s2.length()-1), !o2))return true;
            }
        }else{
            if(s2.charAt(s2.length()-1)=='A'){
                if(findFromStr2ToStr1(s2.substring(0,s2.length()-1), o2))return true;
            }
            if(s2.charAt(0)=='B'){
                if(findFromStr2ToStr1(s2.substring(1), !o2))return true;
            }
        }

        return false;
    }
}