/**
 * 유클리드 호제법
 * 
 */
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int a1 = a;
		int b1 = b;
		
		// 최대 공약수
		while(Math.min(a1, b1)!=0){
			if(a1<b1) {
				b1 = b1 % a1;
			}else {
				a1 = a1 % b1;
			}
		}
		int GCD = Math.max(a1, b1);
		System.out.println(GCD);
		
		// 최대 공배수
		int LCM = a*b / GCD;
		System.out.println(LCM);
	}
}