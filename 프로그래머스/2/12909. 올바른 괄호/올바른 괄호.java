import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        
        int N = arr.length;
        
        answer = solve(arr, N);
        
        return answer;
    }
    public static boolean solve(char[] arr, int N){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < N; i++){
            if(arr[i] == '('){
                stack.push(arr[i]);
            }else if(stack.isEmpty()){
                return false;
            }else{
                stack.pop();
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}