import java.util.*;
import java.io.*;

public class Main {
	static int N, L, R, X;
	static int[] A;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		dfs(0,0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(cnt);
	}
	static int cnt;
	public static void dfs(int depth, int sum, int max, int min) {
		if(depth >= 2) {
			if(L <= sum && sum <= R && max - min >= X) {
					cnt++;
			}
		}
		for(int i = depth; i < N; i++) {
			dfs(i + 1, sum + A[i], Math.max(max, A[i]), Math.min(min, A[i]));
		}
	}

}