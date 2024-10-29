import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int[] days = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            days[i] = (100 - progresses[i]) / speeds[i];
            if((100-progresses[i]) % speeds[i] != 0){
                days[i]++;
            }
        }
        
        int x = days[0];
        int cnt = 1;
        for(int i = 1; i < progresses.length; i++){
            if(x >= days[i]){
                cnt++;
            }else{
                list.add(cnt);
                cnt = 1;
                x = days[i];
            }
        }
        list.add(cnt);
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}