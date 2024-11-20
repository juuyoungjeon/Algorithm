import java.util.*;
import java.io.*;

public class Main {
	static int w,h;
	static int ans;
	static int[][][][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		dp = new int[w + 1][h + 1][2][2];
		
		for(int[][][] i : dp) {
			for(int[][] j : i) {
				for(int[] k : j) {
					Arrays.fill(k, -1);
				}
			}
		}
		
		System.out.println((dfs(1,1,0,0) + dfs(1,1,1,0)) % 100000);
	}
	public static int dfs(int x, int y, int t, int check) {
		if(x == w && y == h) return 1;
		
		if(x < 1 || y < 1 || x > w || y > h) {
			return 0;
		}
		
		if(dp[x][y][t][check] != -1) return dp[x][y][t][check];
		
		dp[x][y][t][check] = 0;
		
		if(t == 1) {
			if(check == 1) {
				dp[x][y][t][check] = (dp[x][y][t][check] + dfs(x,y+1,t,check) + dfs(x+1,y,1-t,1-check)) % 100000;
			}else {
				dp[x][y][t][check] = (dp[x][y][t][check] + dfs(x,y+1,t,1 - check)) % 100000;
			}
		}else {
			if(check == 1) {
				dp[x][y][t][check] = (dp[x][y][t][check] + dfs(x+1,y,t,check) + dfs(x,y+1,1-t,1-check)) % 100000;
			}else {
				dp[x][y][t][check] = (dp[x][y][t][check] + dfs(x+1,y,t,1 - check)) % 100000;
			}
			
		}
		return dp[x][y][t][check];
		
		
	}

}