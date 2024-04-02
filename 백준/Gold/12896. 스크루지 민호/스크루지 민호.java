import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<ArrayList<Node>> list;
	static class Node{
		int end;
		int cost;
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	static int max;
	static int node;
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
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Node(v, 1));
			list.get(v).add(new Node(u, 1));
		}
		
		max = -1;
		visited = new boolean[N + 1];
		dfs(1, 0);
		
		max = -1;
		visited = new boolean[N + 1];
		dfs(node, 0);
		
		System.out.println((1+max)/2);
		
	}
	
	public static void dfs(int x, int len) {
		if(max < len) {
			max = len;
			node = x;
		}
		visited[x] = true;
		
		for(int i = 0; i < list.get(x).size(); i++) {
			Node next = list.get(x).get(i);
			if(!visited[next.end]) {
				dfs(next.end, len + next.cost);
				visited[next.end] = true;
			}
		}
	}

}