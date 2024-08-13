import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//O를 출석, L을 지각, A를 결석
		//지각(L) 두번 이상, 결석(A) 세번 연속
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new int[N+1][3][4];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 4; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		System.out.println(solve(0,0,0));
	}
	//문자길이, L의 갯수, 연속한 A 수
	public static int solve(int str, int l, int a) {
		if(l > 1 || a == 3) return 0;
		if(str > N-1) return 1;

		if(dp[str][l][a] != -1) return dp[str][l][a];
		dp[str][l][a] = 0;

		dp[str][l][a] = solve(str+1,l+1,0) + solve(str+1,l,a+1) + solve(str+1,l,0);
		return dp[str][l][a] % 1_000_000;

	}

}