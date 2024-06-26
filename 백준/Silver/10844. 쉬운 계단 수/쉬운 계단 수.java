import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Long[][] dp;
	final static long MOD = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		//dp[자릿수][자릿값]
		//12345 : 다섯번쨰 자릿수는 1, 네번쨰 자릿수는 2, 첫번째 자릿수는 5
		
		dp = new Long[N+1][10];
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1L;
		}
		
		long res = 0;
		
		for(int i = 1; i <= 9; i++) {
			res += recur(N, i);
		}
		
		System.out.println(res % MOD);
	}
	
	/*
	 * digit은 자릿수, val은 자릿값을 의미함
	 * 
	 * 첫째 자릿수는 각 val이 끝이기 떄문에
	 * 경우의 수는 1 밖에 없다. 즉, dp[1]의
	 * 각 자릿값은 1로 초기화 되어있어야한다.
	 */
	public static long recur(int digit, int val) {
		//첫째 자리수에 도착한다면 더이상 탐색할 필요없음
		if(digit == 1) {
			return dp[digit][val];
		}
		
		//해당 자리수의 val값에 대해 탐색하지 않았을 경우
		if(dp[digit][val] == null) {
			//val이 0일 경우 이전 자리는 1밖에 못옴
			if(val == 0) {
				dp[digit][val] = recur(digit - 1, 1);
			}
			//val이 9일 경우 이전 자리는 8밖에 못옴
			else if(val == 9) {
				dp[digit][val] = recur(digit - 1, 8);
			}
			//그 외의 경우는 val-1과 val+1 값의 경우의 수를 합한 경우의 수가 됨
			else {
				dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
			}
		}
		
	
		return dp[digit][val] % MOD;
	}

}