import java.util.*;
import java.io.*;

public class Main {
	static int w, h;
	static int[][][][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//t : 현재진행방향 0->x / 1 ->y
		//check : 방향변경여부 0 ->변경불가 / 1 -> 변경가능
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		dp = new int[w+1][h+1][2][2];
		for(int i = 1; i <= w; i++) {
			for(int j = 1; j <= h; j++) {
				Arrays.fill(dp[i][j][0], -1);
				Arrays.fill(dp[i][j][1], -1);
				
			}
		}
		
		System.out.println((func(1,1,0,0) + func(1,1,1,0)) % 100000);
	}

	static int func(int x, int y, int t, int check) {
		if(x <= 0 || y <= 0 || x > w || y > h) {
			return 0;
		}
		if(x == w && y == h) {
			return dp[x][y][t][check] = 1;
		}
		if(dp[x][y][t][check] != -1) {
			return dp[x][y][t][check];
		}
		dp[x][y][t][check] = 0;
		
		if(t == 1) {
			if(check == 1) {
				dp[x][y][t][check] = (dp[x][y][t][check] + func(x,y+1,t,check) + func(x+1,y,1-t,1-check)) % 100000;
			}else {
				dp[x][y][t][check] = (dp[x][y][t][check] + func(x,y+1,t,1-check)) % 100000;
			}
		}else {
			if(check == 1) {
				dp[x][y][t][check] = (dp[x][y][t][check] + func(x+1,y,t,check) + func(x,y+1,1-t,1-check)) % 100000;
			}else {
				dp[x][y][t][check] = (dp[x][y][t][check] + func(x+1,y,t,1-check)) % 100000;
			}
			
		}
		return dp[x][y][t][check];
	}
}