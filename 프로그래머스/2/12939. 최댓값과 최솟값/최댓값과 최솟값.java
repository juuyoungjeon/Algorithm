import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        
        int N = str.length;
        
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
            
        }
        
        Arrays.sort(arr);
        
        answer += arr[0] + " ";
        answer += arr[N-1];
        
        return answer;
    }
}