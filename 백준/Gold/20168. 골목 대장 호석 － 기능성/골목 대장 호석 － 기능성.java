import java.util.*;
import java.io.*;

public class Main {
	static int N, M, A, B, C;
	static class Node{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	static ArrayList<ArrayList<Node>> list;
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		
		ans = Integer.MAX_VALUE;
		dfs(A, B, C, 0);
		System.out.println(ans == Integer.MAX_VALUE? -1 : ans);
	}
	
	public static void dfs(int cur, int dist, int money, int max) {
		if (cur == dist) {
			ans = Math.min(ans, max);
			return;
		}
		
		for(Node node : list.get(cur)) {
			int next = node.end;
			int cost = node.cost;
			if (visited[next]) {
				continue;
			}
			if (money < cost) {
				continue;
			}
			visited[next] = true;
			int nextMax = Math.max(max, cost);
			dfs(next, dist, money - cost, nextMax);
			visited[next] = false;
		}
	}

}