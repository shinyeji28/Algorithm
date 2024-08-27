import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char type = st.nextToken().charAt(0);

        int needCnt = 0;
        HashSet<String> name = new HashSet<>();
        int cnt = 0;
        int result = 0;

        switch(type){
            case 'Y' : needCnt = 1; break;
            case 'F' : needCnt = 2; break;
            case 'O' : needCnt = 3; break;
        }

        for(int i=0;i<n;i++){
            String input = br.readLine();
            if(name.contains(input) == false){
                cnt++;
                name.add(input);

            }
            if(cnt==needCnt){
                result++;
                cnt=0;
            }
        }

        System.out.println(result);

    }

}