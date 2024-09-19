import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int result = 0;
        int prev = 0;
        Stack<Integer> q = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(q.isEmpty()) {
                result += prev;
                prev = 1;
            }

            char c = str.charAt(i);
            // ( -2 [ -3
            if(c == ')' || c == ']'){
                if(q.isEmpty() || (q.peek()==-2 && c==']') || (q.peek()==-3 && c==')')){
                    result = 0;
                    prev = 0;
                    break;
                }

                while(!q.isEmpty() && q.peek()>0){

                    prev += q.pop();
                }


                q.pop();
                if(c == ')' ){
                    prev *= 2;
                }else{
                    prev *= 3;
                }

            }else{
                if(prev!=1) {
                    q.push(prev);
                }
                prev = 1;
                if(c=='(')q.push(-2);
                else q.push(-3);
            }
        }
        if(!q.isEmpty()){
            result = 0;
        }else{
            result += prev;
        }
        System.out.println(result);
    }

}