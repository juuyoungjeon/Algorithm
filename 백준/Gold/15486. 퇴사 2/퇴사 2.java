import java.util.*;
import java.io.*;

public class Main {
	static int N, max;
	static int[] T,P;
	static int[] DP;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		T = new int[N + 2];
		P = new int[N + 2];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		DP = new int[N + 2];
		
		for(int i = 1; i < N + 2; i++ ) {
			if(max < DP[i]) {
				max = DP[i];
			}
			
			int day = i + T[i];
			if(day < N + 2) {
				DP[day] = Math.max(DP[day], max + P[i]);
			}
		}
		
		System.out.println(max);

	}

}