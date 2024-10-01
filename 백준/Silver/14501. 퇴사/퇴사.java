import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] T,P;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		T = new int[N];
		P = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
			
		}
		
		solve(0,0);
		
		System.out.println(max);
	}
	public static void solve(int day, int sum) {
		if(day == N) {
			max = Math.max(max, sum);
			return;
		}
		if(day + T[day] <= N) {
			solve(day + T[day], sum + P[day]);
		}
		
		solve(day + 1, sum);
	}
}