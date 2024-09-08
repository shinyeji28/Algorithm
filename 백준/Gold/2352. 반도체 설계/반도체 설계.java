import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] to = new int[n];
        for(int i=0;i<n;i++){
            to[i] = Integer.parseInt(st.nextToken())-1;
        }

        List<Integer> sortingArray = new ArrayList<>();

        for(int i=0;i<n;i++){
            int idx = Collections.binarySearch(sortingArray, to[i]);
            if(idx < 0){
                idx = idx*(-1)-1;
            }
            if(idx >= sortingArray.size()) sortingArray.add(to[i]);
            else sortingArray.set(idx, to[i]);
        }
        System.out.println(sortingArray.size());
    }

}