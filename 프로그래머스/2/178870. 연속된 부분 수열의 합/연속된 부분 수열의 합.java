import java.util.*;

//누적합
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int sum = 0;
        int left = 0;
        int size = sequence.length;
        
        for(int right = 0; right < sequence.length; right++){
            sum += sequence[right];
            while(sum > k){
                sum -= sequence[left];
                left++;
            }
            if(sum == k){
                if(size > right - left){
                    size = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        
        
        
        
        return answer;
    }
}