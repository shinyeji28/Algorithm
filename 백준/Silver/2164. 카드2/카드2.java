import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            q.offer(i);
        }
        int last = 0;
        boolean turn = false;
        while(!q.isEmpty()){
            last = q.poll();
            if(turn){
                q.offer(last);
            }
            turn = !turn;
        }
        System.out.println(last);

    }

}