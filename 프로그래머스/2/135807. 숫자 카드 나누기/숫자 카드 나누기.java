/*
    A배열의 최대 공약수
    B배열의 최대 공약수
    하나
*/
import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = findGcd(arrayA);
        int gcdB = findGcd(arrayB);
                
        for(int num : arrayB){
            if(num % gcdA == 0){
                gcdA = 0;
                break;
            }
        }
        
        for(int num : arrayA){
            if(num % gcdB == 0){
                gcdB = 0;
                break;
            }
        }
        
        return Math.max(gcdA, gcdB);
    }
    public static int findGcd(int[] array){
        int result = array[0];
        for(int i=1;i<array.length;i++){
            if(result<array[i]) result = gcd(array[i], result);
            else result = gcd(result, array[i]);
        }
        return result;
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}