import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] agrs)throws IOException{
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int depth = 0;
        int num = 1;
        while(true){
            if(num >= input)break;

            depth++;
            num += 6 * depth;


        }
        System.out.println(depth+1);

    }
}