import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        
        
        Set<Integer> hs = new HashSet<>();
        
//         for(int i = 0; i < n; i++){
//             int sum = 0;
//             for(int j = 0; j < n; j++){
//                 sum += elements[(i+j) % n];
//                 hs.add(sum);
//             }
            
//         }
        for (int i=1; i<=n; i++) {
            for (int j=0; j<n; j++) {
                int sum = 0;
                for (int k=j; k<j+i; k++) {
                    sum += elements[k%elements.length];
                }
                hs.add(sum);
            }
        }
        answer = hs.size();
        
        return answer;
    }
}