import java.util.*;
class Solution {  
   public int solution(int[][] land) {
       for(int i=1; i<land.length; i++){
           land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
           land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
           land[i][2] += Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][3]);
           land[i][3] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
       }

       int[] answer = land[land.length-1];
       Arrays.sort(answer);

       return answer[answer.length-1];
   }
}
// import java.util.*;

// class Solution {
//     static int max;
//     static int N;
//     int solution(int[][] land) {
//         int answer = 0;

//         N = land.length;
        
//         dfs(0,-1,0,land);

//         return answer = max;
//     }
//     public static void dfs(int depth, int prev, int sum, int[][] land){
//         if(depth == N){
//             max = Math.max(max, sum);
//             return;
//         }
//         for(int i = 0; i < 4; i++){
//             if(i == prev) continue;
            
//             dfs(depth + 1, i, sum + land[depth][i], land);
//         }
//     }
// }