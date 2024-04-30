import java.util.*;
import java.io.*;

public class Main {
	static int T, k;
	static int[][] coin, dp;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		k = Integer.parseInt(br.readLine());
		
		coin = new int[k][2];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i][0] = Integer.parseInt(st.nextToken());
			coin[i][1] = Integer.parseInt(st.nextToken());
		}
		dp = new int[k][T+1];
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < T; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(combi(0,0));
	}
	
	static int combi(int money, int type) {
		if(money == T) {
			return 1;
		}
		if(type == k || money > T) {
			return 0;
		}
		if(dp[type][money] != -1) {
			return dp[type][money];
		}
		int sum = 0;
		for(int i = 0; i < coin[type][1] + 1; i++) {
			int cost = coin[type][0] * i;
			sum += combi(money + cost, type + 1); 
		}
		return dp[type][money] = sum;
	}

}