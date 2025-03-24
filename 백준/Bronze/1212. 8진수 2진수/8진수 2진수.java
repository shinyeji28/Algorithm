import java.util.*;

public class Main{

    public static void main(String[] args)
    {
        String[] toBinary = new String[]{"000","001","010","011","100","101","110","111"};
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        // 8 -> 2 진수
        for(int i=0;i<n.length();i++){

            sb.append(toBinary[n.charAt(i) -'0']);
        }
        String ssb = sb.toString();
        ssb = ssb.replaceAll("^0+", "");
        if(ssb.equals(""))ssb ="0";
        System.out.println(ssb);
    }
}