import java.util.*;
import java.io.*;
public class Main
{
    static int cnt1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fib(n);
        System.out.println(cnt1+" "+fibonacci(n));
    }
    public static int fib(int n){
        if(n==1 || n==2){
            cnt1++;
            return 1;
        }
        return (fib(n-1)+fib(n-2)); 
    }
    public static int fibonacci(int n){
        int cnt2 = 0;
        int[] f = new int[n+1];
        f[1] = f[2] = 1;
        for(int i=3; i<=n;i++){
            f[i] = f[i-1] + f[i-2];
            cnt2++;
        }
        return cnt2;
    }
}