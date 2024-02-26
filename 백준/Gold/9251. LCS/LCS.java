import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;
	static char[] arr1, arr2;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		arr1 = new char[s1.length()];
		
		for(int i = 0; i < s1.length(); i++) {
			arr1[i] = s1.charAt(i);
		}
		
		String s2 = br.readLine();
		arr2 = new char[s2.length()];
		
		for(int i = 0; i < s2.length(); i++) {
			arr2[i] = s2.charAt(i);
		}
		
		dp = new int[s1.length()][s2.length()];
		
		for(int i = 0; i < s1.length(); i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(LCS(s1.length() -1, s2.length() -1));
	}
	public static int LCS(int x, int y) {
		if(x == -1 || y == -1) {
			return 0;
		}
		if(dp[x][y] == -1) {
			dp[x][y] = 0;
			
			if(arr1[x] == arr2[y]) {
				dp[x][y] = LCS(x -1, y - 1) + 1;
			}
			
			if(arr1[x] != arr2[y]) {
				dp[x][y] = Math.max(LCS(x-1, y), LCS(x, y-1));
			}
		}
		return dp[x][y];
	}

}