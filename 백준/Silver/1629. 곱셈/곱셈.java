import java.util.*;
import java.io.*;
public class Main {

    static int target, c;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(solution(b));
    }
    public static long solution(int remain){
        if(remain == 0)return 1;

        long half = solution(remain / 2);
        long result = half * half % c;
        if(remain%2!=0) result = result * target % c;

        return result;
    }
}