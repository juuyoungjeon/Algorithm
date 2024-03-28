import java.util.*;
import java.io.*;

public class Main {
	static int N, R, Q;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		dp = new int[N + 1];
		visited = new boolean[N + 1];
		visited[R] = true;
		dfs(R);

		
		for(int i = 0; i < Q; i++) {
			int node = Integer.parseInt(br.readLine());
			
			sb.append(dp[node]).append("\n");
		}

		System.out.println(sb);
	}
	
	public static int dfs(int index) {
		int cnt = 1;
		for(int i : list.get(index)) {
			if(!visited[i]) {
				visited[i] = true;
				cnt += dfs(i);
			}
		}
		
		return dp[index] = cnt;
	}

}