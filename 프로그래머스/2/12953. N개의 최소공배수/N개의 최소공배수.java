import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int N = arr.length;
    
        
        answer = arr[0];
        for(int i = 1; i < N; i++){
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
//     public static int gcd(int a, int b){
//         if(a % b == 0)
//             return b;
//         return gcd(b, a % b);
//     }
    
//     public static int lcm(int a, int b){
//         return a * b / gcd(a, b);
//     }
    // 최대공약수
    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
 
    // 최소공배수
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}