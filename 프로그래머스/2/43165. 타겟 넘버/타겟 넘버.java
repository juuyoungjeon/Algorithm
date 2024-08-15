class Solution {
    static int cnt;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        answer = cnt;
        
        return answer;
    }
    public static void dfs(int[] numbers, int target, int idx, int sum){
        
        if(idx == numbers.length){
             if(sum == target){
                cnt++;
                return;
             }
            return;
        }
        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}