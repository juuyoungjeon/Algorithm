import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        int[][] giftGraph = new int[N][N];
        int[] giftDegree = new int[N];
        
        HashMap<String, Integer> dic = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            dic.put(friends[i], i);
        }
        for(String gift:gifts){
            String[] giftName = gift.split(" ");
            giftDegree[dic.get(giftName[0])]++;
            giftDegree[dic.get(giftName[1])]--;
            giftGraph[dic.get(giftName[0])][dic.get(giftName[1])]++;
        }
        for(int i = 0; i < N; i++){
            int num = 0;
            for(int j = 0; j < N; j++){
                if(i==j){
                    continue;
                }
                if(giftGraph[i][j] > giftGraph[j][i] ||
                  (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])){
                    num++;
                }
            }
            if(answer < num){
                answer = num;
            }
        }
        
        return answer;
    }
}
//기록o -> 두사람 사이에 더많은 선물을 준 사람이 다음달에 하나 받음
//기록x or 주고받은수 같음 -> 선물지수 작은 사람이 큰사람한테 선물 하나 줌
//선물지수는 이번달까지 자신이 친구들에게 준 선물의 수 - 받은 선물의 수