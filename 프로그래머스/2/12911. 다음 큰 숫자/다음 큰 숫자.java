import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int cnt = Integer.bitCount(n);
        
        while(true){
            n++;
            int nextCnt = Integer.bitCount(n);
            
            if(cnt == nextCnt){
                break;
            }
        }
        
        answer = n;
        return answer;
    }
}