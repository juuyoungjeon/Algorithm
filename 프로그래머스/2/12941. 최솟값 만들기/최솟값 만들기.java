import java.util.*;
import java.io.*;

// 1 2 4
// 4 4 5

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        int N = A.length;
        int M = B.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0;
        int b = M - 1;
        while(a < N && b >= 0){
            answer += A[a++] * B[b--];
        }
        

        return answer;
    }
}