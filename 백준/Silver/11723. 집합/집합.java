import java.util.*;
    import java.io.*;
    public class Main {
        public static void main(String[] agrs) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            int S = 0;
            for(int t=0;t<n;t++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int num = 0;
                if(!operation.equals("all") && !operation.equals("empty")){
                     num = Integer.parseInt(st.nextToken())-1;
                }

                switch(operation){
                    case "add" : S |= (1<<num); break;
                    case "remove" : S &= ~(1<<num); break;
                    case "check" :
                        sb.append((S & (1<<num)) != 0  ? "1" : "0").append('\n');
                        break;
                    case "toggle" : S ^= (1<<num); break;
                    case "all" :
                        S = (1<<20)-1;
                        break;
                    case "empty":
                        S = 0;
                        break;
                }
            }
            System.out.println(sb);
        }
    }