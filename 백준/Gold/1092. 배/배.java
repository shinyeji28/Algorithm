import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            crane[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] boxes = new Integer[m];
        for(int i=0;i<m;i++){
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());

        boolean[] isDone = new boolean[m];
        int time = 0;
        int doneCnt = 0;
        int[] pointer = new int[n];
        A : while(doneCnt < m){
            time++;
            int cnt = doneCnt;
            for(int i=0;i<n;i++){  // crane

                while(pointer[i] < m){
                    if(!isDone[pointer[i]] && crane[i] >= boxes[pointer[i]]){
                        isDone[pointer[i]] = true;
                        doneCnt++;
                        pointer[i]++;
                        break;
                    }
                    pointer[i]++;
                }
            }
            if(cnt == doneCnt){
                time = -1;
                break;
            }
        }


        System.out.println(time);
    }
}