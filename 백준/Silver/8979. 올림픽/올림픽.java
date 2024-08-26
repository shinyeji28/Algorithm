import java.util.*;
import java.io.*;
public class Main {
    static int k;
    public static class Node{
        int num;
        int g,s,d;
        public Node(int num, int g, int s, int d){
            this.num = num;
            this.g=g;
            this.s=s;
            this.d=d;
        }
    }
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Node[] order = new Node[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            order[i] = new Node(num,g,s,d);
        }

        Arrays.sort(order, (a,b)->{
            if(a.g==b.g){
                if(a.s==b.s){
                    return b.d-a.d;
                }
                return b.s-a.s;
            }
            return b.g - a.g;
        });

        int grade = 1;
        int prev = 1;
        for(int i=1;i<n;i++){
            if(order[i].num==k)break;
            grade++;

            if(i!=0 && (order[i].g==order[i-1].g) && (order[i].s==order[i-1].s) && (order[i].d==order[i-1].d)){
            }else{
                prev = grade;
            }
        }

        System.out.println(prev);
    }

}