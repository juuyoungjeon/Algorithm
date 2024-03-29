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
	static ArrayList<ArrayList<Node>> list;
	static boolean[] visited;
	static int ans;
	static int[] cost;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		visited = new boolean[n + 1];
		cost = new int[n + 1];
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		int max = 0;
        ans = 0;
		for(int i = 1; i <= n; i++) {
			
			visited = new boolean[n+1];
			dfs(i, 0);
		}
		System.out.println(ans);
		
	}
	
	public static void dfs(int start, int sum) {
		visited[start] = true;
		ans = (ans < sum) ? sum : ans;
		for(Node next : list.get(start)) {
			if(!visited[next.index]) {
				dfs(next.index, sum + next.cost);
			}
		}
	}

}