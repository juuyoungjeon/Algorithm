class Solution {
    public int[] solution(int n, long left, long right) {
        
        /*
        1 2 3
        2 2 3
        3 3 3
        
        0 1 2 3 4 5 6 7 8
        1 2 3 2 2 3 3 3 3
        
          0 1 2 3 4
        0 1 2 3 4 5
        1 2 2 4 4 5
        2 3 3 3 4 5
        3 4 4 4 4 5
        4 5 5 5 5 5
        */
        int len = (int)right - (int)left;
        int[] answer = new int[len+1];
        
        //행과열중에서 큰거 + 1
        int idx = 0;
        for(long i = left; i <= right; i++){
            long row = i / n;//행
            long col = i % n;//열
            answer[idx++] = Math.max((int)row, (int)col) + 1;
            
        }
        
        return answer;
    }
}