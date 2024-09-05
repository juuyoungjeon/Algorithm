import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        solve(s,0,0);
        answer[0] = check;
        answer[1] = ans;
        return answer;
    }
    static int check;
    static int ans;
    public static void solve(String s, int time, int sum){
        if(s.equals("1")){
            check = time;
            ans = sum;
            return;
        }
        
        String str = "";
        int cnt = 0;
        int zero = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                cnt++;
            }
        }
        zero = s.length() - cnt;
        
        str = Integer.toBinaryString(cnt);
        
        solve(str, time + 1, sum + zero);
    }
}
//x의 모든 0을 제거한다 -> x의 길이를 c라고 하면 c를 2진법으로 표현한 문자열로 바꿈
//0111010 -> 1111 -> 4 -> 100