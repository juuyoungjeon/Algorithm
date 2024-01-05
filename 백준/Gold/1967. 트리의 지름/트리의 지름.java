import java.util.*;
import java.io.*;

public class Main {

	static class Node{
		int index;
		int cost;
		
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}
	
	static ArrayList<Node> list[];
	static int N;
	static int ans;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for(int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Node>();
		}
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, len));
			list[to].add(new Node(from, len));
			
		}
		ans = 0;
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			visited[i] = true;
			dfs(i , 0);
		}
		System.out.println(ans);
	}
	private static void dfs(int index, int cost) {
		for(Node node : list[index]) {
			if(!visited[node.index]) {
				visited[node.index] = true;
				dfs(node.index, cost + node.cost);
			}
		}
		ans = (ans < cost)? cost : ans;
	}

}