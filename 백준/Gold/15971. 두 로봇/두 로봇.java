import java.util.*;
import java.io.*;

public class Main {
	static int N, start, end;
	static ArrayList<ArrayList<Node>> list;
	static boolean[] visited;
	static int min = Integer.MIN_VALUE;
	static class Node{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		
		visited = new boolean[N+1];
		solve(start, 0, 0);
		
	}
	public static void solve(int depth, int sum, int max) {
		if(depth == end) {
			System.out.println(sum - max);;
			return;
		}
		
		visited[depth] = true;
		
		for(Node node : list.get(depth)) {
			if(!visited[node.idx]) {
				visited[node.idx] = true;
//				min = Math.min(min, sum);
				solve(node.idx, sum + node.cost, Math.max(max, node.cost));
				visited[node.idx] = false;
			}
		}
	}

}