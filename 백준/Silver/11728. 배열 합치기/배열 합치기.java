import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] aArr = new int[n];
         int[] bArr = new int[m];
         List<Integer> sortedList = new ArrayList<>();
         st = new StringTokenizer(br.readLine());
         for(int i=0;i<n;i++){
             aArr[i] = Integer.parseInt(st.nextToken());
         }
         st = new StringTokenizer(br.readLine());
         for(int i=0;i<m;i++){
             bArr[i] = Integer.parseInt(st.nextToken());
         }
         // 정렬
         Arrays.sort(aArr);
         Arrays.sort(bArr);

         // 투포인터
         int ap = 0;
         int bp = 0;
         while(bp < m){
             while(ap < n && aArr[ap] < bArr[bp]){
                 sortedList.add(aArr[ap]);
                 ap++;
             }
             sortedList.add(bArr[bp]);
             bp++;
         }
         while(ap < n){
            sortedList.add(aArr[ap]);
            ap++;
         }
         StringBuilder sb = new StringBuilder();
         for(Integer s : sortedList){
             sb.append(s+" ");
         }
         System.out.println(sb);
    }
}