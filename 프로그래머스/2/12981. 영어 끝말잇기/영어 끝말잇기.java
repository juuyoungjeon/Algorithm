import java.util.*;
import java.io.*;

class Solution {
    static char a, b;
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int m = words.length;
        //사람별 새로운 문자 배열 만들기
        //1열 쫙 돌면서 마지막 문자, 첫번째 문자 맞는지 확인
        //다르면
        //1,1 hello 1,2 observe 1,3 effect i,j -> 첫번째게임, 몇번째 사람
        //2,1 recognize
        //출력은 j, i
        
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
        
        for(int i = 1; i < m; i++){
            if(list.contains(words[i]) || check(list.get(list.size() - 1), words[i])){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            list.add(words[i]);
        }

        return answer;
    }
    public static boolean check(String a, String b){
        if(a.charAt(a.length() - 1) == b.charAt(0)){
            return false;
        }
        
        return true;
        
    }
}