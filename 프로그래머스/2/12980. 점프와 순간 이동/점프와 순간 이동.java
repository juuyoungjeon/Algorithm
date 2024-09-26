import java.util.*;

//K칸 점프 -> 건전지 K만큼 듬
// 현재까지 거리 * 2 순간이동 -> 건전지 사용량 안줄어듬 -> 이게 더 효율적

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n != 0) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }
        
        return ans;
    }
    
}