import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		
		Arrays.fill(dp, -1);
		
		if(recur(N)) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
	}
	
	public static boolean recur(int cur) {
		if(cur < 0) {
			return true;
		}
		if(cur == 0) {
			return false;
		}
		
		if(dp[cur] != -1) {
			return dp[cur] == 1;
		}
		
		int cnt = 0;
		if(!recur(cur - 1)) {
			cnt++;
		}
		if(!recur(cur - 3)) {
			cnt++;
		}
		if(!recur(cur - 4)) {
			cnt++;
		}
		
		if(cnt > 0) {
			dp[cur] = 1;
		}else {
			dp[cur] = 0;
		}
		return cnt > 0;
	}

}