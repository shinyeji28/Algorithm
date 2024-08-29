import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] ab = st.nextToken().toCharArray();
        int aCnt = 0;
        for(int i=0;i<ab.length;i++){
            if(ab[i]=='a')aCnt++;
        }

        int swapCnt = 0;
        for(int i=0;i<aCnt;i++){
            if(ab[i]=='b')swapCnt++;
        }
        int result = swapCnt;

        int l=0, r=aCnt-1;
        for(int i=1;i<ab.length;i++){
            if(ab[l]=='b')swapCnt--;
            l++;
            r = (r+1) % ab.length;
            if(ab[r]=='b')swapCnt++;
            result = Math.min(swapCnt, result);
        }
        System.out.println(result);
    }

}