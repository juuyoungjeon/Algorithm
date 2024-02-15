import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] DP = new int[n+1][3];
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2])+r;
			DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2])+g;
			DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1])+b;
			
		}
		System.out.println(Math.min(DP[n][0], Math.min(DP[n][1], DP[n][2])));
	}

}