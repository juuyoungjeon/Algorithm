import java.util.*;

//이분탐색 + hashset
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        
        Set<Integer> set = new HashSet<>();//형
        Map<Integer, Integer> map = new HashMap<>();//동생
        //map에 토핑종류와 갯수를 추가한다
        for(int t : topping){
            map.put(t, map.getOrDefault(t,0)+1);
        }
        for(int t : topping){
            //형은 원소를 추가한다.
            set.add(t);
            //동생은 원소를 뺀다
            map.put(t, map.get(t) - 1);
            if(map.get(t) == 0){//원소를 뺏을때 값이 0이면, Map에서 제거
                map.remove(t);
            }
            
            //가짓수가 같다면, 정답++
            if(set.size() == map.size()){
                answer++;
            }
        }
        return answer;
    }
    
}