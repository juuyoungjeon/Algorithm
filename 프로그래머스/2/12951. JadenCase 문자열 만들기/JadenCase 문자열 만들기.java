import java.util.*;
import java.io.*;
// 65 : A
// 97 : a
//공백으로 끊고 첫번째 문자가 97부터 122까지면 -32
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        
        
        for(int i = 0; i < arr.length; i++){
            String now = arr[i];
            
            //문자열의 길이가 0이라면(공백이라면)
            //answer에 " "만 추가
            if(arr[i].length() == 0){
                answer += " ";
            }else{
                answer += now.substring(0,1).toUpperCase();
                answer += now.substring(1, now.length()).toLowerCase();
                answer += " ";
            }
        }
        
        if(s.substring(s.length() - 1, s.length()).equals(" ")){
            return answer;
        }
        return answer.substring(0, answer.length() - 1);
    }
}