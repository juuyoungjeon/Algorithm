import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        
        if(set.size() > nums.length/2){
            answer = nums.length/2;
        }else{
            answer = set.size();
        }
        //answer = Math.max(set.size(), nums.length/2);
        return answer;
    }
}