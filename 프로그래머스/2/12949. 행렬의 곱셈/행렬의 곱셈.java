class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        
        int[][] answer = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < arr1[i].length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}
/* 3 2 2 2
1 4    3 3       15 15
3 2    3 3       15 15
4 1              15 15

  0 1
0
1
(0,0)*(0,0) + (0,1)*(1,0)      (0,0)*(0,1) + (0,1)*(1,1)
(1,0)*(0,0) + (1,1)*(1,0)      (1,0)*(0,1) + (1,1)*(1,1)

2 2   3 3
2 2   3 3



3 + 12 


*/