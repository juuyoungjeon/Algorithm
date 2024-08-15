import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int A, B;
	// A는 가능한 요양신청횟수, B는 정독실과 소학습실 합쳐 필수적으로 자습해야하는 횟수
	static int[] p,q,r,s;
	// 정독실, 소학습실, 휴게실, 방(요양)
	// 휴게실에서 이틀 연속 x
	// 정독실이나 소학습실에서 자습 B회미만 x
	static int[][][][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		p = new int[N];
		q = new int[N];
		r = new int[N];
		s = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			q[i] = Integer.parseInt(st.nextToken());
			r[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}
		//현재 휴게실(사용했?1 안했?0) 요양 공부
		dp = new int[101][2][101][101];
		
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < 101; k++) {
					for(int l = 0; l < 101; l++) {
						dp[i][j][k][l] = -1;
					}
				}
			}
		}
		
		System.out.println(solve(0,0,0,0));
	}
	
	public static int solve(int cur, int prev, int rest, int study) {
		if(cur == N) {
			if(study < B) {
				return -999999;
			}
			return 0;
		}
		//요양가능 신청 넘어가면
//		if(rest > A) return -999999;

		
		if(dp[cur][prev][rest][study] != -1) return dp[cur][prev][rest][study];
		dp[cur][prev][rest][study] = -9999999;
		
		if(rest < A) {
			dp[cur][prev][rest][study] = Math.max(dp[cur][prev][rest][study], solve(cur+1, 0, rest+1, study) + s[cur]);
			
		}
		
		//휴게실 이용안했으면
		if(prev == 0) {
			dp[cur][prev][rest][study] = Math.max(dp[cur][prev][rest][study], solve(cur+1, 1, rest, study) + r[cur]);
		}
		
		//요양신청
//		dp[cur][prev][rest][study] = Math.max(dp[cur][prev][rest][study], solve(cur+1, 0, rest+1, study) + s[cur]);
		
		//정독실 자습
		dp[cur][prev][rest][study] = Math.max(dp[cur][prev][rest][study], solve(cur+1, 0, rest, study + 1) + p[cur]);
		
		//소학습실 자습
		dp[cur][prev][rest][study] = Math.max(dp[cur][prev][rest][study], solve(cur+1, 0, rest, study + 1) + q[cur]);
		
		return dp[cur][prev][rest][study];
		
	}

}