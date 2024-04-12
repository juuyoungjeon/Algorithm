import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,1);
		System.out.println(ans);
	}
	static int ans = Integer.MIN_VALUE;
	public static void dfs(int depth, int idx, int sum) {
		if(depth == M || idx >= N) {
			ans = Math.max(ans, sum);
			return;
		}
		if(idx <= N - 1) {
			dfs(depth+1, idx+1, sum + arr[idx+1]);
			
		}
		if(idx <= N -2) {
			
			dfs(depth+1, idx+2, sum/2 + arr[idx+2]);
		}
		
	}

}