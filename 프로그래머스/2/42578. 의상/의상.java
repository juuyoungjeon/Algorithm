import java.util.*;

class Solution {
    static int k;
    static int ans;
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        
        int n = clothes.length;
        int m = clothes[0].length;
        
        for(int i = 0; i < n; i++){
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1],0) + 1);
        }
        
        for(String key : hm.keySet()){
            answer *= (hm.get(key) + 1);
        }
        
        return answer - 1;
    }
}