import java.util.*;
import java.io.*;

public class Main {
	static final int MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int[] dp = new int[4];
		for(int i = 0; i < N; i++) {
			switch(s.charAt(i)) {
			case 'W' : dp[0]++; dp[0] %= MOD; break;
			case 'H' : dp[1]+=dp[0]; dp[1] %= MOD; break;
			case 'E' :
				dp[3] *= 2; dp[3] %= MOD;
				dp[3] += dp[2]; dp[3] %= MOD;
				dp[2] += dp[1]; dp[2] %= MOD;
				break;
			}
		}
		
		System.out.println(dp[3]);
	}

}