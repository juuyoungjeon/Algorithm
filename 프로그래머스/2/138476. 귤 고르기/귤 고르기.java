import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int num : tangerine){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(hm.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int sum = 0;
        for (int v : list) {
            if (sum + v >= k) {
                answer++;
                break;
            } else {
                sum += v;
                answer++;
            }
        }

        //getOrdefault(key, default)
        //반환값은 key값이 존재하면 key값의 value를 리턴하고, 없으면 default를 반환한다.
        return answer;
    }
}

/*
1 3 2 5 4 5 2 3

1 2 2 3 3 4 5 5
3 2 5 5 2 3

1 - 1
2 - 2
3 - 2
4 - 1
5 - 2

1 2 2 1 2

6 만드는 법

재귀 -> list 길이 가장 짧은 거

*/