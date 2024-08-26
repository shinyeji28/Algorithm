import java.util.*;

    public class Main {
        public static void main(String[] agrs){
            Scanner sc = new Scanner(System.in);
            int target = sc.nextInt();
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] dp = new boolean[target+1];
            q.offer(target);
            dp[target] = true;
            while(!q.isEmpty()){
                int num = q.poll();
                boolean state = !dp[num];
                if(num - 3 > 0) {
                    if(dp[num-3] == false) {
                        dp[num - 3] = state;
                        q.offer(num - 3);
                    }
                }
                if(num - 1 > 0) {
                    if(dp[num-1] == false) {
                        dp[num - 1] = state;
                        q.offer(num - 1);
                    }
                }
            }
            int idx = 0;
            boolean turn = true; // false : SK , true : CY
            while(idx <target){
                turn = !turn;
                if(idx + 3 <=target && dp[idx + 3]){
                    idx+=3;
                }else{
                    idx++;
                }
            }
            System.out.println(turn? "CY" : "SK");
        }

    }