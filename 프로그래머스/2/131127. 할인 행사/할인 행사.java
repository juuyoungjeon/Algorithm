class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
//         int n = discount.length;
//         int m = want.length;
        
//         int[] arr = new int[m];
//         int cnt = 0;
        
//         int idx = 0;
//         while(idx < n - 9){
//             cnt = 0;
//             for(int i = idx; i < idx + 10; i++){
//                 for(int j = 0; j < m; j++){
//                     if(discount[i].equals(want[j])){
//                         arr[j]++;
//                     }
//                 }
//             }
//             idx++;
            
//             for(int i = 0; i < m; i++){
//                 if(number[i] == arr[i]){
//                     cnt++;
//                 }
//             }
            
//             if(cnt == m) answer++;
//         }
        
        for(int i=0; i<discount.length-9; i++) {
        	int cntday = 0;
        	for(int j=0; j<want.length; j++) {
        		int cnt = 0;
        		for(int k=i; k<i+10; k++) {
        			if(discount[k].equals(want[j])) cnt++;       			
        		}
        		if(cnt<number[j]) break;
        		else cntday++;
        	}
        	if(cntday == want.length) answer++;
        }
        return answer;
    }
}