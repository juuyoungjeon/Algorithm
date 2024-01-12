import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String p : participant){
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }
        
        for(String p : completion){
            hm.put(p, hm.get(p) - 1);
        }
        
        for(String key : hm.keySet()){
            if(hm.get(key) != 0){
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}