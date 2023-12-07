    
    
    /*
        하나의 String1에 대해 또 다른 String2을 비교하는 방법
        str1[n]을 str2[n]과 비교하여 같으면 LCS의 길이가 길어진다.
        점화식:
        if(alph1[i] == alph2[j]){
            dp[i][j] = dp[i-1][j-1] + 1;  이전의 문자까지의 LCS 길이에 자신을 추가
        }else{
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 자신을 추가하지 못할 때 이전 문자까지의 LSC 중 큰 길이를 저장 
                                                         Max(이전의 문자까지의 LSC 길이, 자신과 다른 String2와의 비교까지의 LSC길이)   
        }
    */
import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        char[] alph1 = new char[str1.length()];
        char[] alph2 = new char[str2.length()];

        alph1 = str1.toCharArray();
        alph2 = str2.toCharArray();

        // 2차원 다이나믹 프로그래밍 사용
        int[][] dp = new int[alph1.length+1][alph2.length+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0) continue;
                
                if(alph1[i-1] == alph2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1; 
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
                }
            }
        }
        
        
        int result = dp[dp.length-1][dp[0].length-1];
        System.out.println(result);
        
        // 역순으로 LCS 출력
        if(result!=0){
            int i = dp.length-1;
            int j = dp[0].length-1;
            Stack<String> lcs = new Stack<>(); 

            while(result != lcs.size()){
                if(alph1[i-1]==alph2[j-1]){
                    lcs.push(alph1[i-1]+"");
                    i -= 1;
                    j -= 1;
                }else{
                    if(dp[i-1][j]> dp[i][j-1]){
                        i -= 1;
                    }else{
                        j -= 1;
                    }
                }
            }
            while(!lcs.isEmpty()){
                System.out.print(lcs.pop());
            }
        }
        
    }
}