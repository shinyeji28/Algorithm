import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x=0;
        int y = 0;
        int maxValue = 0;
        for(int i=0;i<9;i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++) {
                int input = Integer.parseInt(st.nextToken());
                if(maxValue<input){
                    x = i;
                    y = j;
                    maxValue = input;
                }
            }
        }
        System.out.println(maxValue);
        System.out.println((x+1)+" "+(y+1));
    }
}