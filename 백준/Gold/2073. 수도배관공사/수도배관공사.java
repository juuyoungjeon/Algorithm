import java.util.*;
import java.io.*;

public class Main {
	static int D,P;
	static int[] L,C;
	static int[] dp;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		D = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		L = new int[P];
		C = new int[P];

		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			L[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[D+1];
		
		dp[0] = Integer.MAX_VALUE;
		for(int i = 0; i < P; i++) {
			for(int j = D; j >= L[i]; j--) {
				dp[j] = Math.max(dp[j], Math.min(dp[j - L[i]], C[i]));
			}
		}
		
		System.out.println(dp[D]);

	}


}