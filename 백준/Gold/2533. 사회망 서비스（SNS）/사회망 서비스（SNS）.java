import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] dp;
	static int ans;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		visited = new boolean[N+1];
		dp = new int[N+1][2];
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	public static void dfs(int idx) {
		visited[idx] = true;
		dp[idx][0] = 0;
		dp[idx][1] = 1;
		
		for(int i : list.get(idx)) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i);
				dp[idx][0] += dp[i][1];
				dp[idx][1] += Math.min(dp[i][0], dp[i][1]);
			}
		}
		
	}

}