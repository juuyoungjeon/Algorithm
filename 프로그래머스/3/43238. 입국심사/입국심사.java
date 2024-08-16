import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long s = 0;
        long e = times[times.length - 1]* (long)n;
        while(s<=e){
            long mid = (s + e) / 2;
            long complete = 0;
            for(int i = 0; i < times.length; i++){
                complete += mid / times[i];
            }
            if(complete < n){
                s = mid + 1;
            }else {
                e = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}