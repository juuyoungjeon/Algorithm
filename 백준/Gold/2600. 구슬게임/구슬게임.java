import java.util.*;
import java.io.*;

public class Main {
	static int b1,b2,b3;
	static int k1,k2;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		b1 = Integer.parseInt(st.nextToken());
		b2 = Integer.parseInt(st.nextToken());
		b3 = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			k1 = Integer.parseInt(st.nextToken());
			k2 = Integer.parseInt(st.nextToken());
			
			dp = new int[501][501];
			for(int[] arr : dp) {
				Arrays.fill(arr, -1);
			}
			
			if(recur(k1, k2)) {
				sb.append("A").append("\n");
			}else {
				sb.append("B").append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static boolean recur(int cur1, int cur2) {
		if(cur1 < 0 || cur2 < 0) return true;
		
		if(cur1 == 0 && cur2 == 0) return false;
		
		if(dp[cur1][cur2] != -1) return dp[cur1][cur2] == 1;
		
		int ret = 0;
		
		if(!(recur(cur1 - b1, cur2))) {
			ret++;
		}
		if(!(recur(cur1 - b2, cur2))) {
			ret++;
		}
		if(!(recur(cur1 - b3, cur2))) {
			ret++;
		}
		if(!(recur(cur1, cur2 - b1))) {
			ret++;
		}
		if(!(recur(cur1, cur2 - b2))) {
			ret++;
		}
		if(!(recur(cur1, cur2 - b3))) {
			ret++;
		}
		
		if(ret > 0) {
			dp[cur1][cur2] = 1;
		}else {
			dp[cur1][cur2] = 0;
		}
		
		return ret > 0;
		
	}

}