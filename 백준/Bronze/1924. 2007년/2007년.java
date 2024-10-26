import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int m = 1;
        int d = 1;
        int dIdx = 1;

        int[] lastDayforMonth = new int[]{0, 31,28,31,30,31,30,31,31,30,31,30,31};
        String[] days = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int remainDay = 0;
        if(m > month){
            for(int i=month;i<=m;i++){
                remainDay += lastDayforMonth[i];
            }
            remainDay -= month;
            remainDay -= lastDayforMonth[m] - d;
        }else{
            for(int i=m;i<=month;i++){
                remainDay += lastDayforMonth[i];
            }
            remainDay -= m;

            remainDay -= lastDayforMonth[month] - day;

        }
        String answer = days[(dIdx + (remainDay % 7)) % 7];

        System.out.println(answer);
    }
}