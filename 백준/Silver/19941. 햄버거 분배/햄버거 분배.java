import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        Queue<Integer> person = new ArrayDeque<>();
        List<Integer> ham = new ArrayList<>();
        for(int i=0;i<n;i++){
            char c = str.charAt(i);
            if(c=='H'){
                ham.add(i);
            }else{
                person.offer(i);
            }
        }
        int cnt = 0;
        for(Integer hIdx: ham){
            if(person.isEmpty())break;
            while(hIdx - k > person.peek()){
                person.poll();
            }

            if(hIdx - k <= person.peek() && hIdx + k >= person.peek()){
                person.poll();
                cnt++;
            }

        }
        System.out.println(cnt);
    }

}