import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length;
        Arrays.sort(people);
        
        //50 50 70 80
        
       
        
        int s = 0;
        int e = n-1;
        int cnt = 0;
       
        while(s < e){
            if(people[s] + people[e] <= limit){
                cnt++;
                s++;
                e--;
            }else{
                e--;
            }
        }
        
        answer = n - cnt;
        return answer;
    }
}