import java.util.*;
public class Main{
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;  // 자신 포함
        // 투 포인터 연속된 합의 개수
        int left = 1;
        int right = 1;
        int sum = right;
        for(int i=1;i<=n;i++){
            while(sum > n) {
                sum -= left;
                left++;
            }
            if(sum == n) cnt++;
            right++;
            sum += right;
        }
        System.out.println(cnt);
    }
}