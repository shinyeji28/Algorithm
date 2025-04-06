
    import java.io.*;
    import java.util.*;

    /*
    * 최대공약수 G, 최소공배수 L 일 때, 두 수 A,B찾기
    * A = G * a, B = G * b 이니까 a와 b는 서로소 (최대공약수 = 1)
    * 최소공배수 L = G * a * b 이므로 L/G = a*b,
    * 즉, L/G의 약수의 짝 중 서로소(최대공약수 1) 인 것을 찾아 A,B구하기
    *
    * */
    public class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int G = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int min = 2000000000;
            int[] answer = new int[2];
            // 약수 구하기
            int k = L/G;
            for(int i=1;i<=Math.sqrt(k);i++){
                if(k % i == 0){
                    if(gcd(i, k/i)==1){

                        int a = i*G;
                        int b = (k / i)*G;
                        // 최소 값 구하기
                        if(min > a+b){
                            min = a+b;
                            answer[0] = a;
                            answer[1] = b;
                        }
                    }
                }
            }

            System.out.println(answer[0] +" "+ answer[1]);

        }
        //최대공약수
        public static int gcd(int a, int b){
            if(a%b==0){
                return b;
            }
            return gcd(b, a%b);
        }

    }