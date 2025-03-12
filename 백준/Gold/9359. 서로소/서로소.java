import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] agrs) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            // N의 소인수 찾기
            List<Integer> primes = getPrime(N);

            // 전체에서 서로소가 아닌 수 빼기
            // 서로소가 아닌 수 구하기 -> 포함 배제의 원리 ( 소인수가 3개 일 때, a집합 + b집합 + c집합 - ab교집합 - ac교집합 - bc교집합 + abc교집합)
            // 소인수가 n개일 때 -> 홀수 개의 소수를 곱한 배수는 더하고, 짝수 개의 소수를 곱한 배수는 뺀다.
            // 소인수 조합 -> 비트마스킹 사용
            long cnt = countPrime(B, primes) - countPrime(A-1,primes);


            sb.append("Case #"+t+": "+ cnt).append('\n');
        }
        System.out.println(sb);

    }

    // 소인수 조합 구하기 -> 비트의 각 자리가 소인수의 idx
    public static long countPrime(long X, List<Integer> primes){
        long cnt = 0;  // 소인수로 나눠 떨어지는 개수
        int primeSize = primes.size();

        for(int mask=1;mask<(1<<primeSize);mask++){ // 모든 조합
            long mul = 1;
            for(int j=0;j<primeSize;j++){          // 어떤 자리가 true비트인지 찾아 곱하기
                if((mask & (1<<j))!=0){
                    mul = mul * primes.get(j);
                }
            }
            if(mul == 0 )continue;
            int trueBitCount = Integer.bitCount(mask);  // 소인수 조합 개수
            if(trueBitCount % 2 == 1) cnt += X/mul;       // 홀수 개의 소수를 곱한 배수는 더하고
            else cnt -= X/mul;                          // 짝수 개의 소수를 곱한 배수는 뺀다
        }

        return X - cnt;
    }
    public static List<Integer> getPrime(int n){
        List<Integer> primes = new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if(n%i==0) primes.add(i);
            while(n%i==0) n = n/i;
        }
        if(n>1)primes.add(n);
        return primes;
    }
}