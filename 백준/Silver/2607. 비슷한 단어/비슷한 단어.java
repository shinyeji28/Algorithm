import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] firstWord = new int[26];
        int result = 0;
        int firstSum = 0;

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int[] secondWord = new int[26];
            int secondSum = 0;

            for(int j=0;j<str.length();j++){
                int idx = str.charAt(j) - 'A';
                if(i==0){
                    firstWord[idx]++;
                    firstSum++;
                }else{
                    secondWord[idx]++;
                    secondSum++;
                }
            }
            if(i==0)continue;

            int plusOne = 0;
            int minusOne = 0;
            int totalDiff = 0;
            for(int j=0;j<26;j++){
                int diff = firstWord[j] - secondWord[j];
                if(diff == 1){
                    plusOne++;
                }else if(diff == -1){
                    minusOne++;
                }
                if(diff!=0){
                    totalDiff += Math.abs(diff);
                }
            }
            if(totalDiff==0 || (plusOne == 1 && minusOne==0 && totalDiff==1) || (plusOne==0 && minusOne==1 && totalDiff==1) || (plusOne==1&&minusOne==1&&totalDiff==2)) result++;
        }

        System.out.println(result);

    }
}