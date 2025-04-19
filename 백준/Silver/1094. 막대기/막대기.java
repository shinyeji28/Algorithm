
    import java.io.*;
    import java.util.*;
    public class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int num = 64;
            int cnt = 0;
            int sum = 0;
            if(n == num) cnt = 1;
            else {
                while (num != 1) {
                    if (sum == n) break;
                    num = num / 2;

                    if (sum + num <= n) {
                        sum += num;
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }