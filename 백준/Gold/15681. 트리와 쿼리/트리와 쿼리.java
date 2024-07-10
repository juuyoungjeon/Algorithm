import java.util.*;
import java.io.*;


public class Main {
	static int N,R,Q;
	static boolean[] visited;
	static int[] dp;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		dp = new int[N+1];
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		visited[R] = true;
		solve(R);
		
		for(int i = 0; i < Q; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	public static int solve(int idx) {
		visited[idx] = true;
		int cnt = 1;
		for(int i : list.get(idx)) {
			if(!visited[i]) {
				visited[i] = true;
				cnt += solve(i);
			}
		}
		
		return dp[idx] = cnt;
		
	}

}