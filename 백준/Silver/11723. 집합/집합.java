import java.util.*;
    import java.io.*;
    public class Main {
        public static void main(String[] agrs) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            boolean[] S = new boolean[21];
            for(int t=0;t<n;t++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int num = 0;
                if(!operation.equals("all") && !operation.equals("empty")){
                     num = Integer.parseInt(st.nextToken());
                }

                switch(operation){
                    case "add" : S[num] = true; break;
                    case "remove" : S[num] = false; break;
                    case "check" :
                        if(S[num])sb.append("1");
                        else sb.append("0");
                        sb.append('\n');
                        break;
                    case "toggle" : S[num] = !S[num]; break;
                    case "all" :
                        for(int i=1;i<=20;i++){S[i] = true;}
                        break;
                    case "empty":
                        for(int i=1;i<=20;i++){S[i] = false;}
                        break;
                }
            }
            System.out.println(sb);
        }
    }