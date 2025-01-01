/*
* stack
* 폭탄 문자열의 끝 문자와 같으면 while(폭탄 문자열과 같다면 pop), 아니면 push (O(100,000))
* */

import java.util.*;
import java.io.*;
public class Main{

    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        char[] origins = str.toCharArray();     // String.charAt()은 내부적으로는 배열로 구현되어 O(1)이지만, 메소드를 부르는 것임으로 오버헤드가 존재

        st = new StringTokenizer(br.readLine());
        char[] bomb = st.nextToken().toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i<origins.length){
            stack.push(origins[i]);          // 문자 push
            int bombIdx = bomb.length-1;
            if(stack.peek()==bomb[bombIdx]) {
                Stack<Character> tempStack = new Stack<>();

                while (bombIdx >= 0 && !stack.isEmpty() && stack.peek() == bomb[bombIdx]) {  // 폭탄 문자 끝부터 비교해서 같다면 폭탄 문자열이 맞는지 확인
                    tempStack.push(stack.pop());
                    bombIdx--;
                }
                if (bombIdx >= 0) {  // 폭탄 문자열이 아니라면 다시 넣기
                    while(!tempStack.isEmpty()){
                        stack.push(tempStack.pop());
                    }
                }
            }
            i++;

        }
        if(stack.isEmpty()){
            sb.append("FRULA");
        }else{
            while(!stack.isEmpty()){
                sb.append(stack.pop().toString());
            }
            sb.reverse();
        }
        System.out.println(sb);


    }
}