import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // 1, 2 -> 1
        // 3, 4 -> 2
        // 5, 6 -> 3
        
        // 나누기 2 -> % 2 == 0 그대로 / % 2 == 1 이면 + 1 -> 라운드 증가
        // static Node 만들어서 계속 갱신
        
        // 4 2 1 / 8 4 2
        // 6 34 2
        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        
        return answer;
    }
    static ArrayList<Node> list = new ArrayList<>();
    static class Node{
        int a;//원래 idx
        int b;
        public Node(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}