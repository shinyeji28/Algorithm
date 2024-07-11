/*
* 조합 : M개 뽑기 (N*N)CM
* 뽑은 치키집과 집만큼 돌리기 O(2N * M)
* */

import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    public static class Node{
        int x,y;
        public Node(int x,int y){
            this.x =x;
            this.y=y;
        }
    }
    static List<Node> houses;
    static List<Node> chickens;
    static int result = Integer.MAX_VALUE;
    static Node[] pick;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pick = new Node[m];
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 1) houses.add(new Node(i,j));
                else if(input ==2) chickens.add(new Node(i,j));
            }
        }
        combination(0,0);
        System.out.println(result);
    }
    public static void combination(int start, int depth){
        if(m==depth){
            int sum = 0;
            for(Node house : houses){
                int minDistance = Integer.MAX_VALUE;
                for(int j=0;j<pick.length;j++){
                    int distance = Math.abs(house.x - pick[j].x) + Math.abs(house.y - pick[j].y);
                    minDistance = Math.min(minDistance, distance);
                }
                sum += minDistance;
                if(sum >= result)return;
            }
            result = Math.min(result, sum);
            return;
        }
        for(int i=start;i<chickens.size();i++){
            pick[depth] = chickens.get(i);
            combination(i+1, depth+1);
        }
    }
}