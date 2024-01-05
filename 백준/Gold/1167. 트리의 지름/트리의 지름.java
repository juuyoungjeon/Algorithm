import java.util.*;
import java.io.*;

public class Main {

	static class Node{
		int end, cost;
		
		public Node(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
	}
		static ArrayList<Node>[] list;
		static boolean[] visited;
		static int max = 0;
		static int node;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int v = Integer.parseInt(br.readLine());
		list = new ArrayList[v+1];
		visited = new boolean[v+1];
		for(int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			while(true) {
				int end = Integer.parseInt(st.nextToken());
				if(end == -1) break;
				int cost = Integer.parseInt(st.nextToken());
				list[start].add(new Node(end, cost));
			}
		}
		
		visited = new boolean[v+1];
		dfs(1,0);
		
		visited = new boolean[v+1];
		dfs(node,0);
		
		System.out.println(max);
		
	}

	private static void dfs(int x, int len) {
		if(len > max) {
			max = len;
			node = x;
		}
		visited[x] = true;
		
		for(int i = 0; i < list[x].size(); i++) {
			Node n = list[x].get(i);
			if(visited[n.end] == false) {
				dfs(n.end, n.cost + len);
				visited[n.end] = true;
			}
		}
	}

}