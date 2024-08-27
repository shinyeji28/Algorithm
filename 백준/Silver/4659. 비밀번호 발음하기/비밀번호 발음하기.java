import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("end")) break;

            char[] c = str.toCharArray();
            boolean moeum = false;
            boolean result = true;
            int[] cnt = new int[2]; // 연속된 모음 자음
            for(int i=0;i<c.length;i++){
                if(c[i]=='a'||c[i]=='e'||c[i]=='i'||c[i]=='o'||c[i]=='u'){
                    moeum = true;
                    cnt[0]++;
                    cnt[1] = 0;
                }else{
                    cnt[1]++;
                    cnt[0] = 0;
                }
                if(cnt[0]==3 || cnt[1]==3){
                    result = false;
                    break;
                }

                if(i!=0 && c[i] == c[i-1]) {
                    if(c[i]=='e' || c[i]=='o')continue;
                        result = false;
                        break;
                }
            }
            if(!moeum || !result){
                sb.append("<"+str+"> is not acceptable.");
            }else{
                sb.append("<"+str+"> is acceptable.");
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

}